import java.util.*;

// idea is to find a peak and expand in both directions
class Program {
  public static int longestPeak(int[] array) {
		int i = 1;
		int n= array.length;
		int len = 0;
		int maxLen = 0;
		
		while( i < n-1 ){
			if(array[i] > array[i+1] && array[i] > array[i-1]){
				int j= i-1;
				int k= i+1;
				
				while(j > 0 && array[j-1] < array[j]){
					j--;
				}
				
				while(k < n-1 && array[k] > array[k+1]){
					k++;
				}
				
				len = k-j+1;
				maxLen = Math.max(len, maxLen);
				i = k;
			}
			i++;
		}
    return maxLen;
  }
}
