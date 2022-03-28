import java.util.*;

class Program {
  public static boolean hasSingleCycle(int[] array) {
		int n = array.length;
		int currIndex =0;
		int count = 0;
		while(count < n){
			if(count > 0 && currIndex == 0) return false;
			 currIndex = getIndex(array[currIndex], currIndex, n);
			count++;
		}
    return currIndex == 0;
  }
	
	
	private static int getIndex(int value, int index, int n){
		int normalize = value % n;
		int newIndex = index + normalize;
		
		if(newIndex < 0){
			return n + newIndex;
		}else if(newIndex > n-1){
			return newIndex - n;
		}else{
			return newIndex;
		}
	}
}
