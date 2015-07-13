import java.io.*;
import java.util.*;

class q2 {


	public static void main(String[] args) {
		LinkedList ll = new LinkedList(0);

		for(int i=1; i<7; i++) {
			ll.append(i);
		}

		Node tmp = ll.head;
		for(int i=0; i<7; i++) {
			System.out.print(tmp.val);
			tmp = tmp.next;
		}

		Node test1 = ll.findKthToLast(2);
	}

}