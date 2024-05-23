package org.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepo gameRepo;

    public UUID createGame(UUID id, String name, Date creationDate){
        Game game = new Game(id, name, creationDate);
        gameRepo.save(game);
        return game.id;
    }

    public Game getGame(UUID id){
        var game = gameRepo.findById(id);
        return game.get();
    }
    public void deleteGame(UUID id) {
        gameRepo.deleteById(id);
    }

    public void updateStudent(UUID id, String name, Date creationDate) {
        var optionalGame = gameRepo.findById(id);

        var game = optionalGame.get();
        game.name = name;
        game.creationDate = creationDate;

        gameRepo.save(game);
    }
}
