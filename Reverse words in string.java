import java.util.*;

class Program {

  public String reverseWordsInString(String string) {
		if(string.length() < 2){
			return string;
		}
		//System.out.println(string);
		StringBuilder sb = new StringBuilder();
		int n = string.length();
		char[] reversed = reverse(string.toCharArray(), 0, n-1);
		// reverse all words from this reversed string
		int start = 0;
		for(int i=0; i < n; i++){
			char c = reversed[i];
			
			if(c == ' '){
				String mirrored = String.valueOf(reverse(reversed, start, i-1));
				sb.append(mirrored.substring(start, i));
				sb.append(' ');
				start=i+1;
			}
		}
		
		if( reversed[n-1] != ' '){
			String mirrored = String.valueOf(reverse(reversed, start, n-1));
			sb.append(mirrored.substring(start, n));
			sb.append(' ');
		}
		//System.out.println(sb);
    return sb.toString();
  }
	
	private char[] reverse(char[] str, int start, int end){
		while(start < end){
			// swap start with end
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++; 
			end--;
		}
		return str;
	}
}
