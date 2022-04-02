import java.util.*;

class Program {
	static List<List<Integer>> result;
  public static List<List<Integer>> getPermutations(List<Integer> array) {
		result = new ArrayList();
		if(array.size() == 0){
			return result;
		}
		permute(array, new ArrayList());
    return result;
  }
	
	
	private static void permute(List<Integer> input, List<Integer> output){
		// base condition
		if( output.size() == input.size()){
			result.add(new ArrayList(output));
			return;
		}
		
		for(int i =0; i < input.size(); i++){
			int val = input.get(i);
			if(output.contains(val)) continue;
			output.add(val);
			permute(input, output);
			output.remove(output.size()-1);
		}
	}
}
