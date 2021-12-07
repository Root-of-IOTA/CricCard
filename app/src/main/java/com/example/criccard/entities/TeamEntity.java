package com.example.criccard.entities;

import java.util.List;

public class TeamEntity {
    public List<Player> players;
    public List<Player> playEndedPlayers;

    // used to initialize new players id
    // id can be used as their number
    public int getNextPlayerId() {
        return players.size() + playEndedPlayers.size() + 1;
    }
}
