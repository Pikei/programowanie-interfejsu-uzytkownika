package com.company.bridge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.*;

public class Bridge extends Frame implements ActionListener {
    private String spadesCards, heartsCards, diamondCards, clubsCards;
    private int points;
    private TextField spades, hearts, diamonds, clubs;
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
        add(new Label("Spades:"));
        spades = new TextField(10);
        add(spades);
        add(new Label("Hearts:"));
        hearts = new TextField(10);
        add(hearts);
        add(new Label("Diamonds:"));
        diamonds = new TextField(10);
        add(diamonds);
        add(new Label("Clubs:"));
        clubs = new TextField(10);
        add(clubs);
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
        spadesCards.replace("10","t");
        heartsCards.replace("10","t");
        diamondCards.replace("10","t");
        clubsCards.replace("10","t");

        figurePoints(spadesCards);
        figurePoints(heartsCards);
        figurePoints(diamondCards);
        figurePoints(clubsCards);

        suitPoints(spadesCards.length()-1);
        suitPoints(heartsCards.length()-1);
        suitPoints(diamondCards.length()-1);
        suitPoints(clubsCards.length()-1);
    }

    private void figurePoints(String cards) {
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
        setSpadesCards(randomCardsGenerator(bound, temp));
        bound = bound - temp;
        temp = randomizeSuitQuantity(bound);
        setHeartsCards(randomCardsGenerator(bound, temp));
        bound = bound - temp;
        temp = randomizeSuitQuantity(bound);
        setDiamondCards(randomCardsGenerator(bound, temp));
        bound = bound - temp;
        setClubsCards(randomCardsGenerator(bound, bound));
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
                    setSpadesCards(spades.getText().toLowerCase());
                    setHeartsCards(hearts.getText().toLowerCase());
                    setDiamondCards(diamonds.getText().toLowerCase());
                    setClubsCards(clubs.getText().toLowerCase());
                    start();
                    JOptionPane.showMessageDialog(null, "Your points equals: " + getPoints());
                    setPoints(0);
                } catch (NumberFormatException ev) {
                    System.out.println("Arguments error! Please type correct data.");
                }
                break;
            case "Randomize":
                randomize();
                spades.setText(spadesCards);
                hearts.setText(heartsCards);
                diamonds.setText(diamondCards);
                clubs.setText(clubsCards);
                break;
            case "Shutdown":
                System.exit(0);
        }
    }

    public String getSpadesCards() {
        return spadesCards;
    }

    public void setSpadesCards(String spadesCards) {
        this.spadesCards = spadesCards;
    }

    public String getHeartsCards() {
        return heartsCards;
    }

    public void setHeartsCards(String heartsCards) {
        this.heartsCards = heartsCards;
    }

    public String getDiamondCards() {
        return diamondCards;
    }

    public void setDiamondCards(String diamondCards) {
        this.diamondCards = diamondCards;
    }

    public String getClubsCards() {
        return clubsCards;
    }

    public void setClubsCards(String clubsCards) {
        this.clubsCards = clubsCards;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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