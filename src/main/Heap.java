package main;

public class Heap<T extends Comparable> {
		HeapNode[] heap;
		int ActualHeapSize;
		int heapSize = 0;
		
		public Heap(int initialSize)
		{
			heap = new HeapNode[initialSize + 1];
			this.ActualHeapSize = initialSize;
		}
		
		public boolean insert(T value)
		{
			heapSize++;
			if(heapSize == ActualHeapSize)
			{
				//increase the size of the array
			}
			HeapNode n = new HeapNode(value);
			heap[heapSize] = n;
			bottomUp(heapSize);
			return true;
			
		}
		
		public HeapNode pull()
		{
			if(heapSize > 0)
			{
			HeapNode top = heap[1];
			HeapNode bottom = heap[heapSize];
			heap[1] = bottom;
			heap[heapSize] = null;
			heapSize--;
			topDown();
			return top;
			}
			else
			{
				return null;
			}
			
		}
		
		public HeapNode peak()
		{
			if(heap[1] == null)
			{
				return null;
			}
			return heap[1];
		}
		
		
		public void bottomUp(int i)
		{
			int index = i;
			HeapNode indexNode;
			HeapNode parentNode;
			int parent;
			while(index > 1)
			{
				parent = index / 2;
				indexNode = heap[index];
				parentNode = heap[parent];
				if(indexNode.getData().compareTo(parentNode.getData()) > 0)
				{
					heap[parent] = indexNode;
					heap[index] = parentNode;
				}
				index--;		
			}
		}
		public void printList()
		{
			for(int i = 1; i < heap.length; i++)
			{
				HeapNode n = heap[i];
				if(n != null)
				{
					System.out.println(n.getData().toString());
				}
			
				
			}
		}
		
		public void topDown()
		{
			int currentValue = 1;
			HeapNode parent;
			while((currentValue * 2) + 1 <= heapSize)
			{
				
				if(currentValue * 2 <= heapSize)
				{
					HeapNode leftChild = heap[currentValue * 2];
					parent = heap[currentValue];
					if(leftChild.getData().compareTo(parent.getData()) > 0)
					{
						heap[currentValue * 2] = parent;
						heap[currentValue] = leftChild;
					}
					
				}
				if(((currentValue * 2) + 1) <= heapSize)
				{
					HeapNode rightChild = heap[(currentValue * 2) + 1];
					parent = heap[currentValue];
					if(rightChild.getData().compareTo(parent.getData()) > 0)
					{
						heap[(currentValue * 2) + 1] = parent;
						heap[currentValue] = rightChild;
					}
				}
				currentValue++;
			}			
		}

		public int getSize() {
			// TODO Auto-generated method stub
			return heapSize;
		}
		
		
		
		
		
		
		

}
