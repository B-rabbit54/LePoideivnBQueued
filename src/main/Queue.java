package main;

public interface Queue <T extends Comparable> {
	public boolean offer(T data);
	public T poll();
	public T peek();

}
