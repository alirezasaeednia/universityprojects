import matplotlib.pyplot as plt

def plot_nrzi_encoding(binary_string):
    encoded = []
    current_level = 1  
    
    for bit in binary_string:
        if bit == '0':
            encoded.append(current_level)  
        else:
            current_level = -current_level 
            encoded.append(current_level)
    
    x = range(len(binary_string)+1)
    y = [1] + encoded 
    
    plt.step(x, y)
    
    for i, bit in enumerate(binary_string):
        plt.text(i+0.5, encoded[i], bit, ha='center', va='bottom',color='r')
    
    plt.xlabel('Time')
    plt.ylabel('Voltage Level')
    plt.title('NRZI Encoding Scheme')
    plt.grid(True)
    plt.show()

binary_string = "1010110110"
plot_nrzi_encoding(binary_string)