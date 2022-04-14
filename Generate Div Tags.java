import java.util.*;

class Program {
	static ArrayList<String> result;
  public ArrayList<String> generateDivTags(int numberOfTags) {
    result = new ArrayList();
		solve(0, 0, numberOfTags, new StringBuilder());
    return result;
  }
	
	private static void solve(int open, int close, int n, StringBuilder sb){
        if(sb.length() == n * 11){
            result.add(sb.toString());
            return;
        }
        
        if(open < n){
            open++;
            sb.append("<div>");
            solve(open, close, n, sb);
            open--;
            sb.delete(sb.length()-5 ,sb.length());
        }
        
        if(close < n && close < open){
            close++;
            sb.append("</div>");
            solve(open, close, n, sb);
            close--;
            sb.delete(sb.length()-6 ,sb.length());
        }
    }
}

