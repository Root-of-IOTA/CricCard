package com.example.criccard.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.criccard.dao.GameDao;
import com.example.criccard.entities.Game;

@Database(entities = {Game.class}, version = 1)
public abstract class GameDatabase extends RoomDatabase {
    private static GameDatabase instance;
    public abstract GameDao gameDao();

    public static synchronized GameDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), GameDatabase.class, "game_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
