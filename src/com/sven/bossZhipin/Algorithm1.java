package com.sven.bossZhipin;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Algorithm1 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        Thread thread1 = new MyThread(lock, 'a', 'z');
        Thread thread2 = new MyThread(lock, 'A', 'Z');

        long start = System.currentTimeMillis();
        thread1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nMain time " + (System.currentTimeMillis() - start));
    }
}

class MyThread extends Thread {

    private ReentrantLock lock;

    private char from;
    private char to;

    public MyThread(ReentrantLock lock, char from, char to) {
        this.lock = lock;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (char ch = from; ch <= to; ) {
            try {
                lock.lock();
                System.out.print(ch++);
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        System.out.println("\nThread " + this.getId() + " time " + (System.currentTimeMillis() - start));
    }
}
