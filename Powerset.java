import java.util.*;

class Program {
	static List<List<Integer>> result;
  public static List<List<Integer>> powerset(List<Integer> array) {
		result = new ArrayList();
		solve(array, new ArrayList(), 0);
    return result;
  }
	
	private static void solve(List<Integer> input, List<Integer> output, int i){
		if( i == input.size()){
			result.add(output);
			return;
		}
		
		int val = input.get(i);
		// we have two choice: 1. we include this in o/p or not
		List<Integer> op1 = new ArrayList(output);
		solve(input, op1, i+1);
		List<Integer> op2 = new ArrayList(output);
		op2.add(val);
		solve(input, op2, i+1);
	}
}
