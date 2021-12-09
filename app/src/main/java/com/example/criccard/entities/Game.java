package com.example.criccard.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

enum PlayChoice {BATTING, BOWLING}
enum Inning {FIRST,SECOND}

@Entity(tableName = "game_table")
public class Game {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public Team[] teams;
    public int battingTeam;
    public int bowlingTeam;
    public int tossWonByTeam;
    public PlayChoice tossWonTeamChose;
    public int totalOvers;
    public float oversBowled;
    public Inning inning;
    public int[] batsmen;
    public int bowler;
    public List<Ball> overBalls; // maintaining list of balls of the current over

    public Game(Team[] teams, int battingTeam, int bowlingTeam, int tossWonByTeam, PlayChoice tossWonTeamChose, int totalOvers, float oversBowled, Inning inning, int[] batsmen, int bowler, List<Ball> overBalls) {
        this.teams = teams;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.tossWonByTeam = tossWonByTeam;
        this.tossWonTeamChose = tossWonTeamChose;
        this.totalOvers = totalOvers;
        this.oversBowled = oversBowled;
        this.inning = inning;
        this.batsmen = batsmen;
        this.bowler = bowler;
        this.overBalls = overBalls;
    }
}
