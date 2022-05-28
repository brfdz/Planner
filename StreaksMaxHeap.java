

import java.util.ArrayList;

public class StreaksMaxHeap 
{
	private ArrayList<Integer> heap;
	
	public StreaksMaxHeap()
	{ 
		heap = new ArrayList<Integer>();
		heap.add(null);
	}
	
	
	public void addValue(Integer value)
	{
		heap.add(value);
		int newIndex = heap.size() - 1;
		int parentIndex = newIndex / 2;
		while((parentIndex > 0) && value.compareTo(heap.get(parentIndex)) > 0)
		{
			heap.set(newIndex, heap.get(parentIndex));
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
			}
		
		heap.set(newIndex, value);
	}
	
	public Integer getMax()
	{
		if(heap.size() > 1)
			return heap.get(1);
		else
			return 0;
	}
	
	public int update(int change, Integer newValue) {
		
		if(heap.size() <= 1) {
			addValue(newValue);
			change = 1;
		}
		//bubble up
		//new value is bigger than before
		else if(newValue.compareTo(heap.get(change)) > 0) {
			int parentIndex = change / 2;
			
			while(parentIndex > 0 && heap.get(parentIndex).compareTo(newValue) < 0)  {
				heap.set(change, heap.get(parentIndex));
				change = parentIndex;
				parentIndex = change / 2;
			}
			 heap.set(change, newValue);
		}
		
		//bubble down
		//new value is smaller than before
		else if(newValue.compareTo(heap.get(change)) < 0) {
			int leftIndex = 2 * change;
			while(leftIndex < heap.size()) 
			{
				int larger = leftIndex;
				int rightIndex = leftIndex + 1;
				
				//if there is a right child compare two children
				if(rightIndex < heap.size() && 
						heap.get(rightIndex).compareTo(heap.get(leftIndex)) > 0) {
					System.out.println("yes");
					larger = rightIndex;
				}
				
				//check whether larger child is bigger than updated
				if(heap.get(larger).compareTo(newValue) > 0) {
					heap.set(change, heap.get(larger));
					change = larger;
					leftIndex = 2 * change;
				}
				
				else {
					break;
				}
			}
			
			heap.set(change, newValue);
		}
		
		return change;
	}
	
	public int getCurrent(int index) {
		if(heap.size() > 1 )
			return heap.get(index);
		else 
			return 0;
	}
	

	public ArrayList<Integer> getHeap() {
		return heap;
	}

	public void setHeap(ArrayList<Integer> heap) {
		this.heap = heap;
	}
	
}

