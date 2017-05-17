package de.homealone.game.engine;


import de.homealone.game.entities.GameResult;
import de.homealone.game.entities.GameState;
import de.homealone.game.entities.GameSymbol;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GameLogicTest {

    private GameLogic gameLogic = new GameLogic();

    @Test
    public void testDraw() {
        assertThat(gameLogic.evaluateGameResult(GameSymbol.ROCK, GameSymbol.ROCK).getGameState(), is(GameState.DRAW));
        assertThat(gameLogic.evaluateGameResult(GameSymbol.SCISSORS, GameSymbol.SCISSORS).getGameState(), is(GameState.DRAW));
        assertThat(gameLogic.evaluateGameResult(GameSymbol.PAPER, GameSymbol.PAPER).getGameState(), is(GameState.DRAW));
    }

    @Test
    public void testPaperBeatsRock() {
        GameResult result = gameLogic.evaluateGameResult(GameSymbol.ROCK, GameSymbol.PAPER);
        assertThat(result.getGameState(), is(GameState.PLAYER_TWO_WIN));
        assertThat(result.getWinningSymbol(), is(GameSymbol.PAPER));

        result = gameLogic.evaluateGameResult(GameSymbol.PAPER, GameSymbol.ROCK);
        assertThat(result.getGameState(), is(GameState.PLAYER_ONE_WIN));
        assertThat(result.getWinningSymbol(), is(GameSymbol.PAPER));
    }

    @Test
    public void testRockBeatsScissors() {
        GameResult result = gameLogic.evaluateGameResult(GameSymbol.ROCK, GameSymbol.SCISSORS);
        assertThat(result.getGameState(), is(GameState.PLAYER_ONE_WIN));
        assertThat(result.getWinningSymbol(), is(GameSymbol.ROCK));

        result = gameLogic.evaluateGameResult(GameSymbol.SCISSORS, GameSymbol.ROCK);
        assertThat(result.getGameState(), is(GameState.PLAYER_TWO_WIN));
        assertThat(result.getWinningSymbol(), is(GameSymbol.ROCK));
    }

    @Test
    public void testScissorsBeatsPaper() {
        GameResult result = gameLogic.evaluateGameResult(GameSymbol.PAPER, GameSymbol.SCISSORS);
        assertThat(result.getGameState(), is(GameState.PLAYER_TWO_WIN));
        assertThat(result.getWinningSymbol(), is(GameSymbol.SCISSORS));

        result = gameLogic.evaluateGameResult(GameSymbol.SCISSORS, GameSymbol.PAPER);
        assertThat(result.getGameState(), is(GameState.PLAYER_ONE_WIN));
        assertThat(result.getWinningSymbol(), is(GameSymbol.SCISSORS));
    }
}
