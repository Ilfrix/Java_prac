package org.example;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService{
    private GameRepo gameRepo;
    @Override
    public Long createGame(Game game) {
        gameRepo.save(game);
        return game.id;
    }

    @Override
    public List<Game> getGames() {
        return gameRepo.findAll();
    }

    @Override
    public void deleteGame(Long id) {
        gameRepo.deleteById(id);
    }

    @Override
    public List<Game> getGamesSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return gameRepo.findAll(GameSpecification.sortBy(attributeName), sort);
    }
}
