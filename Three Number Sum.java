import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		List<Integer[]> result = new ArrayList<Integer[]>();
		int n = array.length;
		Arrays.sort(array);
		for(int i =0;  i < n-2; i++){
			int toFind = targetSum - array[i];
			int start = i+1;
			int end = n-1;
			while(start < end){
				int sum = array[start] + array[end];
				if(sum == toFind){
					// triplet found
					result.add(new Integer[]{array[i], array[start], array[end]});
					start++;
				}else if( sum > toFind){
					end--;
				}else{
					start++;
				}
			}
		}
		
    return result;
  }
}
