package main;

public class AvlTree <T extends Comparable> {
	private AvlNode root;
	private int size = 0;
	public AvlTree()
	{
		root = null;
		
	}
		
	public boolean isEmpty()
	{
		boolean empty = false;
		if(root == null)
		{
			empty = true;
		}
		return empty;
	}
	
	public void clearTree()
	{
		root = null;
	}
	
	private int height(AvlNode n)
	{
		if(n == null)
		{
			return -1;
		}
		else
		{
			return n.getHeight();
		}
	}
	
	public AvlNode getRoot() {
		return root;
	}



	public void setRoot(AvlNode root) {
		this.root = root;
	}



	public AvlNode insert(T data, AvlNode n)
	{
		int compareResult;
		if(n == null)
		{
			n = new AvlNode(data);
		}
		else if(data.compareTo(n.getData()) < 0)
		{
			n.setLeft(insert(data, n.getLeft()));
			
			if(height(n.getLeft()) - height(n.getRight()) == 2)
			{
				compareResult = data.compareTo(n.getLeft().getData());
				if(compareResult < 1)
				{
					n = rotateLeft(n);
				}
				else
				{
					n = doubleLeftRotate(n);
				}
			}
			
		}	
		else if(data.compareTo(n.getData()) > 0)
		{
			n.setRight(insert(data, n.getRight()));
			if(height(n.getRight()) - height(n.getLeft()) == 2)
			{
				compareResult = data.compareTo(n.getRight().getData());
				if(compareResult > 0)
				{
					n = rotateRight(n);
				}
				else
				{
					n = doubleRightRotate(n);
				}
			}
		}	
		n.setHeight(GetMaxHeight(height(n.getLeft()), height(n.getRight())) + 1);
		size++;
		return n;
		
	}
	public int balanceFactor(AvlNode n)
		{
			return height(n.getRight()) - height(n.getLeft());
		}
	public AvlNode peek(AvlNode n)
	{
		AvlNode peek = null;
		if(n == null)
		{
			return null;
		}
		if(n.isLeaf())
		{
			peek = n;
		}
		else if(n.getRight() == null)
		{
			peek = n;
		}
		else if(n.getRight() != null)
		{
			peek = peek(n.getRight());			
		}
		return peek;
	}
	
	public AvlNode pollRight(AvlNode node, AvlNode parent)
	{
		if(parent == null)
		{
			return null;
		}
		else if(parent.isLeaf())
		{
			return parent;
		}
		else if(parent.getRight() == null && parent.getLeft() != null)
		{
			//parent = 
		}
		return null;
	}
	
	public AvlNode poll(AvlNode n)
	{
		//n = balance(n);
		AvlNode pull = null;
		
		if(n.getRight() == null)
		{
			pull = n;
			size--;
			if(n.getLeft() != null)
			{
				n = n.getLeft();
			}
		}
		else if(n.getRight().isLeaf())
		{
			pull = new AvlNode(n.getRight().getData());
			n.setRight(null);
			size--;
		}
		else if(n.getRight().getRight() == null)
		{
			pull = new AvlNode(n.getRight().getData());
			n.setRight(n.getRight().getLeft());
			size--;
		}
		
		else
		{
			pull = poll(n.getRight());
		}
		return balance(pull);
	}
	
	public int Size()
	{
		return size;
	}
	private AvlNode doubleRightRotate(AvlNode n) {
		n.setRight(rotateLeft(n.getRight()));
		return rotateRight(n);
	}

	private AvlNode rotateRight(AvlNode node) 
	{	
		//Fix right rotate
		AvlNode pivot = node.getRight();
		node
		.setRight(pivot
				.getLeft());
		pivot.setLeft(node); 
		node.setHeight(GetMaxHeight(height(node.getLeft()), height(node.getRight())) + 1);
		pivot.setHeight(GetMaxHeight(height(node), height(pivot.getRight())) + 1);
		return pivot;
	}

	private AvlNode doubleLeftRotate(AvlNode n) {
		n.setLeft(rotateRight(n.getLeft()));
		return rotateLeft(n);
	}

	public AvlNode rotateLeft(AvlNode node)
	{
		AvlNode pivot = node.getLeft();
		node
		.setLeft(pivot
				.getRight()); 
		pivot.setRight(node);
		node.setHeight(GetMaxHeight(height(node.getLeft()), height(node.getRight())) + 1);
		pivot.setHeight(GetMaxHeight(height(pivot.getLeft()), height(node)) + 1);
		return pivot;
	}
	
	public int GetMaxHeight(int leftHeight, int rightHeight)
	{
		if(leftHeight > rightHeight)
		{
			return leftHeight;
		}
		else
		{
			return rightHeight;
		}
	}
	
	public AvlNode inorderBalance(AvlNode n)
	{
		if (n != null)
        {
            inorderBalance(n.getLeft());
            n = balance(n);
            inorderBalance(n.getRight());
        }
		return n;
	}
    public void inorder(AvlNode n)
    {
        if (n != null)
        {
            inorder(n.getLeft());
            System.out.println(n.getData().toString() );
            inorder(n.getRight());
        }
    }
	
	public AvlNode balance(AvlNode n){
		if(n == null)
			return n;
		
		if(height(n.getLeft()) - height(n.getRight()) >= 2)
			if(height(n.getLeft().getLeft()) >= height(n.getLeft().getRight()))
				n = rotateLeft(n);
			else
				n = doubleLeftRotate(n);
		else
			if(height(n.getRight()) - height(n.getLeft()) >= 2)
				if(height(n.getRight().getRight()) >= height(n.getRight().getLeft()))
					n = rotateRight(n);
				else
					n = doubleRightRotate(n);

		n.setHeight(GetMaxHeight(height(n.getLeft()), height(n.getRight()))+ 1); 		
		return n;
	}

}
