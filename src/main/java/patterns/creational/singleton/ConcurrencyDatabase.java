package patterns.creational.singleton;

/**
 * "фабрика" – это всего лишь дополнительная роль для класса. Он уже имеет какую-то бизнес-логику, в
 * которой требуется создание разнообразных продуктов.
 *
 */
public final class ConcurrencyDatabase {
    private static volatile ConcurrencyDatabase database;
    private String value;

    private ConcurrencyDatabase(String value) {
        this.value = value;
        //some logic about connection to db like example
    }

    /**
     * Техника, которую мы здесь применяем называется «блокировка с двойной
     * проверкой» (Double-Checked Locking). Она применяется, чтобы
     * предотвратить создание нескольких объектов-одиночек, если метод будет
     * вызван из нескольких потоков одновременно.
     * Хотя переменная `result` вполне оправданно кажется здесь лишней, она
     * помогает избежать подводных камней реализации DCL в Java.
     */
    public static ConcurrencyDatabase getInstance(String value) {

        ConcurrencyDatabase result = database;
        if (result != null) {
            return result;
        }
        synchronized (ConcurrencyDatabase.class) {
            if (database == null) {
                database = new ConcurrencyDatabase(value);
            }
            return database;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
