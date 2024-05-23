package org.example.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entities.Game;
import org.example.repository.GameRepo;
import org.example.specifications.GameSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
public class GameServiceImpl implements GameService {
    private GameRepo gameRepo;

    public GameServiceImpl(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }


    public Long createGame(Game game) {
//        log.info("create {}", game);
        gameRepo.save(game);

        return game.id;
    }

    @Override
    public List<Game> getGames() {
        return gameRepo.findAll();
    }

    @Override
    public void deleteGame(Long id) {
//        log.info("delete game with id={}", id);
        gameRepo.deleteById(id);
    }

    @Override
    public List<Game> getGamesSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return gameRepo.findAll(GameSpecification.sortBy(attributeName), sort);
    }
}
