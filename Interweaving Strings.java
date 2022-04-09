import java.util.*;

class Program {
  public static boolean interweavingStrings(String one, String two, String three) {
    if(one.length() + two.length() != three.length()){
            return false;
        }
    Boolean[][] dp = new Boolean[one.length()+1][two.length()+1];
       
    return solve(one, two, three, 0, 0, dp);
  }
	
	private static boolean solve(String s1, String s2, String s3, int i, int j, Boolean[][] dp){
        // base condition
        if(i+j == s3.length()){
            dp[i][j] = true;
            return dp[i][j];
        }
        
        char find = s3.charAt(i+j);
      
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        // choice diagram
        
        dp[i][j] = 
    (i < s1.length() && find == s1.charAt(i) && solve(s1, s2, s3, i+1, j, dp)) || 
    (j < s2.length() && find == s2.charAt(j) && solve(s1, s2, s3, i, j+1, dp));
        
        
        return dp[i][j];
    }
}
