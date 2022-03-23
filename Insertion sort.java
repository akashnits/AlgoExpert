import java.util.*;

class Program {
  public static int[] insertionSort(int[] array) {
    // Write your code here.
		int j;
		int n = array.length;
		for(int i =1; i < n; i++){
			j =i;
			while(j > 0){
				if(array[j-1] > array[j]){
					// swap
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}else{
					break;
				}
				j--;
			}
		}
    return array;
  }
}
