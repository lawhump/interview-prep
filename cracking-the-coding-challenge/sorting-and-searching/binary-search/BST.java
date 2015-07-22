import java.util.*;

public class BST {
	private Node head;

	private class Queue {
		List<Node> queue = new LinkedList<Node>();
	}

	public BST() {
		this.head = null;
	}

	public BST(int v) {
		this.head = new Node(v);
	}

	/**
	 * Verrrry basic implementation, optimized
	 * for reability. Will likely implement an 
	 * AVL tree at some point soon. Balancing is 
	 * important, you know? O(n) worst case on
	 * a tree is not cool, you know?
	 */
	public void insert(int v) {
		Node root = head;
		if (root.getValue() > v) {
			if(root.getLeft() == null){
				root.setLeft(v);
			}

			else {
				insert(root.left, v);
			}
		}

		else {
			if(root.getRight() == null){
				root.setRight(v);
			}

			else {
				insert(root.right, v);	
			}
		}
	}

	private void insert(Node subRoot, int v) {
		if (subRoot.getValue() > v) {
			if(subRoot.getLeft() == null){
				subRoot.setLeft(v);
			}

			else {
				insert(subRoot.left, v);
			}
		}

		else {
			if(subRoot.getRight() == null){
				subRoot.setRight(v);
			}

			else {
				insert(subRoot.right, v);	
			}
		}
	}

	public void remove(Node n) {

	}

	public find(int v) {

	}

	// public AVLTree toAVLTree { }

	// lol
	public Node getHead() {
		return head;
	}

	/**
	 *
	 * BFS to print tree by level. Using for 
	 * testing and debugging purposed.
	 *
	 * Cool because I already implemented BFS
	 * and DFS in python, but that was with 
	 * adjacency lists, and not explicit nodes
	 * and pointers.
	 *
	 */
	public void printByLevel(){
		List<Node> queue = new LinkedList<Node>();
		queue.add(head);

		while(queue.size > 0) {
			// check left
		}
	}
}