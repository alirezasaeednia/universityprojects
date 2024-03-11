import matplotlib.pyplot as plt
#0110000101100100011011000110000101011001001000000111100101110000011100000110000101001000011101000110100001100111011010010110111000100000
def plot_bipolar_ami_encoding(binary_string):
    encoded = []
    current_level = 1  
    
    for bit in binary_string:
        if bit == '0':
            encoded.append(0)  
        else:
            current_level = -current_level 
            encoded.append(current_level)
    
    x = range(len(binary_string)+1)
    y = [0] + encoded 
    
    plt.step(x, y)
    
    for i, bit in enumerate(binary_string):
        plt.text(i+0.5, encoded[i], bit, ha='center', va='bottom',color='r')
    
    plt.xlabel('Time')
    plt.ylabel('Voltage Level')
    plt.title('Bipolar AMI Encoding Scheme')
    plt.grid(True)
    plt.show()

#binary_string = input("Enter a binary string: ")
binary_string='1100000000110000010'
plot_bipolar_ami_encoding(binary_string)