import java.util.*;

class Program {
  public String runLengthEncoding(String string) {
    // Write your code here.
		StringBuilder sb = new StringBuilder();
		int n = string.length();
		int i=0;
		while( i < n ){
			char c = string.charAt(i);
			int count = 1;
			int j = i+1;
			while(j < n){
				if(c == string.charAt(j)){
					++count;
					++j;
				}else{
					break;
				}
			}
			i=j;
			String res = "";
			if(count < 10){
				 res = count + Character.toString(c);
			}else{
				int numberNines = count / 9;
				int rem = count % 9;
				String s = 9 + Character.toString(c);
				for(int k =0; k< numberNines; k++){
					res = res + s;
				}
				res = res + rem + Character.toString(c);
			}
			sb.append(res);
		}
    return sb.toString();
  }
}
