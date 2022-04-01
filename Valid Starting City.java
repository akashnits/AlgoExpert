import java.util.*;

class Program {

  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
		int i =0;
		int starting_city =0;
		int surplusMiles =0;
		int n = distances.length;
		while(i < n){
			surplusMiles += fuel[i]*mpg - distances[i];
			if(surplusMiles < 0){
				// we can't reach here, so change starting city to next
				starting_city = i+1;
				// make surplus 0
				surplusMiles =0;
			}
			i++;
		}
    return starting_city == n ? -1 : starting_city;
  }
}
