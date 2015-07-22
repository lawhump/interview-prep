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
				insert(root.getLeft(), v);
			}
		}

		else {
			if(root.getRight() == null){
				root.setRight(v);
			}

			else {
				insert(root.getRight(), v);	
			}
		}
	}

	private void insert(Node subRoot, int v) {
		if (subRoot.getValue() > v) {
			if(subRoot.getLeft() == null){
				subRoot.setLeft(v);
			}

			else {
				insert(subRoot.getLeft(), v);
			}
		}

		else {
			if(subRoot.getRight() == null){
				subRoot.setRight(v);
			}

			else {
				insert(subRoot.getRight(), v);	
			}
		}
	}

	public void remove(Node n) {

	}

	/**
	 * Binary search!
	 */
	public Node find(int v) {
		System.out.println("Attempting to find value: " + v);
		if (v == head.getValue()){
			System.out.println("Found value: " + v);
			return head;
		}

		if (v < head.getValue()){
			if (head.getLeft() != null){
				return find(head.getLeft(), v);
			}
		}

		else {
			if (head.getRight() != null){
				return find(head.getRight(), v);
			}
		}
		System.out.println("Value not found");
		return null;
	}

	private Node find(Node curr, int v) {
		if (v == curr.getValue()){
			System.out.println("Found value: " + v);
			return curr;
		}

		if (v < curr.getValue()){
			if (curr.getLeft() != null){
				return find(curr.getLeft(), v);
			}
		}

		else {
			if (curr.getRight() != null){
				return find(curr.getRight(), v);
			}
		}
		System.out.println("Value not found");
		return null;
	}

	/**
	 * Stretch goal: implement an AVL tree.
	 * This method serves as a good springboard.
	 */
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
	 * This is harder than anticipated. :/
	 */
	public void printByLevel(){
		// List<Node> queue = new LinkedList<Node>();
		// queue.add(head);

		// while(queue.size > 0) {
		// 	// check left
		// }
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