package ua.kud;

import java.util.Calendar;

public class DayOfTheWeek {
	public static void main(String[] args) {
		System.out.println(dayOfTheWeek(31, 8, 2019));
		System.out.println(dayOfTheWeek(18, 7, 1999));
		System.out.println(dayOfTheWeek(15, 8, 1993));

	}

	public static String dayOfTheWeek(int day, int month, int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, day);
		
		String dayOfWeek = "Sunday";
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			dayOfWeek = "Monday";
			break;
		case Calendar.TUESDAY:
			dayOfWeek = "Tuesday";
			break;
		case Calendar.WEDNESDAY:
			dayOfWeek = "Wednesday";
			break;
		case Calendar.THURSDAY:
			dayOfWeek = "Thursday";
			break;
		case Calendar.FRIDAY:
			dayOfWeek = "Friday";
			break;
		case Calendar.SATURDAY:
			dayOfWeek = "Saturday";
			break;
		}

		return dayOfWeek;
	}
}
