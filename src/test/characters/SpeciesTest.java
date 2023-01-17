package test.characters;

import characters.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SpeciesTest {
    private static final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Species species;
    @BeforeEach
    void setUp() {
        species = new Species("Species", 100, 10);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void heal() {
        species.heal(10);
        assertEquals(110, species.getHealth());
    }

    @Test
    void speak() {
        species.speak("test");
        assertEquals("Species: test", outputStreamCaptor.toString().trim());
    }

    @Test
    void attack() {
        Species opponent = new Species("Opponent",100,10);
        species.attack(opponent);
        assertEquals(90,opponent.getHealth());

    }

    @Test
    void takeDamage() {
        species.takeDamage(10);
        assertEquals(90, species.getHealth());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}