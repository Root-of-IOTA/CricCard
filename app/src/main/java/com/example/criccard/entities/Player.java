package com.example.criccard.entities;

public class Player {
    public int id; // number for the player
    public String name;
    public int runs; // runs scored on batting
    public int fours;
    public int sixes;
    public int balls;
    public int wickets;
    public float economy;
    public float overs;
    public float scoreRate;
    public String outReason;
    public Player bowler;
    public Player fielder;
    public int maiden;
    public int bowlingRuns; // runs given during bowling

    public Player(int id, String name, int runs, int fours, int sixes, int balls,
                  int wickets, float economy, float overs, float scoreRate, String outReason,
                  Player bowler, Player fielder,int maiden, int bowlingRuns) {
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
        this.maiden = maiden;
        this.bowlingRuns = bowlingRuns;
        this.fielder = fielder;
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
        this.fielder = null;
    }

    public void updateScoreRate() {
        scoreRate = ((float) runs )/ balls;
    }

    public void updateEconomy() {
        economy = ((float) bowlingRuns) / overs;
    }

}
