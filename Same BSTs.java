import java.util.*;

class Program {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		
    return isSameBST(arrayOne, arrayTwo);
  }
	
	private static boolean isSameBST(List<Integer> arrayOne, List<Integer> arrayTwo){
		
		if(arrayOne.size() == 0 && arrayTwo.size() == 0){
			return true;
		}
		
		if(arrayOne.size() != arrayTwo.size() || arrayOne.get(0) != arrayTwo.get(0)){
			return false;
		}
		
		// make arrayOne and arrayTwo smaller
		List<Integer> arrayOneLeft = getSmallerThan(arrayOne.get(0), arrayOne);
		List<Integer> arrayOneRight = getGreaterThan(arrayOne.get(0), arrayOne);
		List<Integer> arrayTwoLeft = getSmallerThan(arrayTwo.get(0), arrayTwo);
		List<Integer> arrayTwoRight = getGreaterThan(arrayTwo.get(0), arrayTwo);

		
		return isSameBST(arrayOneLeft, arrayTwoLeft) && isSameBST(arrayOneRight, arrayTwoRight);
	}
	
	private static List<Integer> getSmallerThan(int val, List<Integer> list){
		List<Integer> result = new ArrayList();
		for(int i=1; i < list.size(); i++){
			if(list.get(i) < val){
				result.add(list.get(i));
			}
		}
		return result;
	}
	
	private static List<Integer> getGreaterThan(int val, List<Integer> list){
		List<Integer> result = new ArrayList();
		for(int i=1; i < list.size(); i++){
			if(list.get(i) >= val){
				result.add(list.get(i));
			}
		}
		return result;
	}
}
