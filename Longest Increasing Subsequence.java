import java.util.*;

class Program {
  public static List<Integer> longestIncreasingSubsequence(int[] array) {
		
		int n = array.length;
		int[] dp = new int[n];
		int[] indices = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(indices, -1);
		for(int i=0; i <n; i++){
			for(int j=0; j < i; j++){
				if((array[i] > array[j]) && ((dp[j] +1) > dp[i])){
					dp[i] = dp[j] +1;
					// we include this index 
					indices[i] = j; 
				}
			}
		}
		
		//we have now -  dp array which stores length
		// indices array which store the index of the prev element in the sequence
		
		
		// let's find maxLengthIndex 
		int maxLengthIndex = -1;
		int maxLength = Integer.MIN_VALUE;
		for(int i=0; i < n; i++){
			if(dp[i] > maxLength){
				maxLength = dp[i];
				maxLengthIndex = i;
			}
		}
		List<Integer> result = new ArrayList();		
	
		int k =  maxLengthIndex;
		while(  k != -1){
			result.add(0,array[k]);
			k = indices[k];
		}
		
    return result;
  }
}
