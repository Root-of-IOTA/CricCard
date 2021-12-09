package com.example.criccard.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    public List<Player> players;
    public List<Player> playEndedPlayers;
    public int totalRuns; // best used only after the team's inning have finished
    public float totalOvers;

    public Team() {
        totalOvers = 0.0f;
        totalRuns = 0;
        players = new ArrayList<>();
        playEndedPlayers = new ArrayList<>();
    }
    // used to initialize new players id
    // id can be used as their number
    public int getNextPlayerId() {
        return players.size() + playEndedPlayers.size() + 1;
    }
}
