import java.util.*;

class Program {
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
    return find(0, array.length-1, array, target);
  }
	
	private static int find(int l, int r, int[] array, int target){
		if(l > r){
			return -1;
		}
		
		int mid = l + (r-l)/2;
		if(array[mid] == target){
			return mid;
		}else if(target > array[mid]){
			return find(mid+1, r, array, target);
		}else{
			return find(l, mid-1, array, target);
		}
	}
}
