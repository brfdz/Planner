

import java.time.LocalDate;
import java.util.ArrayList;

public class Habit {
	private String name;
	private int current;
	private int total;
	private StreaksMaxHeap streaks;
	private ArrayList<LocalDate> dates;
	
	public Habit(String name) {
		this.name = name;
		streaks = new StreaksMaxHeap();
		current = 0;
		total = 0;
		dates = new ArrayList<LocalDate>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public StreaksMaxHeap getStreaks() {
		return streaks;
	}

	public void setStreaks(StreaksMaxHeap streaks) {
		this.streaks = streaks;
	}

	public ArrayList<LocalDate> getDates() {
		return dates;
	}

	public void setDates(ArrayList<LocalDate> dates) {
		this.dates = dates;
	}
	
	@Override
	public String toString() {
		return name + "           " + current + streaks.getMax() + total;
	}
	
}
