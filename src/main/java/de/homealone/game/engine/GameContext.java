package de.homealone.game.engine;


import de.homealone.game.entities.Player;
import de.homealone.game.entities.GameResult;
import de.homealone.game.entities.GameState;
import de.homealone.game.entities.GameStrategy;
import de.homealone.game.statistic.GameStatistic;

public class GameContext {

    private final Player playerOne;

    private final Player playerTwo;

    private final GameLogic gameLogic;

    private final GameStatistic gameStatistic;

    private GameResult gameResult;


    public GameContext(GameStrategy strategyPlayerOne, GameStrategy strategyPlayerTwo) {
        final RockPaperScissorsEngine rockPaperScissorsEngine = new RockPaperScissorsEngine();
        gameLogic = new GameLogic();
        gameStatistic = new GameStatistic();
        playerOne = new Player(strategyPlayerOne, rockPaperScissorsEngine);
        playerTwo = new Player(strategyPlayerTwo, rockPaperScissorsEngine);
    }

    public void playGame() {
        playGame(1);
    }

    public void playGame(int times) {
        for (int i = 0; i < times; i++) {
            gameResult = gameLogic.evaluateGameResult(playerOne.roShamBo(), playerTwo.roShamBo());
            if (gameResult.getGameState() == GameState.DRAW) {
                gameStatistic.addDraw();
            } else if (gameResult.getGameState() == GameState.PLAYER_ONE_WIN) {
                gameStatistic.addWinForPlayerOne();
            } else {
                gameStatistic.addWinForPlayerTwo();
            }
        }
    }

    public GameResult getRPSGameResult() {
        return gameResult;
    }

    public int getDraws() {
        return gameStatistic.getDraws();
    }

    public int getWinsForPlayerOne() {
        return gameStatistic.getWinsForPlayerOne();
    }

    public int getWinsForPlayerTwo() {
        return gameStatistic.getWinsForPlayerTwo();
    }
}
