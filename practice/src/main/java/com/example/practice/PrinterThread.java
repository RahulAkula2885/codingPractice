package com.example.practice;

public class PrinterThread {
    private int number = 1;
    private final int MAX = 10;

    public synchronized void printOdd() throws InterruptedException {
        while (number <= MAX) {
            while (number % 2 == 0) wait();
            System.out.println("Odd: " + number++);
            notify();
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (number <= MAX) {
            while (number % 2 == 1) wait();
            System.out.println("Even: " + number++);
            notify();
        }
    }

}
