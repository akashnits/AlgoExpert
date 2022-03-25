import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
    // Write your code here.
		int n = array.length;
		boolean isMonotonic = true;
		
		String type = "same";
		
		for(int i=0; i< n-1; i++){
			int diff = array[i+1] - array[i];
			if(diff == 0){
				// move ahead
				continue;
			}else if( diff > 0){
				// increasing here - return false if it was decreasing earlier
				if(type.equals("decrease")){
					return false;
				}else{
					// set increasing
					type = "increase";
				}
			}else{
				// decreasing here - return false if it was increasing earlier
				if(type.equals("increase")){
					return false;
				}else{
					// set increasing
					type = "decrease";
				}
			}
		}
    return isMonotonic;
  }
}
