package com.sven.didi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Algorithm02 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);
        // ArrayBlockingQueue<Integer> queue3 = new ArrayBlockingQueue<>(1);
        queue1.add(1);
        MyThread myThread1 = new MyThread(queue1, queue2);
        MyThread myThread2 = new MyThread(queue2, queue1);
        // MyThread myThread2 = new MyThread(queue2, queue3);
        // MyThread myThread3 = new MyThread(queue3, queue1);
        myThread1.start();
        myThread2.start();
        // myThread3.start();
    }
}

class MyThread extends Thread {

    private ArrayBlockingQueue<Integer> queue1;
    private ArrayBlockingQueue<Integer> queue2;

    public MyThread(ArrayBlockingQueue<Integer> queue1, ArrayBlockingQueue<Integer> queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int n = queue1.take();
                System.out.println(n);
                TimeUnit.SECONDS.sleep(1);
                queue2.put(n + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
