import java.util.*;

class Program {
  public static int[] quickSort(int[] array) {
		quickSortHelper(array, 0, array.length-1);
    return array;
  }
	
	private static void quickSortHelper(int[] array, int start, int end){
		if(start > end){
			return;
		}
		
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left <= right){
			if(array[left] > array[pivot] && array[right] < array[pivot]){
				swap(array, left, right);
				left++;
				right--;
			}
			
			if(array[left] <= array[pivot]){
				left++;
			}
			
			if(array[right] >= array[pivot]){
				right--;
			}
		}
		
		// swap pivot with right
		swap(array, right, pivot);
		
		quickSortHelper(array, start, right-1);
		quickSortHelper(array, right+1, end);
	}
	
	private static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i]= array[j];
		array[j] = temp;
	}
}
