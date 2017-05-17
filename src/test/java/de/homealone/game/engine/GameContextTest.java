package de.homealone.game.engine;

import de.homealone.game.entities.GameState;
import de.homealone.game.entities.GameStrategy;
import de.homealone.game.entities.GameSymbol;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class GameContextTest {

    private GameContext gameContext;

    @Test
    public void testPlayGameWithDraw() {
        gameContext = new GameContext(GameStrategy.ALWAYS_ROCK, GameStrategy.ALWAYS_ROCK);
        gameContext.playGame();
        assertThat(gameContext.getRPSGameResult(), notNullValue());
        assertThat(gameContext.getRPSGameResult().getWinningSymbol(), nullValue());
        assertThat(gameContext.getRPSGameResult().getGameState(), is(GameState.DRAW));
    }

    @Test
    public void testPlayGameRockBeatsScissors() {
        gameContext = new GameContext(GameStrategy.ALWAYS_ROCK, GameStrategy.ALWAYS_SCISSORS);
        gameContext.playGame();
        assertThat(gameContext.getRPSGameResult(), notNullValue());
        assertThat(gameContext.getRPSGameResult().getGameState(), is(GameState.PLAYER_ONE_WIN));
        assertThat(gameContext.getRPSGameResult().getWinningSymbol(), is(GameSymbol.ROCK));
    }

    @Test
    public void testPlayGameWithRandomOutcome() {
        gameContext = new GameContext(GameStrategy.RANDOM, GameStrategy.RANDOM);
        gameContext.playGame();
        assertThat(gameContext.getRPSGameResult(), notNullValue());
        assertThat(gameContext.getRPSGameResult().getGameState(), notNullValue());
    }

    @Test
    public void testCheckDrawCount() {
        gameContext = new GameContext(GameStrategy.ALWAYS_ROCK, GameStrategy.ALWAYS_ROCK);
        gameContext.playGame(42);
        assertThat(gameContext.getDraws(), is(42));
    }

    @Test
    public void testCheckPlayerOneWinCount() {
        gameContext = new GameContext(GameStrategy.ALWAYS_ROCK, GameStrategy.ALWAYS_SCISSORS);
        gameContext.playGame(17);
        assertThat(gameContext.getDraws(), is(0));
        assertThat(gameContext.getWinsForPlayerOne(), is(17));
        assertThat(gameContext.getWinsForPlayerTwo(), is(0));
    }

    @Test
    public void testCheckPlayerTwoWinCount() {
        gameContext = new GameContext(GameStrategy.ALWAYS_PAPER, GameStrategy.ALWAYS_SCISSORS);
        gameContext.playGame(11);
        assertThat(gameContext.getDraws(), is(0));
        assertThat(gameContext.getWinsForPlayerOne(), is(0));
        assertThat(gameContext.getWinsForPlayerTwo(), is(11));
    }
}
