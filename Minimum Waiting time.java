import java.util.*;

class Program {

  public int minimumWaitingTime(int[] queries) {
    // Write your code here.
		if(queries.length < 1){
			return 0;
		}
		int currSum = 0;
		int sum = 0;
		Arrays.sort(queries);
		for(int i=1; i < queries.length; i++){
			currSum += queries[i-1];
			sum += currSum;
		}
		
    return sum;
  }
}
