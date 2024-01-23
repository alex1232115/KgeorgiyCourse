package technologies.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeClass {
    // Удобное представление даты и времени - LocalDateTime
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime newMillennium = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(newMillennium);

        LocalDateTime dateTimeOfTwos = LocalDateTime.of(2222, Month.FEBRUARY, 2, 22, 22);
        System.out.println(dateTimeOfTwos);

        System.out.println(newMillennium.plusYears(1).plusMonths(4).plusDays(10));

        if (newMillennium.isBefore(dateTimeOfTwos)) System.out.println("hi");


        // DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        System.out.println(localDateTime.format(formatter));

        LocalDateTime dateTime = LocalDateTime.parse("2021-12-21T21:21:21");
        System.out.println(dateTime);

        LocalDateTime anotherDateTime = LocalDateTime.parse("22.02.2022, 22:22", formatter);
        System.out.println(anotherDateTime.format(formatter));

        //LocalTime
        LocalTime someTime = LocalTime.of(12,15,35,99);
        LocalTime anotherTime = LocalTime.of(12,15);

        //LocalDate
        LocalDate someDate = LocalDate.of(2000, Month.JANUARY, 1);

        LocalTime time = localDateTime.toLocalTime();
        LocalDate date = localDateTime.toLocalDate();
        System.out.println(time + " " + date);

        System.out.println(LocalDateTime.of(date, time).format(formatter));
    }
}
