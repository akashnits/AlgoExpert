import java.util.*;

class Program {
	
  public static int[] searchForRange(int[] array, int target) {
		int n = array.length;
		int startIndex = binarySearchStartIndex(array, target, 0, n-1, -1);
		int endIndex = binarySearchEndIndex(array, target, 0, n-1, -1);
    return new int[] {startIndex, endIndex};
  }
	
	private static int binarySearchStartIndex(int[] array, int target, int l, int r, int startIndex){
		if(l > r){
			return startIndex;
		}
		
		// try to go left
		int mid = l+ (r-l)/2;
		if(array[mid] == target){
			startIndex = mid;
			return binarySearchStartIndex(array, target, l, mid-1, startIndex);
		}
		
		if(array[mid] > target){
			// go left
			return binarySearchStartIndex(array, target, l, mid-1, startIndex);
		}else{
			// go right
			return binarySearchStartIndex(array, target, mid+1, r, startIndex);
		}
	}
	
	private static int binarySearchEndIndex(int[] array, int target, int l, int r, int endIndex){
		if(l > r){
			return endIndex;
		}
		
		// try to go right
		int mid = l+ (r-l)/2;
		if(array[mid] == target){
			endIndex = mid;
			return binarySearchEndIndex(array, target, mid+1, r, endIndex);
		}
		
		if(array[mid] > target){
			// go left
			return binarySearchEndIndex(array, target, l, mid-1, endIndex);
		}else{
			// go right
			return binarySearchEndIndex(array, target, mid+1, r, endIndex);
		}
	}
}

