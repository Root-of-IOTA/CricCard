package com.example.criccard.repository;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;

import com.example.criccard.dao.GameDao;
import com.example.criccard.database.GameDatabase;
import com.example.criccard.entities.Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GameRepository {
    private GameDao dao;
    private LiveData<Game> game;
    private final ExecutorService es = Executors.newSingleThreadExecutor();
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private final String SHARED_PREF = "com.example.criccard";

    public GameRepository(Application application) {
        GameDatabase db = GameDatabase.getInstance(application);
        dao = db.gameDao();
        game = dao.getGame();
        if (game == null) { // initialize if there is no game
            insert(new Game());
        }
        sp = application.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public LiveData<Game> getGame() { return game; }
    public void update(Game game) {
        es.submit(() -> dao.updateGame(game));
    }

    public void insert(Game game) {
        es.submit(() -> dao.insertGame(game));
    }

    public void delete() {
        es.submit(() -> dao.deleteGame());
    }

    public void newGame() {
        setGameEmpty();
        delete();
        insert(new Game()); // creates a fresh game object in database
    }

    // functions to represent whether the game in new game or a continuing game
    public boolean isGameEmpty() {
        return sp.getBoolean("GAME_EMPTY", true);
    }

    public void setGameEmpty() {
        editor.putBoolean("GAME_EMPTY", false).commit();
    }
}
