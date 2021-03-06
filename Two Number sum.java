import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		int n = array.length;
		Arrays.sort(array);
		for(int i=0; i < n-1; i++){
			int findEle = targetSum-array[i];
			if(find(array, findEle, i+1, n-1)){
				// we found the numbers
				int[] result = new int[2];
				result[0] = array[i];
				result[1] = targetSum-array[i];
				return result;
			}
		}
    return new int[0]; 
  }
	
	static boolean find(int[] arr, int toFind, int l, int r){
		if(l > r){
			return false;
		}
		
		int mid = l+ (r-l)/2;
		
		if(arr[mid] == toFind){
			return true;
		}
		
		if(arr[mid] < toFind){
			//search right side
			return find(arr, toFind, mid+1, r);
		}else{
			//search left side
			return find(arr, toFind, l, mid-1);
		}
	}
}

----------------------------------------------------------------------------
	
import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		// using extra space , map of value to index
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i < array.length; i++){
			map.put(array[i] , i);
		}
		
		for(int i=0; i < array.length; i++){
			int findEle = targetSum - array[i];
			if(map.containsKey(findEle)){
				if(map.get(findEle) > i){
					result[0] = findEle;
					result[1] = array[i];
					return result;
				}
			}
		}
		
    return new int[0];
  }
}

