import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
		int n = array.length;
		for(int i=0; i < n; i++){
			for(int j = i+1; j < n ; j++){
				// compare and swap
				if(array[j] < array[i]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
    return array;
  }
}
