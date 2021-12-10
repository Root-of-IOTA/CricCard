package com.example.criccard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.criccard.entities.Player;

import java.util.List;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerListViewHolder> {
    List<Player> players;

    @NonNull
    @Override
    public PlayerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list, parent, false);
        return new PlayerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListViewHolder holder, int position) {
        Player player = players.get(position);
        holder.getPlayerName().setText(player.name);
        holder.getBalls().setText(player.balls);
        holder.getRuns().setText(player.runs);
        holder.getBowler().setText(player.bowler == null? "-" : player.bowler.name);
        holder.getFielder().setText(player.fielder == null? "-": player.fielder.name);
        holder.getFourCount().setText(player.fours);
        holder.getPlayerSR().setText(Float.toString(player.scoreRate));
        holder.getSixCount().setText(player.sixes);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    class PlayerListViewHolder extends RecyclerView.ViewHolder {
        private TextView playerName, playerSR, bowler, fielder, sixCount, fourCount, runs, balls;

        public TextView getPlayerName() {
            return playerName;
        }

        public TextView getPlayerSR() {
            return playerSR;
        }

        public TextView getBowler() {
            return bowler;
        }

        public TextView getFielder() {
            return fielder;
        }

        public TextView getSixCount() {
            return sixCount;
        }

        public TextView getFourCount() {
            return fourCount;
        }

        public TextView getRuns() {
            return runs;
        }

        public TextView getBalls() {
            return balls;
        }

        PlayerListViewHolder(View view) {
            super(view);
            // get text view
            playerName = view.findViewById(R.id.player_name);
            playerSR = view.findViewById(R.id.player_sr);
            bowler = view.findViewById(R.id.bowler);
            fielder = view.findViewById(R.id.fielder);
            sixCount = view.findViewById(R.id.player_six);
            fourCount = view.findViewById(R.id.player_four);
            runs = view.findViewById(R.id.player_runs);
            balls = view.findViewById(R.id.player_balls);
        }
    }
}
