package main;

public class AvlNode <T extends Comparable>{
	
	private AvlNode left, right;
    private T data;
    private int height;
	
	public AvlNode(T value)
    {
        left = null;
        right = null;
        data = value;
        height = 0;
    }
	
	public AvlNode getLeft() {
		return left;
	}

	public void setLeft(AvlNode left) {
		this.left = left;
	}

	public AvlNode getRight() {
		return right;
	}

	public void setRight(AvlNode right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isLeaf()
	{
		return this.getRight() == null && this.getLeft() == null;	
	}
	

}
