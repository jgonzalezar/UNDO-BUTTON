package undo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class UndoButton extends JFrame implements ActionListener {

    private JButton blue, red, green, undo;
    private StackRefGeneric<String> undoStack
            = new StackRefGeneric<String>();

    public static void main(String[] args) {
        UndoButton frame = new UndoButton();
        frame.setVisible(true);
    }

    public UndoButton() {
        Container contentPane = getContentPane();
// set the frame size
        setSize(300, 200);
// set the content pane properties
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);
// create and place four buttons on the frame's content pane
        blue = new JButton("Blue");
        blue.setBounds(100, 10, 100, 30);
        getContentPane().add(blue);
        red = new JButton("Red");
        red.setBounds(100, 50, 100, 30);
        getContentPane().add(red);
        green = new JButton("Green");
        green.setBounds(100, 90, 100, 30);
        getContentPane().add(green);
        undo = new JButton("Undo");
        undo.setBounds(100, 130, 100, 30);
        getContentPane().add(undo);
// associate an action listener to the four buttons
        blue.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        undo.addActionListener(this);
// exit upon closing the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        String buttonText, color;
        JButton clickedButton = (JButton) event.getSource();
        buttonText = clickedButton.getText();
        if (buttonText.equals("Undo")) {
            if (undoStack.empty()) {
                JOptionPane.showMessageDialog(null, "cannot undo");
            } else {
                undoStack.pop();
                if (undoStack.empty()) {
                    JOptionPane.showMessageDialog(null, "cannot undo");
                } else {
                    color = undoStack.pop();
                    setBackgroundColor(color);
                }
            }
        } else {
            setBackgroundColor(buttonText);
        }
    }

    private void setBackgroundColor(String color) {
        if (color.equals("Blue")) {
            getContentPane().setBackground(Color.blue);
            undoStack.push("Blue");
        } else if (color.equals("Red")) {
            getContentPane().setBackground(Color.red);
            undoStack.push("Red");
        } else if (color.equals("Green")) {
            getContentPane().setBackground(Color.green);
            undoStack.push("Green");
        }
    }
}

