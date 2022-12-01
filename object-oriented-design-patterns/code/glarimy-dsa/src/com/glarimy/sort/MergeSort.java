package com.glarimy.sort;

public class MergeSort {
	public static void main(String[] args) {
		int data[] = { 1, 5, 2, 18, 3, 3, 9, 7, 2 };
		sort(data, 0, data.length);
	}

	public static void sort(int array[], int li, int ri) {
		if (li < ri) {
			int mi = li + (ri - 1) / 2;
			sort(array, 0, mi);
			sort(array, mi + 1, array.length);
			merge(array, li, mi, ri);
		}
	}

	public static void merge(int array[], int li, int mi, int ri) {
		int left[] = new int[mi-li+1];
		int right[] = new int[ri-mi];
		
		for(int i=0; i<left.length; i++) {
			left[i++] = array[li + i];
		}
		
		for(int i=mi; i<right.length; i++) {
			left[i++] = array[i];
		}
		
		int merged[] = new int[0];
		int k = 0;
		for (int i = 0, j = 0; i < left.length & j < right.length; i++, j++) {
			if (left[i] < right[i]) {
				merged[k] = left[i];
				i++;
			} else {
				merged[k] = right[j];
				j++;
			}
			k++;
		}
		print(merged);
	}

	public static void print(int[] array) {
		for (int e : array)
			System.out.print(e + " ");
		System.out.println();
	}

	public static void print(int[] left, int[] right) {
		for (int l : left)
			System.out.print(l + " ");
		System.out.print(" : ");
		for (int r : right)
			System.out.print(r + " ");
		System.out.println();
	}
}
