package binarysearch;

public class NumberOfTimesArrayRotated {

	public static void main(String[] args) {
		//  1 2 3 4 5 6 7 8 9 10
		//  5 6 7 8 9 10 1 2 3 4
		//  8 9 10 1 2 3 4 5 6 7
		
		int arr[] = {11, 12, 15, 18, 2 , 5 , 6, 8};
		int count = find(arr);
		System.out.println(count);
	}
	
	public static int find(int [] arr) {
		int N = arr.length;
		int i=0,j=arr.length-1;
		
		
		while(i<=j) {
			int mid = i + (j-i)/2;
			if(arr[mid]<=arr[(mid+N-1)%N] && arr[mid]<=arr[(mid + 1)%N])
				return mid;
			else if(arr[mid]>=arr[0])
				i = mid+1;
			else
				j = mid-1;
		}
		return i==-1?1:1;
	}

}
