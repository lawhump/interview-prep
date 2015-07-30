import java.io.*;
import java.util.*;

public class binarySearch {

	public static void main(String[] args) {
		BST bst = new BST(15);

		bst.insert(7);
		bst.insert(1);
		bst.insert(3);
		bst.insert(17);
		bst.insert(27);
		bst.insert(14);
		bst.insert(10);
		bst.insert(77);
		bst.insert(42);

		bst.preOrderTraversal();
		bst.inOrderTraversal();
		bst.postOrderTraversal();

		bst.find(15);
		bst.find(42);
		bst.find(16);

		bst.levelOrderTraversal();
	}

}