import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Streak {
	private ArrayList<LocalDate> dates;
	
	
	public Streak() {
		dates = new ArrayList<LocalDate>();
	}
	public ArrayList<LocalDate> getDates() {
		return dates;
	}
	public void setDates(ArrayList<LocalDate> dates) {
		this.dates = dates;
	}
	
	public int getSize() {
		return dates.size();
	}
	
	public void sortDates() {
		Collections.sort(dates, ChronoLocalDate.timeLineOrder());
	}
	
	public boolean isContains(LocalDate day) {
		if (getSize() <= 0)
			return false;
		else
			return dates.get(0).compareTo(day) <= 0 && dates.get(getSize() - 1).compareTo(day) >= 0;
	
	}

	@Override
	public String toString() {
		return dates.toString();
	}
	
}
