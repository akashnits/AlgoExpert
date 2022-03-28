import java.util.*;

class Program {
	static int[] dp; // contains max subarray sum till i
	static int max;
  public static int kadanesAlgorithm(int[] array) {
		dp = new int[array.length+1];
		dp[0] = array[0];
		max = dp[0];
		int n = array.length;
		
    for(int i = 1; i < n ; i++){
			dp[i] = Math.max( array[i], dp[i-1] + array[i] );
			max = Math.max(dp[i], max);
		}
    return max;
  }
}
