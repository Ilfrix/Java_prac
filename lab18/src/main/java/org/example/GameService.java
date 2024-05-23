package org.example;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface GameService {
    public Long createGame(Game game);
    public List<Game> getGames();
    public void deleteGame(Long id);
    public List<Game> getGamesSortedBy(String attributeName);

}
