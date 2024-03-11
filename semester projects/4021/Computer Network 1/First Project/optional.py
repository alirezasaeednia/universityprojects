import matplotlib.pyplot as plt

def scramble_hdb3(binary_string):
    encoded=[0]
    current_level = 1
    consecutive_zeros = 0
    count_of_ones =0
    count=0

    for bit in binary_string:
        if bit == '0':
            consecutive_zeros += 1
            if consecutive_zeros == 4:
                encoded = encoded[:-3]
                if previous_nonzero_level == 1 and count_of_ones % 2 == 1:
                    encoded.extend([0, 0, 0, current_level])
                    current_level = -current_level
                    previous_nonzero_level = current_level
                elif previous_nonzero_level == 1 and count_of_ones % 2 == 0:
                    encoded.extend([-current_level, 0, 0, -current_level])
                    current_level = -current_level
                    previous_nonzero_level = current_level
                elif previous_nonzero_level == -1 and count_of_ones % 2 == 0:
                    encoded.extend([-current_level, 0, 0, -current_level])
                    current_level = -current_level
                    previous_nonzero_level = current_level
                else:
                    encoded.extend([0, 0, 0, current_level])
                    current_level = -current_level
                    previous_nonzero_level = current_level
                consecutive_zeros = 0
            else:
                encoded.append(0)
        else:
            current_level = -current_level
            encoded.append(current_level)
            previous_nonzero_level = current_level
            consecutive_zeros = 0
            count_of_ones += 1
    
    print(encoded)
    return encoded

def plot_bipolar_ami_encoding(binary_string):
    encoded = scramble_hdb3(binary_string)
    
    x = range(len(encoded))
    y = encoded
    
    plt.step(x, y)
    
    for i, bit in enumerate(binary_string):
        plt.text(i + 0.5, encoded[i], bit, ha='center', va='bottom', color='r')
    
    plt.xlabel('Time')
    plt.ylabel('Voltage Level')
    plt.title('Bipolar AMI Encoding with HDB3 Scrambling')
    plt.xticks(range(len(binary_string)), range(1, len(binary_string) + 1))
    plt.grid(True)
    plt.show()

binary_string = '1011000011'
plot_bipolar_ami_encoding(binary_string)