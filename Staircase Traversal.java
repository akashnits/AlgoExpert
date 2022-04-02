import java.util.*;

class Program {
  public int staircaseTraversal(int height, int maxSteps) {
		int[] dp = new int[height+1];
		Arrays.fill(dp,-1);
    return numberOfWays(height, maxSteps);
  }
	
	private int numberOfWays(int height, int maxSteps){
		// base condition
		if(height < 0){
			return 0;
		}
		if(height == 0){
			return 1;
		}
		
		int sum=0;
		// iterate over choice 
		for(int step =1; step <= maxSteps; step++){
			height -=  step;
			sum += numberOfWays(height, maxSteps);
			height += step;
		}
		return sum;
	}
}
