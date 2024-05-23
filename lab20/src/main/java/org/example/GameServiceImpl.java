package org.example;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GameServiceImpl implements GameService{
    private GameRepo gameRepo;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Long createGame(Game game) {
        log.info("create {}", game);
        gameRepo.save(game);
        return game.id;
    }

    @Override
    public List<Game> getGames() {
        return gameRepo.findAll();
    }

    @Override
    public void deleteGame(Long id) {
        log.info("delete game with id={}", id);
        gameRepo.deleteById(id);
    }

    @Override
    public List<Game> getGamesSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return gameRepo.findAll(GameSpecification.sortBy(attributeName), sort);
    }
}
