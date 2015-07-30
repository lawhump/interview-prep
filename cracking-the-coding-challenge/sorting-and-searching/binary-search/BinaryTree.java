import java.util.*;

public class BinaryTree extends nAryTree {

	public BinaryTree() {
		this.head = null;
	}

	public BinaryTree(int v) {
		this.head = new Node(v);
	}

	// TODO implement w/ BFS
	public void insert(int v) { }

	/**
	 * TODO test this!!!!!
	 * I dunno how to be quite clever yet. I want 
	 * to leverage the already written inOrderTraversal
	 * code. Alas, i'll copy/paste rn.
	 */
	public Node find(int v) {
		System.out.println("Looking for:" + v);
		Node result = new Node();
		if (head!=null) {
			result = find(head, v);
		}
		
		if (result == null) {
			System.out.println("Value not found");
		}
		return result;
	}

	private Node find(Node subRoot, int v) {
		if(subRoot != null){
			find(subRoot.getLeft(), v);
			if (subRoot.getValue() == v) {
				return subRoot;
			}
			find(subRoot.getRight(), v);
		}
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