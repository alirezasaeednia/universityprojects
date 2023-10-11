/**
 * This class allow lecturer to choose Part 1 or Part 2
 */


package Main;

import Algorithm.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MainSelection extends JFrame implements ActionListener {
    static JButton jButton = new JButton();
    static JFrame frame = new JFrame();

    public MainSelection() {

        // tarahi ui
        setButtons();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setButtons() {
        jButton.setText("START CFG TO CNF CONVERTOR,CLICK HERE");
        jButton.setAlignmentY(-500);
        jButton.setAlignmentX(-500);
        jButton.setSize(1000, 200);
        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon("Resources/CFG.gif");

        jButton.addActionListener(e -> {
            frame.setVisible(false);
        });
        jButton.setBackground(Color.PINK);
       label.setIcon(imageIcon);
        label.setText(" Ba salam, baraye estefade az epsilon az 'e' estefade konid mamnoonam");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        frame.add(jButton);
        frame.add(label);
        frame.setResizable(false);
        label.setFont(new Font("MV Boli", Font.PLAIN, 29));
        label.setForeground(Color.RED);
        Border border = BorderFactory.createLineBorder(Color.orange);
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setTitle("Tabdile CFG BE CNF");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        label.setBorder(border);
        jButton.addActionListener(this);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        if (button.equals("START CFG TO CNF CONVERTOR,CLICK HERE")) {
            new SecondLabel();
        }
    }

    public static void main(String[] args) {
        MainSelection ms = new MainSelection();
    }


}
