import java.util.*;

class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
		for(int i =0; i < array.length; i++){
			for(int j =0; j < array.length-1-i; j++){
				// compare and swap 
				if(array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1]= array[j];
					array[j] = temp;
				}
			}
		}
    return array;
  }
}
