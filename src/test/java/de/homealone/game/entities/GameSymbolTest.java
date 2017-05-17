package de.homealone.game.entities;


import org.junit.Test;

public class GameSymbolTest {

    @Test(expected = IllegalArgumentException.class)
    public void testRandomNumberGreaterTwo() {
        GameSymbol.getForRandomNumberMapping(3);
    }

}
