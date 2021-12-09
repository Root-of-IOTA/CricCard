package com.example.criccard.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Handler;

import androidx.lifecycle.LiveData;

import com.example.criccard.dao.GameDao;
import com.example.criccard.database.GameDatabase;
import com.example.criccard.entities.Game;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GameRepository {
    private GameDao dao;
    private LiveData<List<Game>> allGames;
    private LiveData<Game> lastGame;
    private final ExecutorService es = Executors.newSingleThreadExecutor();

    GameRepository(Application application) {
        GameDatabase db = GameDatabase.getInstance(application);
        dao = db.gameDao();
        allGames = dao.getAllGames();
        lastGame = dao.getLastGame();
    }

    public LiveData<Game> getLastGame() { return lastGame; }
    public LiveData<List<Game>> getAllGames() { return allGames; }

    public void update(Game game) {
        es.submit(() -> {
            dao.updateGame(game);
        });
    }

    public void insert(Game game) {
        es.submit(() -> {
            dao.insertGame(game);
        });
    }

    public void delete(Game game) {
        es.submit(() -> {
            dao.deleteGame(game);
        });
    }
}
