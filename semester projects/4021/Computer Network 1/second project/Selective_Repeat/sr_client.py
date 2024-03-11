import threading
import socket
import datetime
import time
import re
import numpy as np
import select
from colorama import Fore, Style


def extract_ack(string):
    pattern = r'RECEIVER: \|Ack(\w+)\|'
    match = re.search(pattern, string)
    if match:
        ack = match.group(1)
        return ack
    else:
        return -1


def initial_ack_frame(windows_size):
    temp = []
    for i in range(0, windows_size):
        temp.append(i)
    return temp


def check_state(i):
    if len(ack_frame) == 0 or len(ack_frame) <= i:
        return True
    return False


def send_data():
    # This code will run in a separate thread
    while len(ack_frame) > 0:
        for i in range(min(windowSize, len(ack_frame))):
            if i < len(ack_frame):
                print(
                    Fore.YELLOW + f"SENDER: Transmitting.... |(Frame{i % (windowSize * 2)}),(Seq{ack_frame[i]}),({initial_data[i]})|" + Style.RESET_ALL)
            else:
                continue
            s.sendall(f"(Frame{i % (windowSize * 2)}),(Seq{ack_frame[i]}),({initial_data[i]})".encode())
            time.sleep(0.5)
    s.sendall("TERMINATE".encode())

def receive_ack():
    # Your reception acknowledgment logic here
    # This code will run in a separate thread

    ready = select.select([s], [], [], timeout)
    while True:
        if ready[0]:
            ack = s.recv(1024).decode()
            ack_seq = int(extract_ack(ack))
            if ack_seq > -1:
                ack_frame.remove(ack_seq)
            if len(ack_frame) == 0:
                return
        else:
            s.sendall(f"(Ack{ack_frame[i]}))".encode())


# Set the IP address and port
ip = "192.168.10.89"
print(ip)
port = 8000

totalFrames = 5
windowSize = 2
timeout = 3

# Initial ack frame
ack_frame = initial_ack_frame(totalFrames)

# Initial Data
initial_data = []
for i in range(totalFrames):
    byte = ''.join(np.random.choice(["0", "1"]) for _ in range(8))
    initial_data.append(byte)

# Create a socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((ip, port))

# Create and start the send thread
send_thread = threading.Thread(target=send_data)
send_thread.start()

# Create and start the receive thread
receive_thread = threading.Thread(target=receive_ack)
receive_thread.start()

# Wait for both threads to complete
send_thread.join()
receive_thread.join()
