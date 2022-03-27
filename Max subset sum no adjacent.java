import java.util.*;

class Program {
	static int[] dp;
  public static int maxSubsetSumNoAdjacent(int[] array) {
		if(array.length == 0){
			return 0;
		}
		if(array.length == 1){
			return array[0];
		}
		int n = array.length;
		dp = new int[n+1];
		dp[0] = array[0];
		dp[1] = Math.max(array[0], array[1]);
		for(int i= 2; i < n; i++){
			dp[i] = Math.max(dp[i-2] + array[i], dp[i-1]);
		}
    return dp[n-1];
  }
}
