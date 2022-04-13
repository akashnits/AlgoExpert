import java.util.*;

class Program {
	static int minIndex;
  public int indexEqualsValue(int[] array) {
		minIndex = array.length;
    return binarySearch(array, 0, array.length-1);
  }
	
	
	private static int binarySearch(int[] arr, int l, int r){
		if(l > r){
			return -1;
		}
		
		int mid = l + (r-l)/2;
		
		binarySearch(arr, l, mid-1);
		if(mid == arr[mid]){
			minIndex =  Math.min(minIndex, mid);
			return minIndex;
		}
		return minIndex != arr.length ? minIndex : binarySearch(arr, mid+1, r);
	}
}

