package org.igire.week1_shecancode_iro;

import org.igire.week1_shecancode_iro.RealTimeOrderMatchingEngine.ThreadSafeOrderBook.Order;
import org.igire.week1_shecancode_iro.RealTimeOrderMatchingEngine.ThreadSafeOrderBook.OrderBook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OrderBookTest {

    @Test
    public void testOrderBookPerformance() throws Exception {
        runSimulation();
    }

    public void runSimulation() throws Exception {
        OrderBook book = new OrderBook();
        int threadCount = 10;

        /*
        > I refactor my working into sth new , read the README in executor service orchestration
         */
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        int runs = 5;
        double totalThroughput = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();

            // Submit tasks and store Futures
            List<Future<Object>> results = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                int currentJ = j;
                results.add(executor.submit(() -> {
                    // Simulate complex matching logic
                    book.addOrder(new Order("ID-" + System.nanoTime(), "AAPL", 100.0, 1, currentJ % 2 == 0));
                    book.matchOrders();
                    return "Success";
                }));
            }

            // Retrieve results and handle ExecutionException
            for (Future<Object> future : results) {
                try {
                    future.get(); // Blocks until task completes
                } catch (ExecutionException e) {
                    System.err.println("Trade failed: " + e.getCause());
                }
            }

            long end = System.nanoTime();
            double seconds = (end - start) / 1_000_000_000.0;
            double throughput = 100 / seconds;
            totalThroughput += throughput;
        }

        System.out.println("Average Throughput: " + (totalThroughput / runs) + " orders/sec");
        executor.shutdown();
    }
}