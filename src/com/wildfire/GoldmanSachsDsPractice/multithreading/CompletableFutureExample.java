package com.wildfire.GoldmanSachsDsPractice.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample implements Runnable {

    private int counter = 1;

    private void orderService() throws InterruptedException {
        ExecutorService cpuBoundService = Executors.newCachedThreadPool();
        ExecutorService ioBoundService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {

            CompletableFuture.supplyAsync(() -> getOrder(), cpuBoundService)
                    .thenApplyAsync(order -> enrichOrder(order), ioBoundService)
                    .thenApply(order -> performPayment(order))
                    .thenAccept(o -> sendEmail(o));
        }

        try {
            if (!cpuBoundService.awaitTermination(20000, TimeUnit.MILLISECONDS)) {
                System.out.println("cpuBoundService - Executor Service shutting down");
                cpuBoundService.shutdownNow();
            }
        } catch (InterruptedException e) {
            cpuBoundService.shutdownNow();
        }

        try {
            if (!ioBoundService.awaitTermination(20000, TimeUnit.MILLISECONDS)) {
                System.out.println("ioBoundService - Executor Service shutting down");
                ioBoundService.shutdownNow();
            }
        } catch (InterruptedException e) {
            ioBoundService.shutdownNow();
        }
    }

    private String getOrder() {
        String orderId = "Order ID " + counter;
        counter++;
        System.out.println("Order created with Order Id - " + orderId);
        return orderId;
    }

    private String enrichOrder(String order) {
        String enrichedOrder = "Your order - " + order + " is enriched now with a free coupon";
        System.out.println("Your order ID is enriched now and Order Id is - " + order);
        return enrichedOrder;
    }

    private String performPayment(String order) {
        System.out.println("Order payment complete for order - " + order);
        return order;
    }

    private void sendEmail(String text) {
        System.out.println("Printing email with order - " + text);
    }

    @Override
    public void run() {
        try {
            orderService();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

