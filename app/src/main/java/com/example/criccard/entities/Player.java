package com.example.criccard.entities;

public class Player {
    public int id;
    public String name;
    public int runs;
    public int fours;
    public int sixes;
    public int balls;
    public int wickets;
    public float economy;
    public float overs;
    public float scoreRate;
    public String outReason;
    public Player bowler;

    public Player(int id, String name, int runs, int fours, int sixes, int balls,
                  int wickets, float economy, float overs, float scoreRate, String outReason, Player bowler) {
        this.id = id;
        this.name = name;
        this.runs = runs;
        this.fours = fours;
        this.sixes = sixes;
        this.balls = balls;
        this.wickets = wickets;
        this.economy = economy;
        this.overs = overs;
        this.scoreRate = scoreRate;
        this.outReason = outReason;
        this.bowler = bowler;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.runs = 0;
        this.fours = 0;
        this.sixes = 0;
        this.balls = 0;
        this.wickets = 0;
        this.economy = 0.0f;
        this.overs = 0.0f;
        this.scoreRate = 0.0f;
        this.bowler = null;
    }

}
