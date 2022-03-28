import java.util.*;

class Program {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> array) {
    // Write your code here.
    return helper(1, array);
  }
	
	private static int helper(int depth, List<Object> arr){
		int sum =0;
		for(Object o : arr){
			if(o instanceof ArrayList){
				ArrayList<Object> list = (ArrayList) o;
				sum += helper(depth+1, list);
			}else{
				sum += (int) o;
			}
		}
		return sum * depth;
	}
}
