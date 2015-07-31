import java.util.*;

public class BinaryTree extends nAryTree {

	public BinaryTree() {
		this.head = null;
	}

	public BinaryTree(int v) {
		this.head = new Node(v);
	}

	// BFS implementation of insert
	// The tree always stays minimum height
	public void insert(int v) {
		System.out.println("Inserting new node of value: " + v);
		boolean looking = true;
		List<Node> queue = new LinkedList<Node>();
		queue.add(head);

		while (queue.size() != 0 && looking) {
			Node curr = queue.remove(0);

			if(curr.getLeft() == null) {
				curr.setLeft(v);
				looking = false;
			}

			if(curr.getRight() == null && looking) {
				curr.setRight(v);
				looking = false;
			}

			queue.add(curr.getLeft());
			queue.add(curr.getRight());
		}
	}

	/**
	 * TODO test this!!!!!
	 * I dunno how to be quite clever yet. I want 
	 * to leverage the already written inOrderTraversal
	 * code. Alas, i'll copy/paste rn.
	 */
	public Node find(int v) {
		System.out.println("Looking for:" + v);

		List<Node> queue = new LinkedList<Node>();
		queue.add(head);

		while (queue.size() != 0) {
			Node curr = queue.remove(0);

			if(curr.getValue() == v) {
				System.out.println("Found value: " + v);
				return curr;
			}

			if (curr.getLeft()!=null) {
				queue.add(curr.getLeft());
			}
			if (curr.getRight()!=null) {
				queue.add(curr.getRight());
			}
		}

		System.out.println("Did not find value: " + v);
		return null;
	}

	/**
	 * BFS to print tree by level. Using for 
	 * testing and debugging purposed.
	 *
	 * Cool because I already implemented BFS
	 * and DFS in python, but that was with 
	 * adjacency lists, and not explicit nodes
	 * and pointers.
	 */
	public void levelOrderTraversal() {
		System.out.println("Beginning level order traversal.");
		List<Node> queue = new LinkedList<Node>();
		queue.add(head);

		while (queue.size() != 0) {
			Node curr = queue.remove(0);
			System.out.println(curr.getValue());

			if (curr.getLeft() != null){
				queue.add(curr.getLeft());
			}

			if(curr.getRight() != null){
				queue.add(curr.getRight());
			}
		}
	}

	/**
	 * The standard set of traversal algorithms.
	 * Trying to refamiliarize myself with 
	 * recursion, trees, and recursion on trees.
	 */
	public void preOrderTraversal(){
		System.out.println("Beginning preOrder traversal:");
		if (head!=null) {
			preOrderTraversal(head);
		}
	}
	
	private void preOrderTraversal(Node subRoot){
		if(subRoot != null){
			System.out.println(subRoot.getValue());
			preOrderTraversal(subRoot.getLeft());
			preOrderTraversal(subRoot.getRight());
		}
	}

	public void inOrderTraversal(){
		System.out.println("Beginning inOrder traversal:");
		if (head!=null) {
			inOrderTraversal(head);
		}
	}
	
	private void inOrderTraversal(Node subRoot){
		if(subRoot != null){
			inOrderTraversal(subRoot.getLeft());
			System.out.println(subRoot.getValue());
			inOrderTraversal(subRoot.getRight());
		}
	}

	public void postOrderTraversal(){
		System.out.println("Beginning postOrder traversal:");
		if (head!=null) {
			postOrderTraversal(head);
		}
	}
	
	private void postOrderTraversal(Node subRoot){
		if(subRoot != null){
			postOrderTraversal(subRoot.getLeft());
			postOrderTraversal(subRoot.getRight());
			System.out.println(subRoot.getValue());

		}
	}

}