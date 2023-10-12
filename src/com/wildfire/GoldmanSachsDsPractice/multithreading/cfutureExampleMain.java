package com.wildfire.GoldmanSachsDsPractice.multithreading;

public class cfutureExampleMain {
    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(new CompletableFutureExample());
            System.out.println("Main Thread starts here");
            Thread.sleep(2000);
            t1.start();
            Thread.sleep(2000);
            for(int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Main method loop checks for intervention with count - " + i);
            }
            System.out.println("Thread state is alive - " + t1.isAlive());
            t1.join();

            System.out.println("Main thread ends here");
            System.out.println("Thread state is alive - " + t1.isAlive());
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
