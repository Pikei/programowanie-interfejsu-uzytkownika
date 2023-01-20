package com.company.bridge;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;

public class Bridge extends JFrame implements ActionListener {
    private String spadesCards, heartsCards, diamondCards, clubsCards;
    private int points;
    private JFrame frame;
    private JLabel s,h,d,c;
    private final TextField spades;
    private final TextField hearts;
    private final TextField diamonds;
    private final TextField clubs;
    private Label result;
    private Button calculate, random;
    private Random rand = new Random();

    public Bridge() {
        frame = new JFrame("Points of your cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String suitSource = "C:/Users/215ikarolp/IdeaProjects/programowanie-interfejsu-uzytkownika/out/production/programowanie_interfejsu_użytkownika/com/company/bridge/";
        s = scale(suitSource +"spades.png");
        h = scale(suitSource + "hearts.png");
        d = scale(suitSource + "diamonds.png");
        c = scale(suitSource + "clubs.png");
        calculate = new Button("Points");
        calculate.addActionListener(this);
        random = new Button("Randomize");
        random.addActionListener(this);
        spades = new TextField(10);
        hearts = new TextField(10);
        diamonds = new TextField(10);
        clubs = new TextField(10);
        BorderLayout l1 = new BorderLayout();
        setLayout(l1);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.add(add(scale(suitSource +"spades.png")));
        p1.add(spades);
        p2.add(scale(suitSource + "hearts.png"));
        p2.add(add(hearts));
        p2.add(random);
        p2.add(calculate);
        p2.add(scale(suitSource + "diamonds.png"));
        p2.add(diamonds);
        p3.add(scale(suitSource + "clubs.png"));
        p3.add(clubs);

        frame.setLayout(l1);
        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.CENTER);
        frame.add(p3, BorderLayout.SOUTH);

        frame.setBackground(Color.lightGray);
        frame.setSize(500,175);
        frame.setVisible(true);

    }

    private void start() {
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
                break;
        }
    }


    private JLabel scale(String source) {
        ImageIcon imageIcon = new ImageIcon(source);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(30, 35,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return new JLabel(imageIcon);
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