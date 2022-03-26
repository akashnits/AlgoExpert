import java.util.*;

class Program {
// Idea is to 
// 1. use values of array as index to travserse the array
// 2. flip the value once you reach it to mark that it was reachable earlier
// 3. return when you see -ve value as it was reachable earlier which means there's exists a duplicate equals to index+1

  public int firstDuplicateValue(int[] array) {
    
		for(int value : array){
			int absValue = Math.abs(value);
			if(array[absValue -1] < 0){
				return absValue;
			}
			array[absValue-1] *= -1; 
		}
    return -1;
  }
}
