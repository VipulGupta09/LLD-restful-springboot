package com.interview;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {38, 27, 43, 3, 9, 82, 10};
	int count=	sort(arr, 0, arr.length - 1);
	System.out.println(count);

		for (int i : arr)
			System.out.print(i + " ");

	}

	public static int sort(int arr[], int left, int right) {
		int count = 0;
		if (left < right) {
			int mid = left + (right - left) / 2;

			count += sort(arr, left, mid);
			count += sort(arr, mid + 1, right);
			count += merge(arr, left, mid, right);

		}
		return count;
	}

	public static int merge(int[] arr, int left, int mid, int right) {
		int inversion = 0;
		int size1 = mid - left + 1;
		int size2 = right - mid;

		int leftArr[] = new int[size1];
		int rightArr[] = new int[size2];

		for (int i = 0; i < size1; i++)
			leftArr[i] = arr[i + left];

		for (int j = 0; j < size2; j++)
			rightArr[j] = arr[j + 1 + mid];

		int k = left;
		int i = 0, j = 0;
		while (i < size1 && j < size2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
				inversion += (mid + 1) - (left + i);
			}
			k++;
		}
		while (i < size1) {
			arr[k] = leftArr[i];
			k++;
			i++;
		}
		while (j < size2) {
			arr[k] = rightArr[j];
			k++;
			j++;
		}
		return inversion;
	}
}
