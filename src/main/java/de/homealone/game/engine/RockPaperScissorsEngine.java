package de.homealone.game.engine;


import de.homealone.game.entities.GameSymbol;

import java.util.Random;
import java.util.logging.Logger;

public class RockPaperScissorsEngine {

    private static final Logger LOG = Logger.getLogger(RockPaperScissorsEngine.class.getName());

    private Random random;

    RockPaperScissorsEngine() {
        random = new Random();
    }

    public GameSymbol generateResult() {
        GameSymbol gameSymbol = GameSymbol.getForRandomNumberMapping(random.nextInt(3));
        LOG.fine("Rock, Paper, Scissors Symbol is: " + gameSymbol);
        return gameSymbol;
    }
}
