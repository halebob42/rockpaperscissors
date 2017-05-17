package de.homealone.game.entities;

import java.util.Arrays;

public enum GameSymbol {
    ROCK(0), PAPER(1), SCISSORS(2);

    int randomNumberMapping;

    GameSymbol(int randomNumberMapping) {
        this.randomNumberMapping = randomNumberMapping;
    }

    int getRandomNumberMapping() {
        return randomNumberMapping;
    }

    public static GameSymbol getForRandomNumberMapping(int randomNumber) {
        return Arrays.stream(GameSymbol.values())
                .filter(rpsSymbol -> rpsSymbol.getRandomNumberMapping() == randomNumber)
                .reduce((a, b) ->
                    {throw new IllegalArgumentException("to many elements found: " + a + ", " + b);
                })
                .orElseThrow(() -> new IllegalArgumentException("random number must be between 0-2 but is " + randomNumber));
    }
}
