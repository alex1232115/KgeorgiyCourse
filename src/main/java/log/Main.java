package log;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println(manager.processTask(new Task(2)));
    }
}
