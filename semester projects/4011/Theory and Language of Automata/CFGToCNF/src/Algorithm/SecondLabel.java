package Algorithm;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class SecondLabel extends JFrame implements ActionListener {

    private Border thinBorder = BorderFactory.createLineBorder(Color.BLACK);
    private SpringLayout springLayout = new SpringLayout();
    private CNF cnf;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextArea inputTextArea;
    private JTextArea outputCNFTextArea;
    private JTextArea outputCYKTextArea;
    private JButton submit;
    private JButton convertButton;


    public SecondLabel(){
        super("Convert CFG to CNF");
        setSize(875,725);
        setVisible(true);
        setLayout(springLayout);

        // program will launch at center
        setLocationRelativeTo(null);

        cnf = new CNF();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setInputLabel();
        setInputTextArea();
        setCNFOutputTextArea();
        setSubmitButton();
        setOutputLabel();


    }

    public void setSubmitButton() {
        submit = new JButton("Convert");
        setVisible(true);
        submit.addActionListener(this);
        add(submit);

        springLayout.putConstraint(SpringLayout.WEST, submit, 240, SpringLayout.WEST, inputLabel);
        springLayout.putConstraint(SpringLayout.NORTH, submit, 20, SpringLayout.NORTH, this);

    }

    public void setInputTextArea() {
        inputTextArea = new JTextArea(15, 20);
        inputTextArea.setFont(inputTextArea.getFont().deriveFont(17f));
        inputTextArea.setBorder(thinBorder);
        inputTextArea.setVisible(true);
        add(inputTextArea);

        springLayout.putConstraint(SpringLayout.WEST, inputTextArea, 20, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, inputTextArea, 30, SpringLayout.NORTH, inputLabel);
    }

    public void setCNFOutputTextArea() {
        outputCNFTextArea = new JTextArea(40, 40);
        outputCNFTextArea.setBorder(thinBorder);
        outputCNFTextArea.setEditable(false);
        outputCNFTextArea.setVisible(true);
        add(outputCNFTextArea);
        cnf.setOutputTextArea(outputCNFTextArea);

        springLayout.putConstraint(SpringLayout.WEST, outputCNFTextArea, 375, SpringLayout.WEST, inputTextArea);
        springLayout.putConstraint(SpringLayout.NORTH, outputCNFTextArea, 60, SpringLayout.NORTH, this);
    }


    public void setOutputLabel() {

        outputLabel = new JLabel();
        outputLabel.setText("Chomsky Normal Form output: ");
        add(outputLabel);

        springLayout.putConstraint(SpringLayout.WEST, outputLabel, 400, SpringLayout.EAST, this);
        springLayout.putConstraint(SpringLayout.NORTH, outputLabel, 30, SpringLayout.NORTH, this);


    }


    public void setInputLabel() {

        inputLabel = new JLabel();
        inputLabel.setText("Input Context Free Grammar:");
        add(inputLabel);

        springLayout.putConstraint(SpringLayout.WEST, inputLabel, 20, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, inputLabel, 30, SpringLayout.NORTH, this);

    }

    public void convertCFGtoCNF(){
        cnf.setInputandLineCount(inputTextArea.getText(), inputTextArea.getLineCount());
        cnf.convertCFGtoCNF();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();

        if(button.equals("Convert") ){
            convertCFGtoCNF();
        }


    }



}
