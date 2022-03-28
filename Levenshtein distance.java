import java.util.*;

class Program {
	static int[][] dp;
  public static int levenshteinDistance(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		dp = new int[m+1][n+1];
		
		for(int[] row: dp){
			Arrays.fill(row, -1);
		}
    return minOperations(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length(), dp);
  }
	
	private static int minOperations(char[] str1, char[] str2, int m, int n, int[][] dp){
		// base condition
		if(m == 0 || n == 0){
			return m == 0? n: m; 
		}
		
		if(dp[m][n] != -1){
			return dp[m][n];
		}
		// choice diagram
		if(str1[m-1] != str2[n-1]){
			// we have three choices : delete, insert, subsitute
				// try deleting
				int delete = 1 + minOperations(str1, str2, m-1, n, dp);
				// try inserting
				int insert = 1 + minOperations(str1, str2, m, n-1, dp);
				// try subsituting
				int substitute = 1 + minOperations(str1, str2, m-1, n-1, dp);
			dp[m][n] =  Math.min(delete, Math.min(insert, substitute));
		}else{
			dp[m][n] =  minOperations(str1, str2, m-1, n-1, dp);
		}
		return dp[m][n];
	}
}
