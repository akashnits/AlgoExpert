import java.util.*;

class Program {
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		
		// populate dp array
    dp = LCS(str1.toCharArray(), str2.toCharArray(), m, n, dp);
		int row=m, col =n;
		List<Character> result = new ArrayList();
		while(row > 0 && col > 0){
			if(str1.charAt(row-1) == str2.charAt(col-1)){
				// we have included a char
				result.add(0, str1.charAt(row-1));
				row--;
				col--;
			}else{
				if(dp[row][col] == dp[row-1][col]){
					row--;
				}else if(dp[row][col] == dp[row][col-1]){
					col--;
				}
			}
		}
		return result;
  }
	
	
	private static int[][] LCS(char[] str1, char[] str2, int m, int n, int[][] dp){
		for(int i=1; i <= m; i++){
			for(int j =1; j <=n ; j++){
				if(str1[i-1] == str2[j-1]){
					// we must include this
					dp[i][j] =  1+ dp[i-1][j-1];
				}else{
					dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp;
	}
}
