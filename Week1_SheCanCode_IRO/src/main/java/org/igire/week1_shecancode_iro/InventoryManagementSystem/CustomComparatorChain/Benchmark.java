package org.igire.week1_shecancode_iro.InventoryManagementSystem.CustomComparatorChain;

import java.util.*;

public class Benchmark {
    public static void main(String[] args) {
        int n = 10000;
        runBenchmark("ArrayList", new ArrayList<>(), n);
        runBenchmark("LinkedList", new LinkedList<>(), n);
        runBenchmark("HashSet", new HashSet<>(), n);
        runBenchmark("TreeSet", new TreeSet<>(), n);
    }

    private static void runBenchmark(String name, Collection<String> col, int n) {
        // 1. Insertion
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) col.add("SKU-" + i);
        long end = System.nanoTime();
        System.out.println(name + " Insertion: " + (end - start) / 1e6 + " ms");

        // 2. Lookup
        start = System.nanoTime();
        col.contains("SKU-" + (n / 2));
        end = System.nanoTime();
        System.out.println(name + " Lookup: " + (end - start) / 1e6 + " ms");

        // 3. Iteration
        start = System.nanoTime();
        for (String s : col) { /* iterate */ }
        end = System.nanoTime();
        System.out.println(name + " Iteration: " + (end - start) / 1e6 + " ms");

    }

}
