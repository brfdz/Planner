

import java.time.LocalDate;
import java.util.ArrayList;

public class StreaksMaxHeap 
{
	private ArrayList<Streak> heap;
	
	public StreaksMaxHeap()
	{ 
		heap = new ArrayList<Streak>();
		heap.add(null);
	}
	
	public StreaksMaxHeap(Streak initial) 
	{
		heap = new ArrayList<Streak>();
		heap.add(null);
		addValue(initial);
	}
	
	
	public int addValue(Streak value)
	{
		heap.add(value);
		int newIndex = heap.size() - 1;
		int parentIndex = newIndex / 2;
		while(parentIndex > 0 && value.getSize() > heap.get(parentIndex).getSize())
		{
			heap.set(newIndex, heap.get(parentIndex));
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
			}
		
		heap.set(newIndex, value);
		return newIndex;
	}
	
	public Streak getMax()
	{
		if(heap.size() > 1)
			return heap.get(1);
		else
			return null;
	}
	
	public int getTotal() {
		int total = 0;
		for (int i = 1; i < heap.size(); i++) {
			total += heap.get(i).getSize();
		}
		
		return total;
	}
	
	public int reheap(int change, Streak newValue) {
		//bubble up
		//new value is bigger than before
		if(newValue.getSize() > heap.get(change).getSize()) {
			bubbleUp(change, newValue);
		}
		
		//bubble down
		//new value is smaller than before
		else if(newValue.getSize() < heap.get(change).getSize()) {
			bubbleDown(change, newValue);
		}
		
		return change;
	}
	
	
	public int bubbleUp(int change, Streak newValue) {
		int parentIndex = change / 2;
		
		while(parentIndex > 0 && heap.get(parentIndex).getSize() < newValue.getSize())  {
			heap.set(change, heap.get(parentIndex));
			change = parentIndex;
			parentIndex = change / 2;
		}
		 heap.set(change, newValue);
		 return change;
	}
	
	public int bubbleDown(int change, Streak newValue) {
		int leftIndex = 2 * change;
		while(leftIndex < heap.size()) 
		{
			int larger = leftIndex;
			int rightIndex = leftIndex + 1;
			
			//if there is a right child compare two children
			if(rightIndex < heap.size() && 
					heap.get(rightIndex).getSize() > heap.get(leftIndex).getSize()) {
				larger = rightIndex;
			}
			
			//check whether larger child is bigger than updated
			if(heap.get(larger).getSize() > (newValue).getSize()) {
				heap.set(change, heap.get(larger));
				change = larger;
				leftIndex = 2 * change;
			}
			
			else {
				break;
			}
		}
		
		heap.set(change, newValue);
		return change;
	}
	
	public void remove(int index) {
		//swap last item with the item to be removed
		heap.set(index, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		bubbleDown(index, heap.get(index));
		
	}
	
	
	public int isExists(LocalDate day) {
		for (int i = 1; i < heap.size(); i++) {
			if(heap.get(i).isContains(day))
				return i;
		}
		return 0;
	}
		

	public ArrayList<Streak> getHeap() {
		return heap;
	}

	public void setHeap(ArrayList<Streak> heap) {
		this.heap = heap;
	}
	
	@Override
	public String toString() {
		String list= "";
		for (int i = 1; i < heap.size(); i++) {
			list += heap.get(i) + "\n";
		}
		return list;
	}
	
}

