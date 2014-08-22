package test;

import static org.junit.Assert.*;

import java.util.Random;

import main.AvlBasedPriorityQueue;
import main.AvlTree;
import main.HeapBasedPriorityQueue;
import main.Value;

import org.junit.Test;

public class QueuedTest {

//	@Test
//	public void test() {
//		int number = 5/2;
//		System.out.println(number);
//	}
	
	
	@Test
	public void HeapPriorityQueueTest()
	{
		HeapBasedPriorityQueue q = new HeapBasedPriorityQueue(200);
		Random rand = new Random();
		for(int i = 0; i < 100; i++)
		{
			int random = rand.nextInt(100);
			Value v = new Value(random);
			q.offer(v);
		}
		System.out.println("Heap poll");
		for ( int i = 0; i < 102; i++ ) {
			System.out.println(q.poll());
		}
		System.out.println("heap poll end");
		//q.print();
		//System.out.println(q.poll().toString());		
		//System.out.println(q.poll());
	}
//	
//	@Test public void AvlPeekTest()
//	{
//		AvlBasedPriorityQueue q = new AvlBasedPriorityQueue();
//		Random rand = new Random();
//		for(int i = 0; i < 100; i++)
//		{
//			int random = rand.nextInt(100);
//			Value v = new Value(random);
//			q.offer(v);
//		}
//		System.out.println("Peek Test");
//		System.out.println(q.peek().toString());
//		System.out.println(q.peek().toString());
//		q.inOrder();
//	}
	
	@Test public void AvlPollTest()
	{
		AvlBasedPriorityQueue q = new AvlBasedPriorityQueue();
		Random rand = new Random();
		for(int i = 0; i < 100; i++)
		{
			int random = rand.nextInt(100);
			Value v = new Value(random);
			q.offer(v);
		}
		q.toString();
		System.out.println("Poll Test");
		
		for(int i = 0; i < 100; i++)
		{
			System.out.println(q.pull());
		}

	}
	
//	@Test
//	public void AvlTreeTest()
//	{
//		AvlBasedPriorityQueue q = new AvlBasedPriorityQueue();
//		Random rand = new Random();
//		for(int i = 0; i < 100; i++)
//		{
//			int random = rand.nextInt(100);
//			Value v = new Value(random);
//			q.offer(v);
//		}
//		System.out.println("inorder");
//		q.inOrder();
//	}

}
