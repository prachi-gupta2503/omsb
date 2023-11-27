package gov.osmb.dashboard.notification.portlet;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Test {

	public static void main(String[] args) {
		long timestampMillis = 1694647377000L; // Replace this with your timestamp
        Instant instant = Instant.ofEpochMilli(timestampMillis);
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        Duration duration = Duration.between(dateTime, currentDate);
        long daysDifference = ChronoUnit.DAYS.between(dateTime.toLocalDate(), currentDate.toLocalDate());
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println("Hours difference: " + hours);
        System.out.println("currentDate: " + currentDate);
        System.out.println("dateTime: " + dateTime);
         
        System.out.println("Minutes difference: " + minutes);
        System.out.println("Difference in days: " + daysDifference);
	}

}
