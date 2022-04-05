import java.util.*;

class Program {
  public static int minRewards(int[] scores) {
		
		int n = scores.length;
		if(n < 2){
			return n;
		}
		
		int[] rewards = new int[n];
		Arrays.fill(rewards, 1);
		for(int i=1; i < n ; i++){
			if(scores[i] > scores[i-1]){
				rewards[i] = rewards[i-1] +1;
			}
		}
		
		for(int j= n-2; j >=0; j--){
			if(scores[j] > scores[j+1]){
				rewards[j] = Math.max(rewards[j] ,rewards[j+1] +1);
			}
		}
		int sum =0;
		for(int val: rewards){
			sum += val;
		}
    return sum;
  }
}
