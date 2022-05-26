
public class Task {
	private String item;
	private String hour;
	private String minute;
	private String status;
	
	public Task()
	{
		item = "";
		hour = "--";
		minute = "--";
		
	}
	
	public Task(String item)
	{
		this.item = item;
		hour = "--";
		minute = "--";
	}
	
	public Task(String item, String hour, String minute) {
		this.item = item;
		this.hour = hour;
		this.minute = minute;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return hour + ":" + minute + " - " + item;
	}
}
