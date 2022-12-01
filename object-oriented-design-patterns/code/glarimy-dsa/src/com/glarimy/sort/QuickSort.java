package com.glarimy.sort;

public class QuickSort {
	public static void main(String[] args) {
		int data[] = { 1, 27, 13, 4, 15, 6 };
		sort(data, 0, 5);
	}

	public static void sort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = partition(array, low, high);
			sort(array, low, pivot - 1);
			sort(array, pivot + 1, high);
		}
		print(array);
	}

	public static void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return (i + 1);
	}
	
	public static void print(int[] data) {
		for(int e: data)
			System.out.print(e + " ");
		System.out.println();
	}

}
