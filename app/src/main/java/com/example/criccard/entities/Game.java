package com.example.criccard.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

@Entity(tableName = "game_table")
@TypeConverters({Convertor.class})
public class Game {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public List<Team> teams;
    public int battingTeam;
    public int bowlingTeam;
    public int tossWonByTeam;
    public PlayChoice tossWonTeamChose;
    public int totalOvers;
    public float oversBowled;
    public Inning inning;
    public int striker;
    public int nonStriker;
    public int bowler;
    public List<Ball> overBalls; // maintaining list of balls of the current over

    public Game(List<Team> teams, int battingTeam, int bowlingTeam, int tossWonByTeam, PlayChoice tossWonTeamChose, int totalOvers, float oversBowled, Inning inning, int striker, int nonStriker, int bowler, List<Ball> overBalls) {
        this.teams = teams;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.tossWonByTeam = tossWonByTeam;
        this.tossWonTeamChose = tossWonTeamChose;
        this.totalOvers = totalOvers;
        this.oversBowled = oversBowled;
        this.inning = inning;
        this.striker = striker;
        this.nonStriker = nonStriker;
        this.bowler = bowler;
        this.overBalls = overBalls;
    }
}
