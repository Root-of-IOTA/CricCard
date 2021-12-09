package com.example.criccard.entities;

public class Ball {
    public boolean isWide;
    public boolean isNoBall;
    public boolean isByes;
    public boolean isLegByes;
    public boolean isWicket;
    public int runs;

    public Ball(boolean isWide, boolean isNoBall, boolean isByes, boolean isLegByes, boolean isWicket, int runs) {
        this.isWide = isWide;
        this.isNoBall = isNoBall;
        this.isByes = isByes;
        this.isLegByes = isLegByes;
        this.isWicket = isWicket;
        this.runs = runs;
    }

    public Ball() {
        this.runs = 0;
    }
}
