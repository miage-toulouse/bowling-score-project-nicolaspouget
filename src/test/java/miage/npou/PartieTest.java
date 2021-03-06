package miage.npou;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PartieTest {

    Partie unePartie;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void calculScoreSpareTest() {

        // Given : pour une partie où il n'y a que des spares et le lancé supplémentaire à 6
        List<Frame> lesFrames = new ArrayList<Frame>();

        for (int i = 0 ; i<10 ; i++){

            lesFrames.add(new Frame(6,4));

        }

        lesFrames.add(new Frame(6,null));

        unePartie = new Partie(lesFrames);

        // When : on demande le score
        Integer score = unePartie.calculScore();

        // Then : on devrait obtenir 160
        assertEquals(new Integer (160), score);

    }

    @Test
    public void calculScoreStrikeTest(){
        // Given : pour une partie où il n'y a que des strikes
        // et les lancés supplémentaires aussi

        List<Frame> lesFrames = new ArrayList<Frame>();

        for (int i = 0 ; i<10 ; i++){

            lesFrames.add(new Frame(10,null));

        }

        lesFrames.add(new Frame(10,10));

        unePartie = new Partie(lesFrames);

        // When : on demande le score
        Integer score = unePartie.calculScore();

        // Then : on devrait obtenir 300
        assertEquals(new Integer (300), score);
    }

    @Test
    public void calculScoreTest(){

        // Given : pour une partie où tous les scores sont 3 et 6

        List<Frame> lesFrames = new ArrayList<Frame>();

        for (int i = 0 ; i<10 ; i++){

            lesFrames.add(new Frame(3,6));

        }

        unePartie = new Partie(lesFrames);

        // When : on demande le score
        Integer score = unePartie.calculScore();

        // Then : on devrait obtenir 90
        assertEquals(new Integer (90), score);

    }

    @Test
    public void calculScoreRandomTest(){

        // Given : pour une partie où il n'y a que des strikes
        // et les lancés supplémentaires aussi

        List<Frame> lesFrames = new ArrayList<Frame>();

        lesFrames.add(new Frame(3,6));
        lesFrames.add(new Frame(10,null)); // Strike + 5 + 5
        lesFrames.add(new Frame(5,5)); // Spare + 3
        lesFrames.add(new Frame(3,7)); // Spare + 3
        lesFrames.add(new Frame(3,2));
        lesFrames.add(new Frame(3,5));
        lesFrames.add(new Frame(10,null)); // Strike + 8 + 0
        lesFrames.add(new Frame(8,0));
        lesFrames.add(new Frame(7,1));
        lesFrames.add(new Frame(4,6)); // Spare + 8
        lesFrames.add(new Frame(8,null));

        unePartie = new Partie(lesFrames);

        // When : on demande le score
        Integer score = unePartie.calculScore();

        // Then : on devrait obtenir 120
        assertEquals(new Integer (120), score);

    }

}