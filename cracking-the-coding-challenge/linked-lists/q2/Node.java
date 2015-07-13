public class Node {
	int val;
	Node next;

	public Node() {
		this.val = 0;
		this.next = null;
	}

	public Node(int v) {
		this.val = v;
		this.next = null;
	}

	public Node(Node n) {
		this.val = n.val;
		this.next = n.next;
	}
}