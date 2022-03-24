import java.util.*;

class Program {
	
  public static int[] findThreeLargestNumbers(int[] array) {
		int min = Integer.MIN_VALUE;
		int l1 = min+2;
		int l2= min+1;
		int l3= min;
		for(int i =0 ; i < array.length; i++){
			if(array[i] >= l1){
				l3 = l2; l2 = l1; l1 = array[i];
			}else if(array[i] >= l2){
				l3 = l2; l2 = array[i];
			}else if(array[i] >= l3){
				l3 = array[i];
			}
		}
		
    return new int[]{l3, l2, l1};
  }
}
