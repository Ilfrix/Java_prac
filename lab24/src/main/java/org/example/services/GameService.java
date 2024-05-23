package org.example.services;

import org.example.entities.Game;

import java.util.List;

public interface GameService {
    public Long createGame(Game game);
    public List<Game> getGames();
    public void deleteGame(Long id);
    public List<Game> getGamesSortedBy(String attributeName);

}
