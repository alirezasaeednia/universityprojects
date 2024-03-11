import socket
import numpy as np
import time
from colorama import Fore, Style
import datetime
import re

totalFrames = 5
windowSize = 2


def extract_values(input_string):
    print(input_string)
    if input_string == "TERMINATE":
        exit()
    pattern = r'\(Frame(\d+)\),\(Seq(\d+)\),\((.*?)\)'
    match = re.match(pattern, input_string)
    if match:
        frame_num = int(match.group(1))
        i = int(match.group(2))
        data_i = match.group(3)
        return frame_num, i, data_i
    else:
        print("x", input_string)
        return None


def server():
    now = datetime.datetime.now()
    seq = 0  # sequence index(0, total_frames)
    ack = 0  # ack pointer - (seq+1) % windowSize
    f = 0  # frame pointer - seq % windowSize
    base = 0  # base value of the window
    frame_num = 0  # frame index inside the window
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((ip, port))
    s.listen()
    conn, x = s.accept()
    while True:
        data = conn.recv(1024).decode()
        result = extract_values(data)
        if result is None:
            continue

        data_i = result[2]
        ack = result[1]

        #ack = (seq + 1) % windowSize
        #f = seq % windowSize

        #control = 0
        control = np.random.choice([0, 1, 2, 3, 4, 5], p=[0.5, 0.1, 0.1, 0.1, 0.1, 0.1])  # case control
        if control == 0:  # Successful Transmission
            print(Fore.GREEN + f"RECEIVER: Received.... |(Frame{f}),(Seq{seq}),({data_i})|")
            print(f"RECEIVER: |Ack{ack}|")
            print(f"SENDER's RECEIVER: |Ack{ack}|.... Delete copy of tx frame and slide window!\n" + Style.RESET_ALL)
            conn.sendall(f"RECEIVER: |Ack{ack}|".encode())

            seq += 1
            base += 1

        elif control == 1:  # Frame Corrupted Case
            corrupt = ''.join(np.random.choice(["0", "1"]) for _ in range(8))  # Corruption
            print(Fore.MAGENTA + f"RECEIVER: Received.... |(Frame{f}),(Seq{seq}),({corrupt})|")
            checkSum = sum(list(map(int, data_i[seq])))  # sum of transmitted frame
            sumValue = sum(list(map(int, corrupt)))  # sum of received frame
            print(f"Check Sum: {checkSum}, Sum of Corrupt frame: {sumValue}")

            if checkSum != sumValue:  # Checksum process
                print("RECEIVER: Received Corrupted Frame.... Discard frame!")
            else:
                print("RECEIVER: Checksum - False Posqitive.... Discard frame!")

            print(
                Fore.RED + f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Frame Corrupted)\n" + Style.RESET_ALL)
            conn.sendall(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Frame Corrupted)\n".encode())

        elif control == 2:  # Frame lost case
            print(Fore.RED + f"RECEIVER: Not Received.... |(Frame{f}),(Seq{seq}),({data_i})|")
            print(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Frame lost)\n" + Style.RESET_ALL)
            conn.sendall(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Frame lost)\n".encode())

        elif control == 3:  # Frame delayed case
            print(Fore.RED + f"RECIEVER: Not Received.... |(Frame{f}),(Seq{seq}),({data_i})|")
            print(f"SENDER's RECIEVER: Timeout!! |Ack{ack}| Not Received (Frame delayed)\n" + Style.RESET_ALL)
            conn.sendall(f"SENDER's RECIEVER: Timeout!! |Ack{ack}| Not Received (Frame delayed)\n".encode())

        elif control == 4:  # Acknowledgement case
            print(Fore.RED + f"RECEIVER: Received.... |(Frame{f}),(Seq{seq}),({data_i})|")
            print(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Acknowledgement lost)\n" + Style.RESET_ALL)
            conn.sendall(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Acknowledgement lost)\n".encode())

        elif control == 5:  # Acknowledgement lost case
            print(Fore.RED + f"RECEIVER: Received.... |(Frame{f}),(Seq{seq}),({data_i})|")
            print(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Acknowledgement delayed)\n" + Style.RESET_ALL)
            conn.sendall(f"SENDER's RECEIVER: Timeout!! |Ack{ack}| Not Received (Acknowledgement delayed)\n".encode())

        time.sleep(1)


ip = "127.0.0.1"
port = 8119

server()
