import java.util.*;

class Program {
  public int[] arrayOfProducts(int[] array) {
		int n = array.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int product = 1;
		
		for(int i=0; i < n ; i++){
			product = product * array[i];
			left[i] = product;
		}
		
		product=1;
		for(int j= n-1; j >= 0 ; j--){
			product = product * array[j];
			right[j] = product;
		}
		
		for(int k =0; k < n; k++ ){
			array[k] = (k == 0 ? 1 : left[k-1]) * (k == n-1 ? 1 : right[k+1]);
		}
    return array;
  }
}
