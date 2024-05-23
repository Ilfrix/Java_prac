package org.example;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepo gameRepo;

    public UUID createGame(Game game){
        gameRepo.save(game);
        return game.id;
    }

    public List<Game> getGames(){
        return gameRepo.findAll();
    }
    public void deleteGame(UUID id) {
        gameRepo.deleteById(id);
    }

    public List<Game> getGamesSortedBy(String attributeName){
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return gameRepo.findAll(GameSpecification.sortBy(attributeName), sort);
    }
}
