

import java.time.LocalDate;
import java.util.ArrayList;

public class Habit{
	private String name;
	private Streak current;
	private int total;
	private int currentIndex;
	private StreaksMaxHeap streaks;
	
	public Habit(String name) {
		this.name = name;
		current = new Streak();
		streaks = new StreaksMaxHeap(current);
		currentIndex = 0;
		total = 0;
	}
	
	public void updateIncreased(Streak newValue) {
		setCurrentIndex(streaks.bubbleUp(currentIndex, newValue));
	}
	
	public void updateDecreased(Streak newValue) {
		setCurrentIndex(streaks.bubbleDown(currentIndex, newValue));
	}
	
	public Streak getCurrent() {
		return current;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
		current = streaks.getHeap().get(currentIndex);
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
	
	@Override
	public String toString() {
		return name;
	}
	
}
