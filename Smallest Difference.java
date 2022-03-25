import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int minDiff = Integer.MAX_VALUE;
		 
		int n = arrayOne.length;
		int m = arrayTwo.length;
		int[] result = new int[2];
		int i=0, j=0;
		while( i < n && j < m){
			int a = arrayOne[i];
			int b = arrayTwo[j];
			int diff = a-b;
			if( diff < 0 ){
				i++;
			}else{
				j++;
			}
			if(Math.abs(diff) < minDiff){
				minDiff = Math.abs(diff);
				result = new int[]{a, b};
			}
		}
    return result;
  }
}
