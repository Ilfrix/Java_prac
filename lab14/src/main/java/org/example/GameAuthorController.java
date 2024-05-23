package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("game_authors")
public class GameAuthorController {
    private ArrayList<GameAuthor> repo;
    public GameAuthorController(){
        repo = new ArrayList<>();
    }
    @GetMapping("/")
    public List<GameAuthor> getGameAuthors() {
        return repo;
    }
    @PostMapping("/")
    public GameAuthor createGameAuthor(@RequestBody GameAuthor newGameAuthor) {
        repo.add(newGameAuthor);
        GameAuthor gameAuthor = repo.get(repo.size() - 1);
        gameAuthor.id = repo.size() - 1;
        return gameAuthor;
    }
    @DeleteMapping("/{id}")
    public GameAuthor deleteGameAuthor(@PathVariable Long id) {
        try {
            GameAuthor gameAuthor = repo.get(id.intValue());
            repo.remove(id.intValue());
            return gameAuthor;
        } catch (Error e) {
            return null;
        }
    }
}
