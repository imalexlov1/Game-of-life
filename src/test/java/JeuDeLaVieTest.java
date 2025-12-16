import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameoflife.JeuDeLaVie;

import static org.junit.jupiter.api.Assertions.*;

public class JeuDeLaVieTest {

    private JeuDeLaVie jeu;

    @BeforeEach
    public void setUp() {
        jeu = new JeuDeLaVie();
        for(int i=0; i<20; i++) {
            for(int j=0; j<20; j++) {
                jeu.setCellState(i, j, false);
            }
        }
    }

    @Test
    public void testUnderpopulation_Dies() {
        jeu.setCellState(10, 10, true);
        jeu.setCellState(10, 11, true); 

        jeu.update();

        assertFalse(jeu.getCellState(10, 10), "La cellule aurait dû mourir (sous-population).");
    }

    @Test
    public void testSurvival() {

        jeu.setCellState(10, 10, true); 
        jeu.setCellState(10, 11, true);
        jeu.setCellState(10, 9, true);

        jeu.update();

        assertTrue(jeu.getCellState(10, 10), "La cellule aurait dû survivre (2 voisins).");
    }

    @Test
    public void testOverpopulation_Dies() {
        jeu.setCellState(10, 10, true); 
        jeu.setCellState(10, 11, true);
        jeu.setCellState(10, 9, true);
        jeu.setCellState(9, 10, true);
        jeu.setCellState(11, 10, true);

        jeu.update();

        assertFalse(jeu.getCellState(10, 10), "La cellule aurait dû mourir (surpopulation).");
    }

    @Test
    public void testReproduction_Born() {
        jeu.setCellState(10, 10, false);
        jeu.setCellState(10, 11, true);
        jeu.setCellState(10, 9, true);
        jeu.setCellState(9, 10, true);

        jeu.update();

        assertTrue(jeu.getCellState(10, 10), "La cellule aurait dû naître (reproduction).");
    }
}