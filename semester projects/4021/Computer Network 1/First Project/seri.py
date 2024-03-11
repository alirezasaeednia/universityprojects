
import numpy as np
import matplotlib.pyplot as plt

f = 5  # Base frequency
t = np.linspace(0, 1, 1000) #from 0 to 1s ,how many elements? 1000!
N = 5  # Number of harmonics

# Plot the fundamental frequency first
plt.figure(figsize=(10, 8))
square_wave = np.zeros_like(t)

for n in range(1, 2*N+1, 2):  #odd harmonics for example if n=2 ;loop goes through 1,5,7 we could use for n in range(1, 2*N, 2):
    current_harmonic = (4/(np.pi*n)) * np.sin(2 * np.pi * n * f * t) 
    square_wave += current_harmonic
    plt.plot(t, square_wave)

plt.title('Bonus question')
plt.xlabel('t')
plt.ylabel('Peak Amplitude')
plt.show()