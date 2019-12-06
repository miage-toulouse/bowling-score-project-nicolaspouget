package miage.npou;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest {

    private Frame aFrame;

    @Before
    public void setUp() throws Exception {
        //Given : Création d'une frame
        aFrame = new Frame(7,3);
    }

    @Test
    public void getScoreTest() {
        // When : on demande le score
        int score = aFrame.getScore();

        // Then : on vérifie que le score est bien de 10
        assertEquals(10, score);

        // And : on vérifie que ce n'est pas null
        assertNotNull(score);

        // When : En cas de strike sur la partie
        aFrame = new Frame(new Integer(10), null);
        score = aFrame.getScore();

        // Then : on vérifie que le score est bien de 10
        assertEquals(10, score);
    }

    @Test
    public void getLance1Test(){
        // When : on demande le lancé 1
        int l1 = aFrame.getLance1();

        // Then : on vérifie qu'il est bien égal à 7
        assertEquals(7, l1);

        // And : on vérifie qu'il n'est pas égal à 5
        assertNotNull(l1);
    }

    @Test
    public void getLance2Test(){
        // When : on demande le lancé 2
        Integer l2 = aFrame.getLance2();

        // Then : on vérifie qu'il est bien égal à 7
        assertEquals(new Integer(3), l2);

        // And : on vérifie qu'il n'est pas null
        assertNotNull(l2);
    }

    @Test
    public void isSpareTest(){
        // When : une frame est un spare
        boolean isSpare = aFrame.isSpare();

        // Then : Vérifier que c'est bien un spare
        assertEquals(true, isSpare);

        // And : que isSpare n'est pas null
        assertNotNull(isSpare);
    }

    @Test
    public void isStrikeTest(){
        // When : une frame est un strike
        boolean isStrike = aFrame.isStrike();

        // Then : Vérifier que c'est bien un spare
        assertEquals(false, isStrike);

        // And : que isSpare n'est pas null
        assertNotNull(isStrike);
    }
}