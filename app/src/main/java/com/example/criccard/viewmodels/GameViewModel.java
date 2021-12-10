package com.example.criccard.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.criccard.entities.Game;
import com.example.criccard.repository.GameRepository;

public class GameViewModel extends AndroidViewModel {
    private GameRepository repository;
    private LiveData<Game> game;

    public GameViewModel(@NonNull Application application) {
        super(application);
        repository = new GameRepository(application);
        game = repository.getGame();
    }

    public void updateGame(Game game) { repository.update(game); }
    public void deleteGame() { repository.delete(); }
    public void insertGame(Game game) { repository.insert(game); }
    public void newGame() { repository.newGame(); }
    public boolean isNewGame() { return repository.isGameEmpty(); }
    public LiveData<Game> getGame() { return game; }
}
