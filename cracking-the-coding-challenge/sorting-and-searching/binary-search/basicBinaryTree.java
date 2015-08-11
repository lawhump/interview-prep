import java.io.*;
import java.util.*;

public class basicBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);

		bt.insert(3);
		bt.insert(5);
		bt.insert(7);

		bt.levelOrderTraversal();

		Node byebye = bt.find(5);
		bt.remove(byebye);

		bt.insert(9);
		bt.insert(11);

		bt.levelOrderTraversal();

		Node test = bt.find(3);
		System.out.println("test.value = " + test.getValue());
		bt.find(11);
		bt.find(17);
	}

}