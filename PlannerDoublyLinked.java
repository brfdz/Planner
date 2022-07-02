import java.time.LocalDate;

public class PlannerDoublyLinked {
	private DayNode first;
	private DayNode last;
	
	
	public PlannerDoublyLinked() {
		first = null;
		last = null;
	}
	
	
	public void insert(DayNode day) {
		//no record in the list yet
		if (isEmpty()) {
			first = last = day;
			return;
		}
		else {
			DayNode current = first;
			while(current != null) {
				if (current.getDate().isBefore(day.getDate())) {
					//day is chronologically first
					if(current == first) {
						day.setPrev(first);
						first.setNext(day);
						first = day;
						return;
					}
					//day is in between other days
					else {
						day.setPrev(current);
						day.setNext(current.getNext());
						current.getNext().setPrev(day);
						current.setNext(day);
						return;
					}
				}
				
				//day is chronologically smaller than all days
				else if (current == last) {
					//insert item to the end of the list
					day.setNext(last);
					last.setPrev(day);
					last = day;
					return;
				}

				current = current.getPrev();
			}
		}
	}
	
	//look if the record for the given date exist
	public boolean isExists(LocalDate date) {
		DayNode current = first;
	
		while(current != null) {
			if(current.getDate().isEqual(date)) 
				return true;
			else {
				current = current.getPrev();
			}
		}
		return false;
	}

	public DayNode getDay(LocalDate date) {
		DayNode current = first;
		while(current != null) {
			if(current.getDate().isEqual(date))
				return current;
			else
				current = current.getPrev();
		}
		
		return current;
	}
	
	
	public DayNode addDayPrev(DayNode today) {
		DayNode prev = new DayNode();
		prev.setDate(today.getDate().minusDays(1));
		if(today.getPrev() == null) {
			prev.setNext(today);
			today.setPrev(prev);
		}
		else {
			prev.setNext(today);
			prev.setPrev(today.getPrev());
			today.getPrev().setNext(prev);
			today.setPrev(prev);
		}
		
		return prev;
	}
	
	public DayNode addDayNext(DayNode today) {
		DayNode next = new DayNode();
		next.setDate(today.getDate().plusDays(1));
		
		if(today.getNext() == null) {
			next.setPrev(today);
			today.setNext(next);
		}
		else {
			next.setPrev(today);
			next.setNext(today.getNext());
			today.getNext().setPrev(next);
			today.setNext(next);
		}
		
		if(today == first) {
			first = next;
		}
		
		return next;
	}
	
	
	public boolean isEmpty()
	{
		return first == null && last == null;
	}

	public DayNode getLast() {
		return last;
	}

	public void setLast(DayNode last) {
		this.last = last;
	}

	public DayNode getFirst() {
		return first;
	}

	public void setFirst(DayNode first) {
		this.first = first;
	}
	
	
	public void printAll() {
		DayNode current = first;
		while(current != null) {
			System.out.println(current.printDate());
			current = current.getPrev();
		}
	}
}
