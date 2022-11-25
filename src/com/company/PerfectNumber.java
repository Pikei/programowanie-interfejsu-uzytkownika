package com.company;

import java.awt.*;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PerfectNumber extends Frame implements ActionListener {
    private int number;
    private TextField argument;
    private Label result;
    private Button convert;

    public PerfectNumber() {
        super("Perfect number calculator");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);
        argument = new TextField(2);
        add(argument);
        add(new Label("Your number "));
        convert = new Button("Check");
        convert.addActionListener(this);
        add(convert);
        result = new Label(" Check if it is perfect.");
        add(result);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu menu = new Menu("File");
        MenuItem mi = new MenuItem("Close", new MenuShortcut('1'));
        menu.add(mi);
        menu.addActionListener(this);
        menuBar.add(menu);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals("Check")) {
            try {
                int tempNum = (int) (Integer.parseInt(argument.getText()));
                if (check(tempNum)) {
                    result.setText((tempNum + " is perfect"));
                } else {
                    result.setText((tempNum + " isn't perfect"));
                }
            } catch (NumberFormatException ev) {
                System.out.println("Arguments error! Please type correct data.");
            }
        } else if (label.equals("Shutdown")) {
            System.exit(0);
        }
    }

    public void perfectNumber() {
        String info = "Perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.";
        JOptionPane.showMessageDialog(null, info);
        number = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter number to check if it is perfect: "));
        if (check(number)) {
            JOptionPane.showMessageDialog(null,"Number " + number + " is perfect.");
        } else {
            JOptionPane.showMessageDialog(null, "Number " + number + " isn't perfect.");
        }
        System.exit(0);
    }

    private boolean check(int number) {
        int temp = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                temp = temp + i;
            }
        }
        return temp == number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
