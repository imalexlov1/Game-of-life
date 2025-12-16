package gameoflife;
public class Cell {
    private boolean isAlive;

    public Cell(boolean initialState) {
        this.isAlive = initialState;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return isAlive ? "x " : ". ";
    }
}