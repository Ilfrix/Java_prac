package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.example.data.GameDto;
import org.example.services.GameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import org.example.entities.Game;
import org.example.repository.GameRepo;
import org.example.services.GameService;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {
    @Mock
    private GameRepo gameRepo;

    @Captor
    ArgumentCaptor<Game> captor;

    @Test
    public void createGame() {
        GameDto dto = new GameDto("qwerty", new Date(100));
        Game game = new Game(dto);
        GameServiceImpl gameService = new GameServiceImpl(gameRepo);
        gameService.createGame(game);
        Mockito.verify(gameRepo).save(captor.capture());
        Game captured = captor.getValue();
        assertEquals("qwerty", captured.getName());
    }

    @Test
    public void getGames() {
        GameDto dto = new GameDto("qwerty", new Date(100));
        GameDto dto2 = new GameDto("zxcvb", new Date(1000));
        Game game = new Game(dto);
        Game game2 = new Game(dto2);
        Mockito.when(gameRepo.findAll()).thenReturn(List.of(game, game2));
        GameServiceImpl service = new GameServiceImpl(gameRepo);
        Assertions.assertEquals(2, service.getGames().size());
        Assertions.assertEquals("qwerty", service.getGames().get(0).getName());
    }

    @Test
    public void deleteGames() {
        Long id = (long)1;
        gameRepo.deleteById(id);
    }

    @Test
    public void getGamessSortedBy() {
        GameDto dto = new GameDto("qwerty", new Date(100));
        GameDto dto2 = new GameDto("zxcvb", new Date(1000));
        Game game = new Game(dto);
        Game game2 = new Game(dto2);
        Mockito.when(gameRepo.findAll(any(Specification.class), any(Sort.class))).thenReturn(List.of(game, game2));
        GameServiceImpl service = new GameServiceImpl(gameRepo);
        Assertions.assertEquals(2, service.getGamesSortedBy("name").size());
    }
}