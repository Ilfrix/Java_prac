package org.example;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class GameServiceImpl implements GameService{
    private GameRepo gameRepo;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Long createGame(Game game) {
        gameRepo.save(game);
        log.info("create Game");
        return game.id;
    }

    @Override
    public List<Game> getGames() {
        log.info("get games");
        return gameRepo.findAll();
    }

    @Override
    public void deleteGame(Long id) {
        gameRepo.deleteById(id);
        log.info("delete game");
    }

    @Override
    public List<Game> getGamesSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return gameRepo.findAll(GameSpecification.sortBy(attributeName), sort);
    }
}
