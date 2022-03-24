import java.util.*;

class Program {

  public int firstNonRepeatingCharacter(String string) {
    // Write your code here.
		
		int[] freqArray = new int[26];
		int n = string.length();
		int i =0;
		while(i < n){
			char c = string.charAt(i);
			int index = (int) c - 97;
			freqArray[index] += 1;
			i++;
		}
		char c = ' ';
		for(int j=0; j< n; j++){
			char ch = string.charAt(j);
			int index = (int) ch - 97;
			if(freqArray[index] == 1){
				  c =  ch;
				break;
			}
		}
		
		if(c == ' '){
			return -1;
		}
		
		for(int k=0 ; k < n; k++){
			if(string.charAt(k) == c){
				return k;
			}
		}
		
		return -1;
  }
}
