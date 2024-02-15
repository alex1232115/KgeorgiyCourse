package technologies.concurrency;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello world!"));
        Test test = new Test();
        thread.start();
        test.run();
    }
}
