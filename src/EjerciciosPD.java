import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD { // Programacion Dinamica

    // Fibonacci con recursividad normal
    public long getFibonaci(int n) {
        if (n <= 1)
            return n;
        return getFibonaci(n - 1) + getFibonaci(n - 2);
    }

    // Fibonacci usando Integer Integer con memoización
    public long getFibonaciPD(int n) {
        Map<Integer, Long> caching = new HashMap<>();
        return getFibonaciPDHelper(n, caching);
    }

    // Memorizacion con mapa
    private long getFibonaciPDHelper(int n, Map<Integer, Long> cache) {
        if (n <= 1)
            return n;
        if (cache.containsKey(n))
            return cache.get(n);

        long resultado = getFibonaciPDHelper(n - 1, cache) + getFibonaciPDHelper(n - 2, cache);
        cache.put(n, resultado);
        return resultado;
    }
}
