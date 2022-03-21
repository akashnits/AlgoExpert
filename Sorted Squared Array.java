import java.util.*;

class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int n = array.length;
		int[] result = new int[n];
		// find larget negative index and smallest positive index
		int lni = n-1, spi = n+1;
		for(int i=0; i < n; i++){
			if(array[i] >= 0){
				lni = i-1;
				spi = i;
				break;
			}
		}
		
		int j =0;
			while(lni > -1 || spi < n ){
				if(lni > -1 && spi < n){
					if(Math.abs(array[lni]) > Math.abs(array[spi])){
						result[j] = array[spi] * array[spi];
						spi++;
					}else{
						result[j] = array[lni] * array[lni];
						lni--;
					}
				}else if(lni > -1){
					result[j] = array[lni] * array[lni];
					lni--;
				}else if(spi < n){
					result[j] = array[spi] * array[spi];
					spi++;
				}
			j++;
		}
		
    return result;
  }
}
