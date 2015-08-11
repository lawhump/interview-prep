import java.io.*;
import java.util.*;

public class quicksort {

	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void qsort(int[] arr) {
		qsort(arr, 0, arr.length-1);
	}

	public static void qsort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = partition(arr, lo, hi);
			qsort(arr, lo, mid-1);
			qsort(arr, mid+1, hi);
		}
	}

	public static int partition(int[] arr, int lo, int hi) {
		int pivotVal = arr[lo];
		int pivotIdx = lo;
		for (int i=lo+1; i<=hi; i++) {
			if(arr[i] < pivotVal) {
				pivotIdx++;
				swap(arr, i, pivotIdx);
			}
		}
		swap(arr, lo, pivotIdx);
		return pivotIdx;
	}

	public static void main(String[] args) {
		int[] array = {2,6,9,3,1,2,12,10,11,42,666,6,609};

		System.out.println("Before qsort:");
		for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}

		qsort(array);

		System.out.print("After qsort:");
		for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}
	}

}