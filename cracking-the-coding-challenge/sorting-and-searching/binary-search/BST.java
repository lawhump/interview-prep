import java.util.*;

// TODO Make AVL Tree extend BST
public class BST extends BinaryTree{
	public BST() {
		super();
	}

	public BST(int v) {
		super(v);
	}

	/**
	 * Verrrry basic implementation, optimized
	 * for reability. Will likely implement an 
	 * AVL tree at some point soon. Balancing is 
	 * important, you know? O(n) worst case on
	 * a tree is not cool, you know?
	 */
	public void insert(int v) {
		insert(head, v);
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

	/**
	 * TODO implement
	 *
	 * Function to determine of the tree is balanced.
	 * @param   tol maximum heights two subtrees can differ
	 * @return  if the max difference of any subtree height
	 * 			is within tol
	 */
	public boolean isBalanced(int tol) {
		return true;
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

	public void remove(int v) {
		System.out.println("Attempting to remove node with value: " + v);

		remove(head, v);
	}

	private void remove(Node curr, int v) {
		if (curr==null) {
			System.out.println("Value " + v + " not found.");
		}

		if (curr.getValue() > v) {
			remove(curr.getLeft(), v);
		}

		else if(curr.getValue() < v) {
			remove(curr.getRight(), v);
		}

		else {
			System.out.println("Removed value " + v);
			// no children
			if (curr.getLeft() == null && curr.getRight() == null) {
				curr = null;
			}

			// only left child
			else if (curr.getLeft() != null && curr.getRight() == null) {
				(curr.getLeft()).setParent(curr.getParent());
				(curr.getParent()).setLeft(curr.getLeft());
			}

			// only right child
			else if (curr.getLeft() == null && curr.getRight() != null) {
				(curr.getRight()).setParent(curr.getParent());
				(curr.getParent()).setRight(curr.getRight());
			}

			// two children ugh
			else {
				swapAndTrim(curr);
			}
		}
	}

	private void swapAndTrim(Node curr) {
		Node tempNode = curr;
		// go as far left as i can
		while (tempNode.getLeft() != null) {
			tempNode = tempNode.getLeft();
		}

		int tempVal = tempNode.getValue();
		tempNode.setValue(curr.getValue());
		curr.setValue(tempVal);

		curr.setNumOccurences(tempNode.getNumOccurences());

		// ok, the values are "swapped". now let's trim

		tempNode = null;
	}

	/**
	 * Yeah yeah yeah, I didn't know what to name it.
	 *
	 * arr[i] are the elements at the ith level of the tree
	 * i think i'm going to rewrite the Node class to store
	 * height. it's the lazy way out, i know
	 */	

	/*
	public ArrayList<LinkedList> questionFour() {
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
	*/
}