package com.example;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class StudyDateTimeFormatter {

	public static void main(String[] args) {
		Locale tr = new Locale("tr","TR");
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dtf = 
		   DateTimeFormatter.ofLocalizedDateTime(
						   FormatStyle.FULL
				).withLocale(Locale.ITALY);
		DateTimeFormatter myFormatter =
				DateTimeFormatter.ofPattern("uuuu-MMM-dd")
				     .withLocale(tr);
		System.out.println(dtf.format(now));
		System.out.println(myFormatter.format(now));

	}

}






