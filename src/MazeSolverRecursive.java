import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursive implements MazeSolver {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();

        if (grid == null || grid.length == 0)
            return path;

        
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (findPath(grid, start, end, path, visited)) {
            return path; 
        }

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited) {
        int row = current.row;
        int col = current.col;

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;
        if (!grid[row][col] || visited[row][col])
            return false;

        visited[row][col] = true;

        if (row == end.row && col == end.col) {
            path.add(current);
            return true;
        }

        
        if (findPath(grid, new Cell(row + 1, col), end, path, visited) ||  // abajo
            findPath(grid, new Cell(row - 1, col), end, path, visited) ||  // arriba
            findPath(grid, new Cell(row, col + 1), end, path, visited) ||  // derecha
            findPath(grid, new Cell(row, col - 1), end, path, visited)) {  // izquierda
            path.add(current);
            return true;
        }

        return false;
    }
}
