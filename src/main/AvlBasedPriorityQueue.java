package main;

public class AvlBasedPriorityQueue implements Queue {

	AvlTree avlTree;
	AvlNode root;
	
	public AvlBasedPriorityQueue()
	{
		avlTree = new AvlTree();
		root = null;
	}
	
	@Override
	public boolean offer(Comparable data) {
		root = avlTree.insert(data, root);
		return true;
	}
	@Override
	public Comparable poll()
	{
		AvlNode pull = null;
		if(root == null)
		{
			return null;
		}
		else if(root.isLeaf())
		{
			pull = root;
			root = null;
		}
		else if(root.getRight() == null && root.getLeft() != null)
		{
			AvlNode left = root.getLeft();
			pull = root;
			root = left;
			//root = avlTree.b
		}
		else if(root.getRight() != null)
		{
			pull = avlTree.poll(root);
			
			
		}
		//root = avlTree.inorderBalance(root);
		return pull.getData();
	}
	
public int rootBalanceFactor()
{
	return avlTree.balanceFactor(root);
}
	
//	@Override
//	public Comparable poll() {
//		if(root == null)
//		{
//			return null;
//		}
//		else if(root.isLeaf())
//		{
//			return root.getData();
//		}
//		AvlNode n = avlTree.poll(root);
//		if(n == null)
//		{
//			return null;
//		}
//		return n.getData();
//	}
	
	public int Size()
	{
		return avlTree.Size();
	}

	@Override
	public Comparable peek() {
		AvlNode n = avlTree.peek(root);
		if(n == null)
		{
			return null;
		}
		return n.getData();
	}
	
	public void inOrder()
	{
		avlTree.inorder(root);
	}

	@Override
	public String toString()
	{
		inOrder();
		return "Completed";
		
	}

}
