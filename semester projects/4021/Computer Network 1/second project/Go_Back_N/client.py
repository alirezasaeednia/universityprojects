import socket
import numpy as np
import time

import select
from colorama import Fore, Style
import datetime
import re


def extract_ack(string):
    pattern = r'RECEIVER: \|Ack(\w+)\|'
    match = re.search(pattern, string)
    if match:
        ack = match.group(1)
        return ack
    else:
        return -1


def check_ack(string):
    pattern = r'RECEIVER: \|Ack(\w+)\|'
    return bool(re.search(pattern, string))


def client(data):
    now = datetime.datetime.now()
    seq = 0  # sequence index(0, total_frames)
    ack = 0  # ack pointer - (seq+1) % windowSize
    f = 0  # frame pointer - seq % windowSize
    base = 0  # base value of the window
    frame_num = 0  # frame index inside the window

    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((ip, port))

    while seq < totalFrames:
        added_value = 0
        print(base, min(base + windowSize, totalFrames))
        for i in range(base, min(base + windowSize, totalFrames)):
            frame_num = i % windowSize
            print(Fore.YELLOW + f"SENDER: Transmitting.... |(Frame{frame_num}),(Seq{i}),({data[i]})|" + Style.RESET_ALL)
            s.sendall(f"(Frame{frame_num}),(Seq{i}),({data[i]})".encode())
            time.sleep(0.5)
            # Wait for ack with timeout

            ready = select.select([s], [], [], timeout)
            if ready[0]:
                ack = s.recv(1024).decode()
                ack_seq = extract_ack(ack)
                if int(ack_seq) == seq:
                    seq += 1
                    added_value += 1
            else:
                # Timeout occurred, repeat the while loop
                print("Timeout occurred. Resending frames...")

        base += added_value
        print(Fore.CYAN + "\nSENDER: Timer Started\n" + Style.RESET_ALL)
    s.sendall("TERMINATE".encode())


totalFrames = 5
windowSize = 2
timeout = 10

ip = "127.0.0.1"
port = 8119

initial_data = []
for i in range(totalFrames):
    byte = ''.join(np.random.choice(["0", "1"]) for _ in range(8))
    initial_data.append(byte)

print(Fore.BLUE + f"\nTransmit Data:{initial_data}\n" + Style.RESET_ALL)

client(initial_data)
