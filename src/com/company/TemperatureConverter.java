package com.company;

import java.awt.*;
import java.awt.Menu;
import java.awt.event.*;

public class TemperatureConverter extends Frame implements ActionListener{
    private TextField argument;
    private Label result;
    private Button convert;

    public TemperatureConverter() {
        super("Temperature converter");
        setSize(400, 80);
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);
        argument = new TextField(2);
        add(argument);
        add(new Label("Celsius degrees is"));
        convert = new Button("Convert");
        convert.addActionListener(this);
        add(convert);
        result = new Label(" Fahrenheit degrees");
        add(result);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu menu = new Menu();

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
        if (label. equals("Convert")) {
            try {
                int tempFahr = (int)((Double.parseDouble(argument.getText())) * 1.8 + 32);
                result.setText((tempFahr + " Fahrenheit degrees"));
            } catch (NumberFormatException ev) {
                System.out.println("Arguments error! Please type correct data.");
            }
        } else if (label.equals("Shutdown")) {
            System.exit(0);
        }
    }
}
