import java.time.LocalDate;
import java.util.ArrayList;

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

	@Override
	public String toString() {
		return getSize() + " " + dates.get(getSize() - 1);
	}
	
}
