package com.company.bridge;

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
        CardSymbol[] cardSymbol = CardSymbol.values();
        return cardSymbol[card].getDisplaySymbol();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        switch (label) {
            case "Points":
                try {
                    setCards(argument.getText().toLowerCase());
                    start();
                    JOptionPane.showMessageDialog(null, "Your points equals: " + getPoints());
                    setPoints(0);
                } catch (NumberFormatException ev) {
                    System.out.println("Arguments error! Please type correct data.");
                }
                break;
            case "Randomize":
                randomize();
                argument.setText(cards);
                break;
            case "Shutdown":
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