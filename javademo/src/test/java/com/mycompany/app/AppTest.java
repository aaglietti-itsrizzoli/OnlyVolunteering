package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.mycompany.app.game.Main;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        assertTrue( true );
    }

    @Test
    public void shouldPlayUseCase1() throws IOException, InterruptedException, URISyntaxException {
        String inputData = new StringBuilder()
            .append("1")
            .append(System.getProperty("line.separator"))
            .append("Thorin")
            .append(System.getProperty("line.separator"))
            .append("0") // first goblin
            .append(System.getProperty("line.separator"))
            .append("2") // heavy attack
            .append(System.getProperty("line.separator"))
            .append("1") // second goblin
            .append(System.getProperty("line.separator"))
            .append("2") // heavy attack
            .append(System.getProperty("line.separator"))
            .append("L") // left
            .append(System.getProperty("line.separator"))
            .append("n") // no hostile way
            .append(System.getProperty("line.separator"))
            .append("Y") // swap weapon
            .append(System.getProperty("line.separator"))
            .append("5") // run away from dragon
            .append(System.getProperty("line.separator"))
            .append("5") // exit from the game
            .append(System.getProperty("line.separator"))
            .toString();
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(testIn);

        Main.main(null);
    }
}
