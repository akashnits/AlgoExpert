import java.util.*;

class Program {

  public int numberOfWaysToTraverseGraph(int width, int height) {
    // Write your code here.
		int m = height;
		int n = width;
		
		int[][] dp = new int[m][n];
		// initialize dp array
		for(int i = 0; i < m; i++){
			dp[i][0] = 1;
		}
		for(int i = 0; i < n; i++){
			dp[0][i] = 1;
		}
		for(int i = 1; i < m ; i++){
			for(int j= 1; j < n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
    return dp[m-1][n-1];
  }
}
