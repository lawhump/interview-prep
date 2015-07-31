import java.io.*;
import java.util.*;

public class basicBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);

		bt.insert(3);
		bt.insert(5);
		bt.insert(7);

		bt.levelOrderTraversal();

		bt.insert(9);
		bt.insert(11);

		bt.levelOrderTraversal();

		bt.find(3);
		bt.find(11);
		bt.find(17);
	}

}