import java.util.*;

class Program {
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		int n = array.length;
		int maxSum = Integer.MIN_VALUE;
		int maxSumIndex = -1;
		// dp[i] represents maxSum of LIS at i
		int[] dp = new int[n];
		for(int i =0; i <n; i++){
			dp[i] = array[i];
		}
		int[] indices = new int[n];
		Arrays.fill(indices, -1); // -1 represents invalid index
		
		for(int i=0; i < n; i++){
			for(int j=0; j < i; j++){
				if(array[i] > array[j]){
					// we have increasing subsequence here
					int sum = dp[j] + array[i];
					if(sum > dp[i]){
						dp[i] = sum;
						indices[i] = j;
					}
				}
			}
			// maximise dp[i] value is maxSum
			if(dp[i] > maxSum){
					maxSum = dp[i];
					maxSumIndex = i;
				}
		}
		
		final int value = maxSum;
		
		List<Integer> result = new ArrayList();
		// we have dp array and indices array
		int k = maxSumIndex;
		while(k != -1){
			result.add(0, array[k]);
			k = indices[k];
		}
		
    return new ArrayList<List<Integer>>() {
      {
        add(List.of(value)); // Example max sum
        add(result); // Example max sequence
      }
    };
  }
}
