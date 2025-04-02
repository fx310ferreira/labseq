package com.labseq;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class LabseqService {

    private final Map<Integer, Long> cache = new ConcurrentHashMap<>();

    public long getLabseq(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long[] values = new long[Math.max(n + 1, 4)];
        values[0] = 0;
        values[1] = 1;
        values[2] = 0;
        values[3] = 1;

        for (int i = 4; i <= n; i++) {
            values[i] = values[i - 4] + values[i - 3];
        }

        for (int i = 0; i <= n; i++) {
            cache.putIfAbsent(i, values[i]);
        }

        return values[n];
    }

    public Map<Integer, Long> getCache() {
        return cache;
    }
}
