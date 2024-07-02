package patterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        Runnable thread1Run = () -> {
            ConcurrencyDatabase concurrencyDatabase = ConcurrencyDatabase.getInstance("Thread1");
            System.out.println(concurrencyDatabase.getValue());
        };
        Runnable thread2Run = () -> {
            ConcurrencyDatabase concurrencyDatabase = ConcurrencyDatabase.getInstance("Thread2");
            System.out.println(concurrencyDatabase.getValue());
        };
        Thread thread1 = new Thread(thread1Run);
        Thread thread2 = new Thread(thread2Run);
        thread1.start();
        thread2.start();
    }
}
