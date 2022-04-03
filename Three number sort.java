import java.util.*;

class Program {
  public int[] threeNumberSort(int[] array, int[] order) {
		int i=0;
		int j= array.length-1;
		int firstIndex = 0; 
		int lastIndex = array.length-1; 
		
		while(  i < array.length ){
			if(order[0] == array[i]){
				// swap firstIndex and i
				int temp = array[firstIndex];
				array[firstIndex] = array[i];
				array[i] = temp;
				firstIndex++;
			}
			i++; 
		}
		while( j >= 0){
			if( order[2] == array[j] ){
				// swap lastIndex and j
				int temp = array[lastIndex];
				array[lastIndex] = array[j];
				array[j] = temp;
				lastIndex--;
			}
			j--;
		}
    return array;
  }
}
