import numpy as np
import matplotlib.pyplot as plt

# Original binary signal
original_binary = [1,1,0,1,1,0,1,0,0]

# Signal amplitude and carrier frequency
A1 = 1.0
A2 = -1.0
carrier_frequency = 1

# Generate noise signal
noise_amplitude = 0.2
t = np.linspace(0, len(original_binary), len(original_binary)*100)
noise_signal = noise_amplitude * np.cos(2 * np.pi * carrier_frequency/5.6 * t)

# Modulate the binary signal using ASK
modulated_signal = []
for bit in original_binary:
    if bit == 0:
        modulated_signal += [A2 * np.cos(2 * np.pi * carrier_frequency * t)]
    else:
        modulated_signal += [A1 * np.cos(2 * np.pi * carrier_frequency * t)]

# Reshape the modulated signal to match the length of the original binary signal
modulated_signal = np.array(modulated_signal)
modulated_signal = modulated_signal.reshape(-1)
print(modulated_signal)

# Reshape the noisy signal to match the length of the modulated signal
noisy_signal = np.tile(noise_signal, len(modulated_signal)//len(noise_signal))

# Add noise signal to the modulated signal
noisy_modulated_signal = modulated_signal + noisy_signal

# Demodulate the binary signal
demodulated_binary = []
for i in range(len(original_binary)):
    correlation = np.sum(noisy_modulated_signal[i*len(t):(i+1)*len(t)] * np.cos(2 * np.pi * carrier_frequency * t))
    if correlation < 0:
        demodulated_binary.append(0)
    else:
        demodulated_binary.append(1)

# Plot the signals
plt.figure(figsize=(10, 8))

plt.subplot(4, 1, 1)
plt.step(range(len(original_binary)), original_binary, 'r')
plt.title('Original Binary Signal')
plt.xlabel('Time')
plt.ylabel('Amplitude')

plt.subplot(4, 1, 2)
plt.plot(t, noise_signal[:len(t)], 'b')
plt.title('Noise Signal')
plt.xlabel('Time')
plt.ylabel('Amplitude')

plt.subplot(4, 1, 3)
plt.plot(t, modulated_signal[:len(t)], 'g')
plt.title('Modulated Signal')
plt.xlabel('Time')
plt.ylabel('Amplitude')

plt.subplot(4, 1, 4)
plt.step(range(len(noisy_modulated_signal)), noisy_modulated_signal, 'm')
plt.title('Noisy modulated')
plt.xlabel('Time')
plt.ylabel('Amplitude')
plt.tight_layout()
plt.show()

plt.subplot(4, 1, 4)
plt.step(range(len(demodulated_binary)), demodulated_binary, 'm')
plt.title('Demodulated Binary Signal')
plt.xlabel('Time')
plt.ylabel('Amplitude')
plt.tight_layout()
plt.show()