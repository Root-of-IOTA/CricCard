package com.example.criccard.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

enum PlayChoice {BATTING, BOWLING}
enum Inning {FIRST,SECOND}

@Entity
public class GameEntity {
    @PrimaryKey
    public int id;
    public TeamEntity[] teams;
    public int battingTeam;
    public int bowlingTeam;
    public int tossWonByTeam;
    public PlayChoice tossWonTeamChose;
    public int totalOvers;
    public float oversBowled;
    public Inning inning;
    public int[] batsmen;
    public int bowler;
}
