package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Bridge {
    private String cards;
    private int points;
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Enter your cards: ");
        cards = input.next().toLowerCase(Locale.ROOT);
        cards.replace("10","t");
        figurePoints();
        suitPoints((cards.indexOf('h') - cards.indexOf('s')-1));
        suitPoints((cards.indexOf('d') - cards.indexOf('h')-1));
        suitPoints((cards.indexOf('c') - cards.indexOf('d')-1));
        suitPoints((cards.charAt(cards.length()-1) - cards.indexOf('c')-1));
        System.out.println("Your points equals: " + points);
    }

    private void figurePoints() {
        for (int i = 0; i < cards.length(); i++) {
            switch (cards.charAt(i)) {
                case 'a' -> points = points + 4;
                case 'k' -> points = points + 3;
                case 'q' -> points = points + 2;
                case 'j' -> points = points + 1;
            }
        }
    }

    private void suitPoints(int numberOfCards) {
        switch (numberOfCards) {
            case 0 -> points = points + 3;
            case 1 -> points = points + 2;
            case 2 -> points = points + 1;
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
}
