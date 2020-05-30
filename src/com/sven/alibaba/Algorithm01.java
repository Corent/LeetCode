package com.sven.alibaba;

import java.util.concurrent.ArrayBlockingQueue;

public class Algorithm01 {
}

//1.
// 启动a、b两个线程，由这两个线程打印出1到100共一百个数字。
//   要求：
//   1.a线程打印1、3、5、7等奇数，b线程打印2、4、6、8等偶数。
//   2.依次串行打印，即打印完1之后，再打印2，然后是3、4、5…直到100，全部打印完成后，进程能正常结束。
//

class Solution {

    static class MyThread1 extends Thread {  // print odd

        private ArrayBlockingQueue<Integer> queue1;
        private ArrayBlockingQueue<Integer> queue2;

        public MyThread1(ArrayBlockingQueue<Integer> queue1, ArrayBlockingQueue<Integer> queue2) {
            this.queue1 = queue1;
            this.queue2 = queue2;
        }

        @Override
        public void run() {

            try {
                int n = queue1.take();
                while (true) {
                    System.out.println("Thread1 - " + n);
                    queue2.put(n + 1);
                    if (n == 99) break;
                    n = queue1.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 exit");
        }
    }

    static class MyThread2 extends Thread {  // print even

        private ArrayBlockingQueue<Integer> queue1;
        private ArrayBlockingQueue<Integer> queue2;

        public MyThread2(ArrayBlockingQueue<Integer> queue1, ArrayBlockingQueue<Integer> queue2) {
            this.queue1 = queue1;
            this.queue2 = queue2;
        }

        @Override
        public void run() {

            try {
                int n = queue2.take();
                while (true) {
                    System.out.println("Thread2 - " + n);
                    if (n == 100) break;
                    queue1.put(n + 1);
                    n = queue2.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2 exit");
        }
    }

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);

        queue1.add(1);
        MyThread1 myThread1 = new MyThread1(queue1, queue2);
        MyThread2 myThread2 = new MyThread2(queue1, queue2);

        myThread1.start();
        myThread2.start();
    }
}
