package de.homealone.game.engine;

import de.homealone.game.entities.GameSymbol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorsEngineTest {

    @InjectMocks
    private RockPaperScissorsEngine rockPaperScissorsEngine;

    @Test
    public void testGenerateResult() {
        GameSymbol gameSymbol = rockPaperScissorsEngine.generateResult();
        assertNotNull(gameSymbol);
    }

}
