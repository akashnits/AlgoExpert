import java.util.*;

class Program {
  public static int palindromePartitioningMinCuts(String s) {
    int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return minCostPartitioning(s, 0, n-1, dp);
  }
	
	private static int minCostPartitioning(String s, int i, int j, int[][] dp){
        if( i >= j){
            dp[i][j] =0;
            return 0; // no cost partitioning single letter
        }
        
        if(isPalindrome(s, i, j)){
            dp[i][j] =0;
            return 0; // no need to partition
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int result = Integer.MAX_VALUE;
        for(int k= i; k < j; k++){
            if(dp[i][k] == -1){
                dp[i][k] = minCostPartitioning(s, i, k, dp);
            }
            
            if(dp[k+1][j] == -1){
                dp[k+1][j] = minCostPartitioning(s, k+1, j, dp);
            }
            int cost = dp[i][k] + dp[k+1][j] +1;
            result = Math.min(cost, result);
            dp[i][j] = result;
        }
        return result ;
    }
    
     private static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
