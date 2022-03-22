import java.util.*;

// Sort the coins array
// after doing some analysis, we found out that we can't make a change
// if currentChange +1 < coinValue else currentChange += coinValue 
class Program {

  public int nonConstructibleChange(int[] coins) {
    Arrays.sort(coins);
		
		int changeCreated =0;
		for(int coin: coins){
			if(coin > changeCreated +1){
				return changeCreated +1;
			}
			changeCreated += coin;
		}
		return changeCreated+1;
  }
}
