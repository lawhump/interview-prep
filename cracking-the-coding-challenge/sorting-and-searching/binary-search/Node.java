public class Node {
	private int val;
	private int numOccurences;
	private Node left;
	private Node right;
	private Node parent;

	// TODO remove constructor? doesn't do anything helpful for me
	public Node() {
		this.val = 0;
		this.numOccurences = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public Node(int v) {
		this.val = v;
		this.numOccurences = 1;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public Node(Node n) {
		this.val = n.val;
		this.numOccurences = n.numOccurences;
		this.left = n.left;
		this.right = n.right;
		this.parent = n.parent;
	}

	public int getValue() {
		return this.val;
	}

	public void setValue(int v) {
		this.val = v;
	}

	public int getNumOccurences() {
		return this.numOccurences;
	}

	public void setNumOccurences(int occs) {
		this.numOccurences = occs;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setLeft(int v) {
		this.left = new Node(v);
		this.left.parent = this;
	}

	public void setRight(int v) {
		this.right = new Node(v);
		this.right.parent = this;
	}

	public void setLeft(Node n) {
		this.left = n;
		n.parent = this;
	}

	public void setRight(Node n) {
		this.right = n;
		n.parent = this;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node n) {
		this.parent = n;
	}

	public void incrementOccurences() {
		this.numOccurences+=1;
	}

	public void decrementOccurences() {
		this.numOccurences-=1;
	}
}
