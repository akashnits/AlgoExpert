import java.util.*;

class Program {
	static int[][] dp;
	static int infinite;
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    dp = new int[n+1][denoms.length+1];
		infinite= n+1;
 		for(int[] row: dp){
 			Arrays.fill(row, -1);
 		}

     int result =  minCoins(denoms, n, denoms.length, dp);
		 return result > n ? -1 : result;
  }
	
	private static int minCoins(int[] denoms, int sum, int n, int[][] dp){
		
 		if(sum == 0){
 			return 0;
 		}
		
		if(n == 0){
 			return infinite;
 		}

 		if(dp[sum][n] != -1){
 			return dp[sum][n];
 		}

 		if(denoms[n-1] <= sum){
			
 			dp[sum][n] =  Math.min(1 + minCoins( denoms, sum - denoms[n-1], n, dp) , minCoins(denoms, sum, n-1, dp));
 		}else{
 			dp[sum][n] =  minCoins( denoms, sum, n-1, dp);
 		}
 		return dp[sum][n];
 	}
}
