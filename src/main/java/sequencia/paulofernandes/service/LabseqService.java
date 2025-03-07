package sequencia.paulofernandes.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LabseqService {

    private Map<Integer, Long> cache = new HashMap<>();

    public long calculateLabseq(int n) {
        long startTime = System.currentTimeMillis();// Inicia a medição do tempo

        // Verifica se o valor já está no cache
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Casos base
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 0;
        if (n == 3) return 1;

        // Preenche o cache com os valores iniciais
        cache.put(0, 0L);
        cache.put(1, 1L);
        cache.put(2, 0L);
        cache.put(3, 1L);

        // Calcula os valores iterativamente
        for (int i = 4; i <= n; i++) {
            long value = cache.get(i - 4) + cache.get(i - 3);
            cache.put(i, value);
        }

        long endTime = System.currentTimeMillis(); // Finaliza a medição do tempo
        long executionTime = endTime - startTime; // Tempo de execução em milissegundos

        // Verifica se o tempo de execução excede 8 segundos
        if (executionTime > 8000) { // 8000 ms = 8 segundos
            throw new RuntimeException("O cálculo excedeu o tempo limite de 8 segundos. Tempo gasto: " + executionTime + " ms");
        }
        System.out.println("Tempo de execução: " + executionTime + " ms");

        return cache.get(n);
    }
}
