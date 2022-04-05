import java.util.*;

class Program {
  public static int[] largestRange(int[] array) {
		// create a hashmap with key as array element and values as boolean
		// visited/unvisited
		int n = array.length;
		int[] result = new int[2];
		int maxLength =0;
		Map<Integer, Boolean> map = new HashMap();
		for(int element: array){
			map.put(element, false);
		}
		
		for(int i=0; i < n ; i++){
			int val = array[i];
			// we try expanding on this value if it's not already visited
			if(!map.get(val)){
				map.put(val, true);
				// we expand and explore
				int currLength = 1;
				int left = val-1;
				int right = val +1;
				while(map.containsKey(left)){
					map.put(left, true);
					currLength++;
					left--;
				}
				
				while(map.containsKey(right)){
					map.put(right, true);
					currLength++;
					right++;
				}
				
				if(currLength > maxLength){
					maxLength = currLength;
					result = new int[]{left+1, right-1};
				}
			}
			
		}
    return result;
  }
}
