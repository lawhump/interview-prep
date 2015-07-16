public class Node {
	int val;
	Node left;
	Node right;

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
}
