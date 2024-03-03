package technologies.concurrency;

import java.util.concurrent.Exchanger;

public class Lecture4 {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Thread thread1 = new Thread(() -> {
            try {
                Integer val1 = 10;
                System.out.println(val1 + " thread 1 before exchange");
                val1 = exchanger.exchange(val1);
                System.out.println(val1 + " thread 1 after exchange");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {

            try {
                Integer val2 = 15;
                System.out.println(val2 + " thread 2 before exchange");
                val2 = exchanger.exchange(val2);
                System.out.println(val2 + " thread 2 after exchange");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}
