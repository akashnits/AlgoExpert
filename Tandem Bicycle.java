import java.util.*;

class Program {

  public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    // Write your code here.
		int sum= 0;
		int n = redShirtSpeeds.length;
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);
		if(fastest){
			// to maximize - pair slowest rider with fastest and so on
			for(int i =0; i < n; i++){
				sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[n-1-i]);
			}
		}else{
			// to minimize - pair fastest with fastest; slowest with slowest
			for(int i =0; i < n; i++){
				sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
			}
		}
		
    return sum;
  }
}
