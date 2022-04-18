import java.util.*;

class Program {
  public static int[] mergeSort(int[] array) {
		int n = array.length;
		return mergeSortHelper(array, 0, n-1);
  }
	
	private static int[] mergeSortHelper(int[] array, int l, int r){
		if(l >= r){
			// array of size is sorted
			int[] sorted = new int[]{array[r]};
			return sorted;
		}
		
		int mid = l + (r-l)/2;
		int[] leftSorted = mergeSortHelper(array, l, mid);
		int[] rightSorted = mergeSortHelper(array, mid+1,r );
		return merge(leftSorted, rightSorted);
	}
	
	private static int[] merge(int[] left, int[] right){
		int i=0;
		int j= 0;
		int k =0;
		int mergeSize = left.length + right.length;
		int[] merged = new int[mergeSize];
		while( i < left.length && j < right.length ){
			// compare
			if(left[i] > right[j] ){
				// take right[j]
				merged[k] = right[j];
				j++;
			}else{
				// take left[i]
				merged[k] = left[i];
				i++;
			}
			k++;
		}
		
		// take remaining elements
		while(i < left.length){
			merged[k]= left[i];
			i++;
			k++;
		}
		
		while( j < right.length ){
			merged[k] = right[j];
			j++;
			k++;
		}
		return merged;
	}
}
