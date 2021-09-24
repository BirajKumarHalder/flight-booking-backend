package com.flight.booking.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FlightUtils {

	public static String generatePnrNumber() {
		int leftLimit = 65;
		int rightLimit = 90;
		int targetStringLength = 6;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

	public static String generateTicketNumber() {
		int leftLimit = 49;
		int rightLimit = 57;
		int targetStringLength = 10;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

	public static String getDayOfDate(String date, String inputFormat) {
		String day = null;
		try {
			day = date != null ? new SimpleDateFormat("EEEE").format(new SimpleDateFormat(inputFormat).parse(date))
					: null;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("unparsable date " + date);
		}
		return day;
	}

	public static Date getFormattedDate(String date, String inputFormat) {
		Date formattedDate = null;
		try {
			formattedDate = date != null ? new SimpleDateFormat(inputFormat).parse(date) : null;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("unparsable date " + date);
		}
		return formattedDate;
	}

	public static String getFormattedDate(Date date, String inputFormat) {
		String formattedDate = date != null ? new SimpleDateFormat(inputFormat).format(date) : null;
		return formattedDate;
	}

}
