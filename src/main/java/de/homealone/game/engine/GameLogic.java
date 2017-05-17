package de.homealone.game.engine;


import de.homealone.game.entities.GameResult;
import de.homealone.game.entities.GameState;
import de.homealone.game.entities.GameSymbol;

class GameLogic {

    GameResult evaluateGameResult(GameSymbol symbolPlayerOne, GameSymbol symbolPlayerTwo) {
        if(symbolPlayerOne == symbolPlayerTwo) {
            return new GameResult(null, GameState.DRAW);
        }
        if(symbolPlayerOne == GameSymbol.ROCK) {
            return symbolPlayerTwo == GameSymbol.SCISSORS
                    ? new GameResult(symbolPlayerOne, GameState.PLAYER_ONE_WIN)
                    : new GameResult(symbolPlayerTwo, GameState.PLAYER_TWO_WIN);
        } else if(symbolPlayerOne == GameSymbol.SCISSORS) {
            return symbolPlayerTwo == GameSymbol.PAPER
                    ? new GameResult(symbolPlayerOne, GameState.PLAYER_ONE_WIN)
                    : new GameResult(symbolPlayerTwo, GameState.PLAYER_TWO_WIN);
        } else {
            return symbolPlayerTwo == GameSymbol.ROCK
                    ? new GameResult(symbolPlayerOne, GameState.PLAYER_ONE_WIN)
                    : new GameResult(symbolPlayerTwo, GameState.PLAYER_TWO_WIN);
        }
    }
}
