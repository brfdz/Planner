package Sen2212.src.planhabit;

import java.util.ArrayList;

public class PlannerMaxHeap < T extends Comparable < ? super T >>
{
	private T [] heap; // array of heap entries
	private int lastIndex ; // index of last entry
	private static final int DEFAULT_INITIAL_CAPACITY= 25;
	
	public PlannerMaxHeap()//default constructor
	{
		this(getDefaultInitialCapacity()); 
		
	}
	
	public PlannerMaxHeap(int initialCapacity)
	{
		T [] tempHeap= (T []) new Comparable [initialCapacity+ 1];
		setHeap(tempHeap);
		lastIndex = 0;
		
	}
	
	public PlannerMaxHeap(Habit today) {
		// TODO Auto-generated constructor stub
	}

	public void add (T newEntry)
	{
		setLastIndex(getLastIndex() + 1);
		int newIndex= getLastIndex(); 
		int parentIndex= newIndex/ 2;
		while((parentIndex> 0) && newEntry.compareTo(getHeap()[parentIndex]) > 0)
		{
			getHeap()[newIndex] = getHeap()[parentIndex];
			newIndex= parentIndex;
			parentIndex= newIndex/ 2;
			}
		getHeap()[newIndex] = newEntry;
		}
	
	public boolean isEmpty() 
	{
		return lastIndex< 1;
		}
	public T removeMax()
	{
		T root = null;
		if(!isEmpty())
		{
			root = heap[1]; // return value
			heap[1] = heap[lastIndex]; // form a semiheap
			lastIndex--; // decrease size
			reheap(1); // transform to a heap
			}
		return root;
		}
	
	private void reheap(int rootIndex)
	{
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex= 2 * rootIndex;
		while(!done && (leftChildIndex<= lastIndex))
		{
			int largerChildIndex= leftChildIndex; // assume larger
			int rightChildIndex= leftChildIndex+ 1;
			if((rightChildIndex<= lastIndex) &&
					heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
			{
				largerChildIndex= rightChildIndex;
				}
			if(orphan.compareTo(heap[largerChildIndex]) < 0)
			{
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex= largerChildIndex;
				leftChildIndex= 2 * rootIndex;
				}
			else
				done = true;
			}
		heap[rootIndex] = orphan;
		
		}
	

	
	


	public T [] getHeap() {
		return heap;
	}

	public void setHeap(T [] heap) {
		this.heap = heap;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public static int getDefaultInitialCapacity() {
		return DEFAULT_INITIAL_CAPACITY;
	}


}

