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

    public void addPlayer(String name) {
        players.add(new Player(getNextPlayerId(), name));
    }

    // when a wicket happens use this function to change the player from players list to playEndedPlayers list
    public void playerWicket(Player player, String outReason, Player bowler, Player fielder) {
        player.outReason = outReason;
        player.bowler = bowler;
        player.fielder = fielder;
        player.updateScoreRate();
        playEndedPlayers.add(player);
        players.remove(player);
    }

    // automatically goes over the player list and updates the total run
    // note: run increment on player object must be done manually
    public void updateTotalRuns() {
        int runs = 0;
        for(Player p: players) {
            runs += p.runs;
        }
        for(Player p: playEndedPlayers) {
            runs += p.runs;
        }
        this.totalRuns = runs;
    }

    // automatically goes over the player list and updates the total overs
    // note: over increment on player object must be done manually
    public void updateTotalOvers() {
        int overs = 0;
        for(Player p: players) {
            overs += p.overs;
        }
        for(Player p: playEndedPlayers) {
            overs += p.overs;
        }
        this.totalOvers = overs;
    }
}
