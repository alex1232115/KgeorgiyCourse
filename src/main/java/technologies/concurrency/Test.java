package technologies.concurrency;

public class Test implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello run!");
    }
}
