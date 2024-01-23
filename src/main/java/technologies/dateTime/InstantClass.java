package technologies.dateTime;

import java.time.Instant;

public class InstantClass {
    // Instant - хранит информацию о моменте из прошлого или будущего
    public static void main(String[] args) {
        Instant currentTimeStamp = Instant.now();
        long milliseconds = currentTimeStamp.toEpochMilli();
        System.out.println(milliseconds);

        Instant stamp = Instant.ofEpochSecond(milliseconds / 1000);
        System.out.println(stamp);

        System.out.println(Instant.MAX);
        System.out.println(Instant.MIN);

        long millis = 9_000_000_000L;
        System.out.println(Instant.ofEpochMilli(millis));
        System.out.println(Instant.ofEpochMilli(-millis));

        if (currentTimeStamp.plusSeconds(99).isAfter(currentTimeStamp.plusSeconds(100))) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }
}
