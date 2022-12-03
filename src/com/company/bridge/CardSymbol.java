package com.company.bridge;

public enum CardSymbol {
    ACE("a"),
    KING("k"),
    QUEEN("q"),
    JACK("j"),
    TEN("10"),
    NINE("9"),
    EIGHT("8"),
    SEVEN("7"),
    SIX("6"),
    FIVE("5"),
    FOUR("4"),
    THREE("3"),
    TWO("2");
    private String displaySymbol;

    CardSymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public String getDisplaySymbol() {
        return displaySymbol;
    }
}
