package technologies.dateTime;

import java.time.*;

public class PeriodDuration {
    public static void main(String[] args) {
        // Period
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2001, Month.MAY, 11);

        Period age = Period.between(birthday, today);
        System.out.println(age.getYears());
        System.out.println(age.getMonths());
        System.out.println(age.getDays());

        // Duration
        LocalDateTime birthday2 = LocalDateTime.of(2001, Month.MAY, 11, 22, 0, 0);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(birthday2, now);
        System.out.println("Ќа момент запуска € прожил: " + duration.getSeconds() + " секунд и " + duration.getNano() + " наносекунд");

        Period theHundredYearsWarPeriod = Period.of(116, 4, 25);
        System.out.println(theHundredYearsWarPeriod);

        Period threeWeeks = Period.ofWeeks(3);
        System.out.println(threeWeeks);

        Duration tenMinutes = Duration.ofMinutes(10);
        System.out.println(tenMinutes);

        Duration fiveDays = Duration.ofDays(5);
        System.out.println(fiveDays);
    }
}
