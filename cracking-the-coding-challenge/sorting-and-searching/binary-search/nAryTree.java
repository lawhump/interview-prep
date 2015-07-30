abstract public class nAryTree implements Trees{
	protected Node head;

	// LOL
	public Node getHead() {
		return this.head;
	}

	abstract public void insert(int v);
	abstract public Node find(int v);

	abstract public void levelOrderTraversal();
	abstract public void preOrderTraversal();
	abstract public void inOrderTraversal();
	abstract public void postOrderTraversal();
}