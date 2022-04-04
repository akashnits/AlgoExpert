import java.util.*;

class Program {
	static int maxLength = 0;
	static int lo =0;
		
  public static String longestPalindromicSubstring(String str) {
		if(str.length() < 2){
			return str;
		}
		char[] word = str.toCharArray();
		int n = str.length();
		
		for(int k =0; k < n-1; k++){
			extendPalindrome(word, k, k);
			extendPalindrome(word, k, k+1);
		}
    return str.substring(lo, lo+maxLength);
  }
	
	private static void extendPalindrome(char[] word, int start, int end){
		while(start >= 0 && end < word.length && word[start] == word[end]){
			start--;
			end++;
		}
		
		int len = end - start -1;
		if(len > maxLength){
			maxLength = len;
			lo = start+1;
		}
	}
}
