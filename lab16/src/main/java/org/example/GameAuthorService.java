package org.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameAuthorService {

    private GameAuthorRepo gameAuthorRepo;


    public UUID create(UUID id, GameAuthor gameAuthor) {
        var gameAuthorRes = new GameAuthor(gameAuthor);

        gameAuthorRepo.save(gameAuthorRes);

        return gameAuthorRes.id;
    }

    public GameAuthor getGameAuthor(UUID id) {
        var gameAuthor = gameAuthorRepo.findById(id);
        return gameAuthor.get();
    }

    public void deleteGameAuthor(UUID id) {
        gameAuthorRepo.deleteById(id);
    }

    public void updateGameAuthor(UUID id, String name, Date creationDate) {
        var optionalGameAuthor = gameAuthorRepo.findById(id);

        var existingGameAuthor = optionalGameAuthor.get();
        existingGameAuthor.nickname = name;

        gameAuthorRepo.save(existingGameAuthor);
    }
}
