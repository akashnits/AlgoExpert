import java.util.*;

class Program {
  public static int shiftedBinarySearch(int[] array, int target) {
    // Write your code here.
    return binarySearch(array, target, 0, array.length-1, -1);
  }
	
	private static int binarySearch(int[] arr, int target, int l, int r, int index){
		if(l > r){
			return index;
		}
		
		int mid = l + (r-l)/2;
		
		if(target == arr[mid]){
			return mid;
		}
		// check if left subarray is sorted and target lies in there
		if(arr[l] <= arr[mid]){ // left subarray is sorted
			if(target >= arr[l] && target < arr[mid]){ // target lies in left subarray
				return binarySearch(arr, target, l, mid-1, index);
			}else{
				return binarySearch(arr, target, mid+1, r, index);
			}
		}else{
			// right subarray is sorted
			if(target <= arr[r] && target > arr[mid]){ // target lies in right subarray
				return binarySearch(arr, target, mid+1, r, index);
			}else{
				return binarySearch(arr, target, l, mid-1, index);
			}
		}
	}
}

