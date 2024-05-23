package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private ArrayList<Game> repo;
    public GameController() {
        repo = new ArrayList<>();
    }
    @GetMapping("/")
    public List<Game> getGames() {
        return repo;
    }
    @PostMapping("/")
    public Game createGame(@RequestBody Game newGame) {
        repo.add(newGame);
        Game game = repo.get(repo.size() - 1);
        game.id = repo.size() - 1;
        return game;
    }
    @DeleteMapping("/{id}")
    public Game deleteGame(@PathVariable Long id) {
        try{
            Game game = repo.get(id.intValue());
            repo.remove(id.intValue());
            return game;
        } catch (Error e) {
            return null;
        }
    }
}
