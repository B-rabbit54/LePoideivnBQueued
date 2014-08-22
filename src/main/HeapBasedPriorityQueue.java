package main;

public class HeapBasedPriorityQueue<T extends Comparable>  implements Queue{

	Heap heap;
	
	public HeapBasedPriorityQueue(int initialSize)
	{
		heap = new Heap(initialSize);
	}
	@Override
	public boolean offer(Comparable data) {
			
		return heap.insert(data);
	}
	public void print()
	{
		heap.printList();
	}
	
	@Override
	public Comparable poll() {
		HeapNode n = heap.pull();
		if(n == null)
		{
			return null;
		}
		return n.getData();
	}
	
	public int Size()
	{
		return heap.getSize();
	}

	@Override
	public Comparable peek() {
		HeapNode peak = heap.peak();
		if(peak == null)
		{
			return null;
		}
		return peak.getData();
	}


}
