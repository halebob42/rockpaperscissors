package de.homealone.game.entities;


import de.homealone.game.engine.RockPaperScissorsEngine;

public class Player {

    private GameStrategy gameStrategy;

    private RockPaperScissorsEngine rockPaperScissorsEngine;

    public Player(GameStrategy gameStrategy, RockPaperScissorsEngine rockPaperScissorsEngine) {
        this.gameStrategy = gameStrategy;
        this.rockPaperScissorsEngine = rockPaperScissorsEngine;
    }

    public GameSymbol roShamBo() {
        switch (gameStrategy) {
            case RANDOM:
                return rockPaperScissorsEngine.generateResult();
            case ALWAYS_PAPER:
                return GameSymbol.PAPER;
            case ALWAYS_SCISSORS:
                return GameSymbol.SCISSORS;
            case ALWAYS_ROCK:
            default:
                return GameSymbol.ROCK;
        }
    }
}
