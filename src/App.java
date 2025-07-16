import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Nombre: Carlos Antonio Gordillo Tenemaza");
        System.out.println("Correo: cgordillot@est.ups.edu.ec\n");
        // runEjerciciosPD();
        runMaze();
    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonaci(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado: " + resultado + " | en tiempo: " + duration + " ns");

        System.out.println("\nFibonacci Recursivo Caching");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonaciPD(50);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado: " + resultado + " | en tiempo: " + duration + " ns");
    }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
                { true, true, true, true },
                { false, true, true, true },
                { true, true, false, false },
                { true, true, true, true }
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado:");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<MazeSolver> solvers = Arrays.asList(
                new MazeSolverRecursive());

        MazeSolver solver = solvers.get(0);
        List<Cell> path;
        path = solver.getPath(maze.getGrid(), start, end);

        System.out.println("\nCamino encontrado:");
        System.out.println(path);
    }
}