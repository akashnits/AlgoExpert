import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
		
		int n = array.size();
		int i =0, j= n-1;
		
		while(i < j){
			// swap and decrement j
			if(array.get(i) == toMove){
				while(i < j && array.get(j) == toMove){
					j--;
				}
				int temp = array.get(j);
				array.set(j, toMove);
				array.set(i, temp);
				j--;
			}
			i++;
		}
    return array;
  }
}
