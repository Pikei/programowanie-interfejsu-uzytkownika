package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.*;

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
        argument = new TextField(21);
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
            switch (cards.toLowerCase().charAt(i)) {
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

    public void randomize(){
        int bound = 13;
        int temp = randomizeSuitQuantity(bound);
        setCards("s" + randomCardsGenerator(bound, temp));
        bound = bound - temp;
        temp = randomizeSuitQuantity(bound);
        setCards(getCards() + "h" + randomCardsGenerator(bound, temp));
        bound = bound - temp;
        temp = randomizeSuitQuantity(bound);
        setCards(getCards() + "d" + randomCardsGenerator(bound, temp));
        bound = bound - temp;
        setCards(getCards() + "c"+ randomCardsGenerator(bound, bound));
    }

    private int randomizeSuitQuantity(int bound) {
        return rand.nextInt(bound);
    }

    public String randomCardsGenerator(int bound, int temp) {
        ArrayList<Integer> tempSuitCards = new ArrayList<>();
        StringBuilder suitCards = new StringBuilder();
        for (int i = 0; i < temp; i++) {
            int random = rand.nextInt(bound);
            if (!tempSuitCards.contains(random)) {
                tempSuitCards.add(random);
            } else i--;
        }
        Collections.sort(tempSuitCards);
        for (Integer tempSuitCard : tempSuitCards) {
            suitCards.append(convert(tempSuitCard));
        }
        return suitCards.toString();
    }

    private String convert(int card) {
        switch (card) {
            case 0 -> {
                return "a";
            }
            case 1 -> {
                return "k";
            }
            case 2 -> {
                return "q";
            }
            case 3 -> {
                return "j";
            }
            case 4 -> {
                return "10";
            }
            case 5 -> {
                return "9";
            }
            case 6 -> {
                return "8";
            }
            case 7 -> {
                return "7";
            }
            case 8 -> {
                return "6";
            }
            case 9 -> {
                return "5";
            }
            case 10 -> {
                return "4";
            }
            case 11 -> {
                return "3";
            }
            case 12 -> {
                return "2";
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals("Points")) {
            try {
                setCards(argument.getText().toLowerCase());
                start();
                JOptionPane.showMessageDialog(null, "Your points equals: " + getPoints());
                setPoints(0);
            } catch (NumberFormatException ev) {
                System.out.println("Arguments error! Please type correct data.");
            }
        } else if (label.equals("Randomize")) {
            randomize();
            argument.setText(cards);
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
