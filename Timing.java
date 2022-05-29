
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
}
