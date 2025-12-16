import org.junit.jupiter.api.Test;

import gameoflife.Cell;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testCellCreation_Alive() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive(), "La cellule devrait être vivante à l'initialisation.");
    }

    @Test
    public void testCellCreation_Dead() {
        Cell cell = new Cell(false);
        assertFalse(cell.isAlive(), "La cellule devrait être morte à l'initialisation.");
    }

    @Test
    public void testSetAlive() {
        Cell cell = new Cell(false);
        cell.setAlive(true);
        assertTrue(cell.isAlive(), "La cellule devrait être vivante après setAlive(true).");
        
        cell.setAlive(false);
        assertFalse(cell.isAlive(), "La cellule devrait être morte après setAlive(false).");
    }

    @Test
    public void testToString() {
        Cell aliveCell = new Cell(true);
        assertEquals("x ", aliveCell.toString(), "La représentation vivante est incorrecte.");

        Cell deadCell = new Cell(false);
        assertEquals(". ", deadCell.toString(), "La représentation morte est incorrecte.");
    }
}