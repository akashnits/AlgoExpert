import java.util.*;

class Program {
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
	
		int n = items.length;
		int c = capacity;
		List<Integer> weight = new ArrayList();
		List<Integer> value = new ArrayList();
		
		for(int i=0; i< n; i++){
			// (value, weight)
			value.add(items[i][0]);
			weight.add(items[i][1]);
		}
		
		int[][] dp = new int[n+1][c+1];
		
		// initilize dp array 
		for(int i=0; i <= n; i++){
			dp[i][0] = 0;
		}
		for(int j=0; j <= c; j++ ){
			dp[0][j] = 0;
		}
		
		// call maxCombinedValue and fill dp array
		dp = maxCombinedValue(weight, value, n, c, dp);
		
		List<Integer> indicesList = new ArrayList();
		int a= n, b = c;
		while(a > 0 && b > 0){
			if(dp[a][b] == dp[a-1][b]){
				a--;
				continue;
			}else{
				indicesList.add(a-1);
				b -= weight.get(a-1);
				a--;
			}
		}
				
    // Replace the code below.
    List<Integer> totalValue = Arrays.asList(dp[n][c]);
    var result = new ArrayList<List<Integer>>();
    result.add(totalValue);
    result.add(indicesList);
    return result;
  }
	
	
	public static int[][] maxCombinedValue(List<Integer> weight, List<Integer> value, int n, int c, int[][] dp){
		for(int i=1; i <= n; i++){
			for(int j=1; j <= c; j++){
				if(weight.get(i-1) <= j){
					// we can pick or leave
					int pick = value.get(i-1) + dp[i-1][j- weight.get(i-1)];
					dp[i][j] = Math.max(pick, dp[i-1][j]);
			}else{
				dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp;
	}
}
