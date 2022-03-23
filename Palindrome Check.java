import java.util.*;

class Program {
	
  public static boolean isPalindrome(String str) {
    // Write your code here.
		
    return isPalindromeRecur(str,  0, str.length()-1);
  }
	
	private static boolean isPalindromeRecur(String str, int i, int j){
		
		// base condition
		if(i >= j){
			return true;
		}
		
		return str.charAt(i) == str.charAt(j) && isPalindromeRecur(str, i+1, j-1);
	}
}
