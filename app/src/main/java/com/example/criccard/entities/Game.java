package com.example.criccard.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "game_table")
@TypeConverters({Convertor.class})
public class Game {
    @PrimaryKey
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
        this.id = 0; // only one game
    }

    public Game() {
        id = 0;
        inning = Inning.FIRST;
        overBalls = new ArrayList<>();
        teams = new ArrayList<>();
        teams.add(new Team());
        teams.add(new Team());
    }

    public Team getBattingTeam() {
        Team t;
        if(inning == Inning.FIRST && oversBowled < totalOvers) {
            if (tossWonTeamChose == PlayChoice.BATTING) t =  teams.get(tossWonByTeam);
            else t = teams.get(tossWonByTeam == 0 ? 1 : 0);
        } else {
            if (tossWonTeamChose == PlayChoice.BATTING) t = teams.get(tossWonByTeam == 0 ? 1 : 0);
            else t =  teams.get(tossWonByTeam);
        }
        return t;
    }

    public void setBatters() {
        Team t = getBattingTeam();
        // TODO: remaining logic for striker and non striker setting from player list of the team
    }

    //todo: other function like wicket, run, over, ball updation needed to be completed
}
