import java.util.*;

class Program {
	static ArrayList<String> result;
	static Map<Integer, String> map;
	static int n;
  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    // Write your code here.
		result = new ArrayList();
		// build map of digit to aplhabhets
	  map = new HashMap();
		n= phoneNumber.length();
		String[] combination = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		for(int i = 2; i < 10; i++){
			map.put(i, combination[i-2]);
		}
		solve(phoneNumber, "");
    return result;
  }
	

		private static void solve(String phoneNumber, String output){
		if(output.length() == n){
				result.add(output);
				return;
	  	}
			
		if(phoneNumber.length() == 0){
			return;
		}	

		char c = phoneNumber.charAt(0);
			if( c == '0' || c == '1' ){
				output = output.concat(Character.toString(c));
				solve(phoneNumber.substring(1, phoneNumber.length()), output);
		}else{
			int key = Character.getNumericValue(c);	
			char[] letterCombination = map.get(key).toCharArray();
			// iterate over choices we have
			for(char letter : letterCombination){
				output = output.concat(Character.toString(letter));
				solve(phoneNumber.substring(1, phoneNumber.length()), output);
				output = output.substring(0, output.length()-1);
			}
		}
	}
}
