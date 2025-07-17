import java.util.List;
import java.util.Set;

public class Maze {
    private boolean[][] grid;

    private List<Cell> path;

    public Maze(boolean[][] predefinedGrid) {

        this.grid = predefinedGrid;
    }

    public void setPath(List<Cell> path) {
        this.path = path;
    }

    public void printMaze() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell current = new Cell(i, j);
                if (!grid[i][j]) {
                    System.out.print("* ");
                } else if (path != null && path.contains(current)) {
                    System.out.print("> ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void printMazeWithPath(List<Cell> path) {
        setPath(path);
        printMaze();
    }

    public void printMazeWithVisited(Set<Cell> visited) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                Cell cell = new Cell(row, col);
                if (!grid[row][col]) {
                    System.out.print("* ");
                } else if (visited.contains(cell)) {
                    System.out.print("> ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

}
/*
 * hacer el recursivo de 4 direcciones
 * copiar la clase MazeSolver
 * generar otra implementacion
 * PUSH DE LO QUE SE HIZO
 * PUSH DE LAS 4 DIRECCIONES
 */