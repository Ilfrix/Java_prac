package org.example.controllers;

import org.example.entities.Game;
import org.example.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/games")
public class GameController {
    private ArrayList<Game> repo;
    private GameService service;
    public GameController() {
        repo = new ArrayList<>();
    }
    @GetMapping("/")
    public List<Game> getGames(@RequestParam Map<String, String> queryParametrs) {
        String attr = queryParametrs.get("sortBy");
        if (attr == null) {
            return service.getGames();
        }
        return service.getGamesSortedBy(attr);
    }
    @PostMapping("/")
    public Game createGame(@RequestBody Game newGame) {
        repo.add(newGame);
        Game game = repo.get(repo.size() - 1);
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
