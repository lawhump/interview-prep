import java.io.*;
import java.util.*;

public class basicBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);

		bt.insert(3);
		bt.insert(5);
		bt.insert(7);
		bt.insert(77);
		bt.insert(24);
		bt.insert(5);
		bt.insert(5);

		bt.levelOrderTraversal();

		bt.insert(9);
		bt.insert(11);

		bt.find(11);
		bt.find(17);

		bt.remove(5);
		bt.remove(11);
		bt.remove(77);
		
		bt.levelOrderTraversal();
	}

}