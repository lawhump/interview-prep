import java.io.*;
import java.util.*;

public class mergesort {

	public static int[] mergesort(int[] arr) {
		int leftLen = (int) Math.floor((arr.length)/2.0);
		int rightLen = (int) Math.ceil((arr.length)/2.0);
		int[] left = new int[leftLen];
		int[] right = new int[rightLen];

		System.arraycopy(arr, 0, left, 0, left.length);
		System.arraycopy(arr, left.length, right, 0, right.length);

		int[] sorted = mergesort(left, right);

		return sorted;
	}

	public static int[] mergesort(int a[], int[] b) {
		if (a.length == 1) {
			return merge(a, b);
		}

		int aLeftLen = (int) Math.floor((a.length)/2.0);
		int aRightLen = (int) Math.ceil((a.length)/2.0);
		int bLeftLen = (int) Math.floor((b.length)/2.0);
		int bRightLen = (int) Math.ceil((b.length)/2.0);

		int[] aLeft = new int[aLeftLen];
		int[] aRight = new int[aRightLen];
		int[] bLeft = new int[bLeftLen];
		int[] bRight = new int[bRightLen];

		System.arraycopy(a, 0, aLeft, 0, aLeft.length);
		System.arraycopy(a, aLeft.length, aRight, 0, aRight.length);

		System.arraycopy(b, 0, bLeft, 0, bLeft.length);
		System.arraycopy(b, bLeft.length, bRight, 0, bRight.length);

		int[] sortedLeft = mergesort(aLeft, aRight);
		int[] sortedRight = mergesort(bLeft, bRight);

		int[] sorted = merge(sortedLeft, sortedRight);

		return sorted;
	}

	public static int[] merge(int[] a, int[] b) {


		int[] merged = new int[a.length + b.length];

		int idxA = 0;
		int idxB = 0;

		while (idxA != a.length && idxB != b.length) {
			if(a[idxA] <= b[idxB]) {
				merged[idxA+idxB] = a[idxA];
				idxA++;
			}

			else {
				merged[idxA+idxB] = b[idxB];
				idxB++;
			}
		}

		if (idxA == a.length) {
			while (idxB != b.length) {
				merged[idxA+idxB] = b[idxB];
				idxB++;
			}
		}

		else {
			while (idxA != a.length) {
				merged[idxA+idxB] = a[idxA];
				idxA++;
			}
		}

		return merged;
	}

	public static void main(String[] args) {
		int[] array = {2,6,9,3,1,2,12,10,11,42,666,6,609};
		int[] sorted = new int[array.length];

		sorted = mergesort(array);

		for(int i=0; i<array.length; i++){
			System.out.println(sorted[i]);
		}

	}

}