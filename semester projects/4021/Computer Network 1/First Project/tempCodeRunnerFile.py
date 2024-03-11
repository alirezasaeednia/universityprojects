        ask_modulation[i * 1000: (i + 1) * 1000] = A2 * np.cos(2 * np.pi * fc * t[i * 1000: (i + 1) * 1000])

A = 1 
noise = A * np.cos(2 * np.pi * fc * t)

final_signal = ask_modulation + noise

fig, axs = plt.subplots(3, 1, figsize=(8, 8))