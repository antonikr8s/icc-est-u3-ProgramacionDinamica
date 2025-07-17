import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivoCompleto implements MazeSolver {

    private List<Cell> path;
    private Set<Cell> visited;
    private boolean[][] grid;
    private Cell end;

    public MazeSolverRecursivoCompleto() {
        path = new ArrayList<>();
        visited = new LinkedHashSet<>();
    }

    /*
     * @Override
     * public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
     * this.path.clear();
     * this.visited.clear();
     * this.grid = grid;
     * this.end = end;
     * 
     * if (grid == null || grid.length == 0)
     * return path;
     * 
     * if (findPath(start)) {
     * System.out.println("Camino:");
     * Collections.reverse(path);
     * System.out.println(path);
     * System.out.println("Visitadas:");
     * System.out.println(visited);
     * return path;
     * }
     * 
     * return new ArrayList<>();
     * }
     */
    @Override
    public MazeResult getPath(boolean[][] grid, Cell start, Cell end) {
        this.path.clear();
        this.visited.clear();
        this.grid = grid;
        this.end = end;

        if (grid == null || grid.length == 0)
            return new MazeResult(path, visited);

        if (findPath(start)) {
            Collections.reverse(path);
            return new MazeResult(path, visited);
        }

        return new MazeResult(new ArrayList<>(), visited);
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current))
            return false;

        if (!isValid(current))
            return false;
        visited.add(current);

        if (current.equals(end)) {
            path.add(current);
            return true;
        }

        if (findPath(new Cell(current.row, current.col + 1)) || // DERECHA
                findPath(new Cell(current.row + 1, current.col)) || // ABAJO
                findPath(new Cell(current.row, current.col - 1)) || // IZQUIERDA
                findPath(new Cell(current.row - 1, current.col))) { // ARRIBA

            path.add(current);
            return true;
        }

        
        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }

        return false;

    }

    private boolean isValid(Cell current) {
        if (!grid[current.row][current.col] || visited.contains(current))
            return false;
        return true;
    }

    private boolean isInMaze(Cell current) {
        int row = current.row;
        int col = current.col;

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        return true;

    }
}
