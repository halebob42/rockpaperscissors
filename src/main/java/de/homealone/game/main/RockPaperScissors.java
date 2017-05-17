package de.homealone.game.main;


import de.homealone.game.engine.GameContext;
import de.homealone.game.entities.GameStrategy;

public class RockPaperScissors {

    public static void main(String[] args) {
        GameContext gameContext = new GameContext(GameStrategy.RANDOM, GameStrategy.ALWAYS_ROCK);
        gameContext.playGame(100);
        System.out.printf("Outcome while playing One player wins : %s, Two player wins: %s, draws: %s ",
                gameContext.getWinsForPlayerOne(),gameContext.getWinsForPlayerTwo(), gameContext.getDraws());
    }
}
