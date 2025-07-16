import java.util.List;

public class Maze {
    private boolean[][] grid;
    private int size;
    private List<Cell> path;

    public Maze(boolean[][] predefinedGrid) {
        this.size = predefinedGrid.length;
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
                    System.out.print("o ");
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

}
/*
 * hacer el recursivo de 4 direcciones
 * copiar la clase MazeSolver
 * generar otra implementacion
 * PUSH DE LO QUE SE HIZO
 * PUSH DE LAS 4 DIRECCIONES
 */