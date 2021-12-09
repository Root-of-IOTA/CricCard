package com.example.criccard.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.criccard.entities.Game;

import java.util.List;

@Dao
public interface GameDao {
    @Insert
    void insertGame(Game game);

    @Update
    void updateGame(Game game);

    @Query("DELETE FROM game_table")
    void deleteGame();

    @Query("SELECT * FROM game_table")
    LiveData<List<Game>> getAllGames();

    @Query("SELECT * FROM game_table WHERE game_table.id = 0")
    LiveData<Game> getGame();
}
