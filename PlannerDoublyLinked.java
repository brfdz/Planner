
public class PlannerDoublyLinked {
	private DayNode last;
	private DayNode first;
	
	
	public PlannerDoublyLinked() {
		last = null;
		first = null;
	}
	
	public PlannerDoublyLinked(DayNode day) {
		first = last = day;
	}
	
	public boolean isEmpty()
	{
		return first == null && last == null;
	}
	
	public DayNode addDayPrev(DayNode today) {
		DayNode prev;
		if(today.getPrev() == null) {
			prev = new DayNode();
			prev.setDate(today.getDate().minusDays(1));
			prev.setNext(today);
			today.setPrev(prev);
		}
		else {
			prev = new DayNode();
			prev.setDate(today.getDate().minusDays(1));
			prev.setNext(today);
			prev.setPrev(today.getPrev());
			today.getPrev().setNext(prev);
			today.setPrev(prev);
		}
		
		return prev;
	}
	

	public DayNode addDayNext(DayNode today) {
		DayNode next = new DayNode();
		if(today.getNext() == null) {
			next.setDate(today.getDate().plusDays(1));
			next.setPrev(today);
			today.setNext(next);
		}
		else {
			next.setDate(today.getDate().plusDays(1));
			next.setPrev(today);
			next.setNext(today.getNext());
			today.getNext().setPrev(next);
			today.setNext(next);
		}
		
		return next;
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
	
	
	
}
