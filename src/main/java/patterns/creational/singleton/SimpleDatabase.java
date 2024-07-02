package patterns.creational.singleton;

public final class SimpleDatabase {
    private static SimpleDatabase database;
    private String value;
    private SimpleDatabase(String value) {
        this.value = value;
        //some logic about connection to db like example
    }

    public static SimpleDatabase getInstance(String value) {
        if (database == null) {
            database = new SimpleDatabase(value);
        }
        return database;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
