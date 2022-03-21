import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int i=0, j=0;
		int m= array.size(), n = sequence.size();
		while(i < m && j < n){
			if(array.get(i) == sequence.get(j)){
				j++;
			}
			i++;
		}
    return j==n;
  }
}
