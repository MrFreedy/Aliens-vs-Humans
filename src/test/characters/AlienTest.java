package test.characters;

import characters.Alien;
import characters.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {
    private static final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Alien alien;

    @BeforeEach
    void setup(){
        alien = new Alien("Alien",250,10,"Phylogus","invisibility");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void heal(){
        alien.heal(10);
        assertEquals(250,alien.getHealth());
        assertEquals("Alien: I feel good ! I don't need to heal me",outputStreamCaptor.toString().trim());
    }

    @Test
    public void heal2(){
        alien.health=90;
        alien.heal(10);
        assertEquals(100,alien.getHealth());
        assertEquals("Alien: I use my genetic to heal myself !",outputStreamCaptor.toString().trim());
    }

    @Test
    public void heal3(){
        alien.health=250;
        alien.heal(10);
        assertEquals("Alien: I feel good ! I don't need to heal me",outputStreamCaptor.toString().trim());
    }

    @Test
    public void mutate(){
        alien.mutate();
        assertEquals("Alien: I can't mutate myself anymore !",outputStreamCaptor.toString().trim());
    }

    @Test
    public void mutate2(){
        alien.attack=5;
        alien.mutate();
        assertEquals(7,alien.getAttack());
        assertEquals("Alien: I mutate myself and I feel more stronger !",outputStreamCaptor.toString().trim());
    }

    @Test
    public void mutate3(){
        alien.attack=9;
        alien.mutate();
        assertEquals(10,alien.getAttack());
        assertEquals("Alien: I mutate myself and I feel more stronger !",outputStreamCaptor.toString().trim());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
