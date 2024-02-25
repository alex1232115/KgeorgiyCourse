package technologies.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlock {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                ReentrantLock lock = new ReentrantLock();
                lock.lock();
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread1 let's go: " + i);
                    try {
                        wait(1000);
                    } catch (InterruptedException ignored) {
                    }
                }
                lock.unlock();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread2 let's go: " + i);
                    try {
                        wait(1000);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        };
        thread.start();
        thread2.start();
    }
}