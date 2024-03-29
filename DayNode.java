
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DayNode implements Serializable{
	private LocalDate date;
	private DayNode prev;
	private DayNode next;
	ArrayList<Task> tasks;
	
	public DayNode()
	{
		date = LocalDate.now();
		prev = null;
		next = null;
		tasks = new ArrayList<Task>();
	}
	
	public DayNode(ArrayList<Task> list)
	{
		date = LocalDate.now();
		prev = null;
		next = null;
		tasks = list;
	}
	
	public DayNode(LocalDate date) {
		this.date = date;
		prev = null;
		next = null;
		tasks = new ArrayList<Task>();
	}
	
	public void addTask(Task item) {
		tasks.add(item);
	}
	
	public void addItem(String item) {
		Task newItem = new Task(item);
		tasks.add(newItem);
	}
	
	public void addItem(String item, String hour, String minute) {
		Task newItem = new Task(item, hour, minute);
		tasks.add(newItem);
	}
	
	public boolean contains(Task t) {
		Task current;
		for(int i = 0; i < tasks.size(); i++) {
			current = tasks.get(i);
			if(current.getItem().equals(t.getItem()) && current.getHour().equals(t.getHour())
					&& current.getMinute().equals(t.getMinute())) {
				return true;
			}
		}
		
		return false;
	}
	
	public String printDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd / MM / yyyy");
		return dtf.format(date);
	}
	
	public String printDateFileName() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return dtf.format(date);
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public DayNode getPrev() {
		return prev;
	}

	public void setPrev(DayNode prev) {
		this.prev = prev;
	}
	
	public DayNode getNext() {
		return next;
	}

	public void setNext(DayNode next) {
		this.next = next;
	}
	

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < tasks.size(); i++) {
			s = tasks.get(i).toString();
		}
		
		return s;
	}
	
	public Task[] toArray() {
		Task[] tasksArray = new Task[tasks.size()];
		for (int i = 0; i < tasksArray.length; i++) {
			tasksArray[i] = tasks.get(i);
		}
		return tasksArray;
 	}

	
}
