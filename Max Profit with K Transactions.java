import java.util.*;

class Program {
	// state variables 
	// k - number of transactions allowed
	// i - current position (day)
	// isHolding - if we already have a share
	int maxProfit = Integer.MIN_VALUE;
  public static int maxProfitWithKTransactions(int[] prices, int k) {
		int[][][] dp = new int[prices.length+1][k+1][2];
		for(int[][] matrix: dp){
			for(int[] row: matrix){
				Arrays.fill(row, -1);
			}
		}
    return maxProfit(prices, k, 0, 0, dp);
  }
	
	
	private static int maxProfit(int[] prices, int k, int isHolding, int i, int[][][] dp){
		// base condition
		if(i == prices.length || k == 0){
			dp[i][k][isHolding] = 0;
			return 0;
		}
		
		if(dp[i][k][isHolding] != -1){
			return dp[i][k][isHolding];
		}
		// choice diagram - we want to maximise profit
		if(isHolding == 1){
			// we can't buy a share, either sell or don't - choose max profit
			// choice 1: we sell; choice 2: we don't sell
			dp[i][k][isHolding] =  Math.max(prices[i] + maxProfit(prices, k-1, 0, i+1, dp), maxProfit(prices, k, isHolding, i+1, dp));
			
		}else{
			// we can buy or not buy - choose max profit
			// choice 1: we buy; choice 2: we don't
			dp[i][k][isHolding] = Math.max(-prices[i] + maxProfit(prices, k, 1, i+1, dp), maxProfit(prices, k, isHolding, i+1, dp));
		}
		return dp[i][k][isHolding];
	}
}
