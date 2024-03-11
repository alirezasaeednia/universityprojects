import numpy as np
import matplotlib.pyplot as plt

fc = 1 
A1 = 1 
A2 = 2 
binary_input = "101010"

t = np.linspace(0, len(binary_input), len(binary_input) * 1000)

ask_modulation = np.zeros(len(t))
for i, bit in enumerate(binary_input):
    if bit == '0':
        ask_modulation[i * 1000: (i + 1) * 1000] = A1 * np.cos(2 * np.pi * fc * t[i * 1000: (i + 1) * 1000])
    elif bit == '1':
        ask_modulation[i * 1000: (i + 1) * 1000] = A2 * np.cos(2 * np.pi * fc * t[i * 1000: (i + 1) * 1000])

A = 1 
noise = A * np.cos(2 * np.pi * fc * t)

final_signal = ask_modulation + noise

fig, axs = plt.subplots(3, 1, figsize=(8, 8))

axs[0].plot(t, noise)
axs[0].set_xlabel('Time')
axs[0].set_ylabel('Amplitude')
axs[0].set_title('Noise Signal')

axs[1].plot(t, final_signal)
axs[1].set_xlabel('Time')
axs[1].set_ylabel('Amplitude')
axs[1].set_title('Final Signal')

axs[2].plot(t, ask_modulation)
axs[2].set_xlabel('Time')
axs[2].set_ylabel('Amplitude')
axs[2].set_title('Original ASK Modulation Signal')

plt.subplots_adjust(hspace=0.5)

plt.show()