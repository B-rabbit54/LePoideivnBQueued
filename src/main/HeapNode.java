package main;

public class HeapNode <T extends Comparable>{
	private T data;
	
	public HeapNode(T value)
    {
        data = value;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
