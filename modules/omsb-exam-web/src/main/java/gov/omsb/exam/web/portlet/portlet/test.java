package gov.omsb.exam.web.portlet.portlet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class test {

	public static void main(String[] args) {
		LocalDate todatDate = LocalDate.now();
		System.out.println("noOfDays >>>>>>"+ todatDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",
				Locale.ENGLISH);
		LocalDate examDate = LocalDate.parse("09/10/2023", formatter);
		System.out.println("examDate >>>>>>"+ examDate);
		long noOfDays = ChronoUnit.DAYS.between(todatDate, examDate);
		System.out.println("noOfDays >>>>>>"+ noOfDays);
	
	}

}
