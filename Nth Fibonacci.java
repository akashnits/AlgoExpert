import java.util.*;

class Program {
  public static int getNthFib(int n) {
    // Write your code here.
		// base condition
		if(n == 1){
			return 0;
		}
		
		if( n == 2){
			return 1;
		}
		
		return getNthFib(n-1) + getNthFib(n-2);
  }
}
