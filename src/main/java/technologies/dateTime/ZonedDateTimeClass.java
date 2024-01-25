package technologies.dateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeClass {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("UTC-03:45");
        System.out.println(zoneId);
        // LocalDateTime + ZoneId = ZoneDateTime
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
        System.out.println(zonedDateTime);


        // Временные зоны и привязка к месту
        ZoneId zoneIdPlace = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(dateTime, zoneIdPlace);
        System.out.println(zonedDateTime1);


        //
        Instant moment = Instant.ofEpochSecond(-386310686L);
        System.out.println(moment);

        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(moment, zone);

        System.out.println(zonedDateTime2);

        //
        Instant now = Instant.now();
        ZonedDateTime moscowDateTime = ZonedDateTime.ofInstant(now, zone);

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkDateTime = moscowDateTime.withZoneSameInstant(newYorkZone);

        System.out.println("Moscow: " + moscowDateTime + " New-York: " + newYorkDateTime);
    }
}
