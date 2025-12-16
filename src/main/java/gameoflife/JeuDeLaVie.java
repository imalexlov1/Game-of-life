package gameoflife;
import java.util.Random;

public class JeuDeLaVie {
    private final int size = 20;
    private Cell[][] grid;

    public JeuDeLaVie() {
        grid = new Cell[size][size];
        initializeGrid();
    }

    private void initializeGrid() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean startAlive = random.nextDouble() < 0.2; 
                grid[i][j] = new Cell(startAlive);
            }
        }
    }

    public void update() {
        boolean[][] nextStates = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int livingNeighbors = countNeighbors(i, j);
                boolean currentlyAlive = grid[i][j].isAlive();
                if (currentlyAlive) {
                    nextStates[i][j] = (livingNeighbors == 2 || livingNeighbors == 3);
                } else {
                    nextStates[i][j] = (livingNeighbors == 3);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j].setAlive(nextStates[i][j]);
            }
        }
    }

    // Compte les voisins vivants autour d'une case (x, y)
    private int countNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // On ne compte pas la cellule elle-même

                int r = x + i;
                int c = y + j;

                if (r >= 0 && r < size && c >= 0 && c < size) {
                    if (grid[r][c].isAlive()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void display() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();

        System.out.println("--- G E N E R A T I O N ---");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].toString());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        JeuDeLaVie jeu = new JeuDeLaVie();
        
        try {
            while (true) {
                jeu.display();
                jeu.update();
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            System.out.println("Jeu interrompu.");
        }
    }
}