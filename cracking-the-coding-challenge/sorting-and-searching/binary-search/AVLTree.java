import java.util.*;

public class AVLTree extends BST {
	public AVLTree() {
		super();

	}

	public AVLTree(int v) {
		this.head = new AVLNode(v);
	}

	public void insert(int v) {
		AVLNode root = head;
		if (root!=null) {
			insert(root, v);
		}
	}

	private void insert(AVLNode subRoot, int v) {
		if (subRoot == null) {
			return AVLNode(v);
		}

		if (subRoot.getValue() > v) {
			subRoot.left = insert(subRoot.getLeft(), v);
		}

		else {
			subRoot.right = insert(subRoot.getRight(), v);
		}

		subRoot.balanceFactor = computeBF(subRoot);
	}	
}