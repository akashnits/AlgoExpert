import java.util.*;

class Program {
  public static int[] subarraySort(int[] array) {
		int lastSortedArrayValue = array[0];
		int n = array.length;
		int min = Integer.MAX_VALUE;
		int max = array[0];
		int lastOutOfOrderIndex = -1;
		for(int i=1; i < n; i++){
			if(array[i] < lastSortedArrayValue){
				// out of order element found
				min = Math.min(min, array[i]);
				max = Math.max(max, array[i-1]);
			}else{
				lastSortedArrayValue = array[i];
			}
		}
		int lo= -1;
		int hi= -1;
		//find correct index for min
		for(int j=0; j < n; j++){
			if(array[j] > min){
				lo=j;
				break;
			}
		}
		// find correct index for 
		for(int k=n-1; k >= 0; k--){
			if(array[k] < max){
				hi = k;
				break;
			}
		}
    return new int[] {lo, hi};
  }
}
