import socket
import numpy as np
import time
from colorama import Fore, Style
import datetime
import re


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
        return None


def server():
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
        seq = result[1]
        frame = result[0]

        control = np.random.choice([1, 0, -1], p=[0.5, 0.25, 0.25])

        if control == 1:  # Successful Transmission
            print(Fore.GREEN + f"SENDER's RECEIVER: |ACK for frame {frame}|\n" + Style.RESET_ALL)
            conn.sendall(f"RECEIVER: |Ack{seq}|".encode())
            data_rec.append(seq)

        elif control == 0:  # Negative acknowledgement case
            print(Fore.RED + f"SENDER'S RECEIVER: |NAK{seq}|\n" + Style.RESET_ALL)
            data_rec.append(seq)

        elif control == -1:
            print(Fore.RED + f"SENDER'S RECEIVER: Not Received! \n" + Style.RESET_ALL)

        time.sleep(0.5)


data_rec = []

ip = "192.168.10.89"
port = 8000

server()