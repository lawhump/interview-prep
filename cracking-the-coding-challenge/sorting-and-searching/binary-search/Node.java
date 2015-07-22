public class Node {
	private int val;
	private Node left;
	private Node right;

	public Node() {
		this.val = 0;
		this.left = null;
		this.right = null;
	}

	public Node(int v) {
		this.val = v;
		this.left = null;
		this.right = null;
	}

	public Node(Node n) {
		this.val = n.val;
		this.left = n.left;
		this.right = n.right;
	}

	public int getValue() {
		return this.val;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setLeft(int v) {
		this.left = new Node(v);
	}

	public void setRight(int v) {
		this.right = new Node(v);
	}

	public void setLeft(Node n) {
		this.left = n;
	}

	public void setRight(Node n) {
		this.right = n;
	}
}
