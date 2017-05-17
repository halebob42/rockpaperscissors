package de.homealone.game.entities;


public class GameResult {

    private final GameSymbol winningSymbol;

    private final GameState gameState;

    public GameResult(GameSymbol winningSymbol, GameState gameState) {
        this.gameState = gameState;
        this.winningSymbol = winningSymbol;
    }

    public GameSymbol getWinningSymbol() {
        return winningSymbol;
    }

    public GameState getGameState() {
        return gameState;
    }
}
