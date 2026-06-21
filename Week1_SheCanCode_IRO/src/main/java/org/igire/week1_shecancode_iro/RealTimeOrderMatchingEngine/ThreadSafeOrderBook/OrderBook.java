package org.igire.week1_shecancode_iro.RealTimeOrderMatchingEngine.ThreadSafeOrderBook;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class OrderBook {
    private final ConcurrentLinkedQueue<Order> buyOrders = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Order> sellOrders = new ConcurrentLinkedQueue<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addOrder(Order o) {
        if (o.isBuy()) buyOrders.add(o);
        else sellOrders.add(o);
    }

    public void matchOrders() {
        lock.lock(); // Critical Section: Only one thread can match orders at a time
        try {
            while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
                Order buy = buyOrders.peek();
                Order sell = sellOrders.peek();

                if (buy.price() >= sell.price()) {
                    buyOrders.poll();
                    sellOrders.poll();
                    System.out.println("Matched: " + buy.id() + " with " + sell.id());
                    System.out.println("Trade executed!");
                } else break;
            }
        } finally {
            lock.unlock();
        }
    }
}
