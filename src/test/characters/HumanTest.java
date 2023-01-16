package test.characters;

import characters.Human;
import characters.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private static final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Human human;

    @BeforeEach
    void setup(){
        human = new Human("Human",100,5,"AR-15",100);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void equipWeapon(){
        human.equipWeapon("AK-47");
        assertEquals("AK-47",human.getWeapon());
    }

    @Test
    public void attack(){
        Species opponent = new Species("Opponent",100,10);
        human.attack(opponent);
        assertEquals(80,opponent.getHealth());
    }

    @Test
    public void attack2(){
        Species opponent = new Species("Opponent",100,10);
        human.weapon="AK-47";
        human.attack(opponent);
        assertEquals(95,opponent.getHealth());
    }


    @Test
    public void takeDamage(){
        human.takeDamage(110);
        assertEquals(90,human.getHealth());
        assertEquals(0,human.getArmor());
        assertEquals("Human: Shit ! You destroy my shield and you hurt me !", outputStreamCaptor.toString().trim());

    }

    @Test
    public  void takeDamage2(){
        human.takeDamage(100);
        assertEquals(0,human.getArmor());
        assertEquals("Human: HAHA ! Nice try but my armor took the damage !", outputStreamCaptor.toString().trim());
    }

    @Test
    public  void takeDamage3(){
        human.armor=0;
        human.takeDamage(50);
        assertEquals(50,human.getHealth());
        assertEquals("Human: Argh... You hurt me !", outputStreamCaptor.toString().trim());
    }

    @Test
    public void takeDamage4(){
        human.takeDamage(200);
        assertEquals(0,human.getArmor());
        assertEquals(0,human.getHealth());
        assertEquals("Human: Shit ! You destroy my shield and you hurt me !\nHuman: GG you got me !", outputStreamCaptor.toString().trim());
    }

    @Test
    public void heal(){
        human.health=90;
        human.heal(10);
        assertEquals(100,human.getHealth());
        assertEquals("Human: I heal myself !",outputStreamCaptor.toString().trim());
    }

    @Test
    public  void heal2(){
        human.heal(10);
        assertEquals("Human: I feel good ! I don't need to heal me",outputStreamCaptor.toString().trim());
    }

    @Test
    public void eat(){
        human.eat();
        assertEquals(6,human.getAttack());
        assertEquals("Human: Hmmm...That's was delicious. I feel more stronger !!!",outputStreamCaptor.toString().trim());
    }

    @Test
    public void eat2(){
        human.attack=10;
        human.eat();
        assertEquals("Human: I have already eaten enough !",outputStreamCaptor.toString().trim());

    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

}
