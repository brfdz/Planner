
public class Timing {
	public static String[] hours() {
		String[] hours = new String[24];
		for (int i = 0; i < 24; i++) {
			hours[i] = (i / 10 == 0? "0": "") + i;
		}
		
		return hours;
	}
	
	public static String[] minutes() {
		String[] minutes = new String[60];
		for (int i = 0; i < 60; i++) {
			minutes[i] = (i / 10 == 0? "0": "") + i;
		}
		
		return minutes;
	}
	
	public static Integer[] months() {
		Integer[] months = new Integer[12];
		for (int i = 0; i < months.length; i++) {
			months[i] = i + 1;
		}
		
		return months;
	}
	
	public static Integer[] daysBase() {
		Integer[] days = new Integer[28];
		for (int i = 0; i < days.length; i++) {
			days[i] = i;
		}
		
		return days;
	}
	
	//returns a list of days for the selcted month
	public static Integer[] days(int month, int year) {
		int numberOfDays = 0;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12: numberOfDays = 31; break;
		case 4, 6, 9, 11: numberOfDays = 30; break;
		case 2: {if (year % 4 == 0 && year % 400 == 0) numberOfDays = 29;
					else numberOfDays = 28;}; 	
		}
		
		Integer[] days = new Integer[numberOfDays];
		for (int i = 0; i < days.length; i++) {
			days[i] = i;
		}
		
		return days;
	}
}
