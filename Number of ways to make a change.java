import java.util.*;

class Program {
	
	static int[][] dp ;
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		dp = new int[n+1][denoms.length+1];
		
		for(int[] row: dp){
			Arrays.fill(row, -1);
		}
		
    return solve(denoms, n, denoms.length, dp);
  }
	
	private static int solve(int[] denoms, int sum, int n, int[][] dp){
		if(sum == 0){
			return 1;
		}
		
		if(n == 0){
			return 0;
		}
		
		if(dp[sum][n] != -1){
			return dp[sum][n];
		}
		
		if(denoms[n-1] <= sum){
			dp[sum][n] =  solve( denoms, sum - denoms[n-1], n, dp) + solve(denoms, sum, n-1, dp);
		}else{
			dp[sum][n] =  solve( denoms, sum, n-1, dp);
		}
		return dp[sum][n];
	}
}
