public class LinkedList {
	Node head;

	public LinkedList() {
		this.head = null;
	}

	public LinkedList(int v) {
		this.head = new Node(v);
	}

	public void append(int v) {
		Node tmp = this.head;

		while(tmp.next != null) {
			tmp = tmp.next;
		}

		tmp.next = new Node(v);
	}

	// This is hard without creating a new object.
	// I could create some object that contains both 
	// the node and the current level from the end.
	// 
	// The current challenge is keeping track of level
	// from the end, and simultaneously returning the 
	// node. I'll try again when I'm feeling more 
	// creative.

	public Node findKthToLast(int k) {
		/*
		Node kth = findKthToLastHelper(this.head, k);
		return kth;
		*/
		return new Node(k);
	}
}