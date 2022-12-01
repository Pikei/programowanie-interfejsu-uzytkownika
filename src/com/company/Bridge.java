package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.awt.*;
import java.util.Random;

public class Bridge extends Frame implements ActionListener {
    private String cards;
    private int points;
    private TextField argument;
    private Label result;
    private Button calculate;
    private Button random;
    Random rand = new Random();

    public Bridge() {
        super("Points of your cards");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);
        add(new Label("Enter your cards:"));
        argument = new TextField(3);
        add(argument);
        calculate = new Button("Points");
        calculate.addActionListener(this);
        add(calculate);
        result = new Label(" Calculate your points.");
        add(result);
        random = new Button("Randomize");
        random.addActionListener(this);
        add(random);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public void start() {
        setPoints(0);
        cards.replace("10","t");
        figurePoints();
        suitPoints((cards.indexOf('h') - cards.indexOf('s')-1));
        suitPoints((cards.indexOf('d') - cards.indexOf('h')-1));
        suitPoints((cards.indexOf('c') - cards.indexOf('d')-1));
        suitPoints((cards.charAt(cards.length()-1) - cards.indexOf('c')-1));
    }

    private void figurePoints() {
        for (int i = 0; i < cards.length(); i++) {
            switch (cards.charAt(i)) {
                case 'a' -> setPoints(points + 4);
                case 'k' -> setPoints(points + 3);
                case 'q' -> setPoints(points + 2);
                case 'j' -> setPoints(points + 1);
            }
        }
    }

    private void suitPoints(int numberOfCards) {
        switch (numberOfCards) {
            case 0 -> setPoints(points + 3);
            case 1 -> setPoints(points + 2);
            case 2 -> setPoints(points + 1);
        }
    }

    private void randomize() {
        setCards("s");
        int suitQuantity = rand.nextInt();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals("Points")) {
            try {
                setCards(argument.getText().toLowerCase(Locale.ROOT));
                start();
                JOptionPane.showMessageDialog(null, "Your points equals: " + getPoints());
                setPoints(0);
            } catch (NumberFormatException ev) {
                System.out.println("Arguments error! Please type correct data.");
            }
        } else if (label.equals("Randomize")) {

        }
        else if (label.equals("Shutdown")) {
            System.exit(0);
        }
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public TextField getArgument() {
        return argument;
    }

    public void setArgument(TextField argument) {
        this.argument = argument;
    }

    public Label getResult() {
        return result;
    }

    public void setResult(Label result) {
        this.result = result;
    }

    public Button getCalculate() {
        return calculate;
    }

    public void setCalculate(Button calculate) {
        this.calculate = calculate;
    }
}
