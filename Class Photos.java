import java.util.*;

class Program {

  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Write your code here.
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);
		if(redShirtHeights.get(0) == blueShirtHeights.get(0)){
			return false;
		}
		int n = blueShirtHeights.size();
		boolean isBlueTaller = blueShirtHeights.get(0) > redShirtHeights.get(0);
		if(isBlueTaller){
			// can place blue at the back?
			for(int i=1; i < n; i++){
				if(redShirtHeights.get(i) >= blueShirtHeights.get(i)){
					return false;
				}
			}
		}else{
			// can place red at the back?
			for(int i=1; i < n; i++){
				if(redShirtHeights.get(i) <= blueShirtHeights.get(i)){
					return false;
				}
			}
		}
    return true;
  }
}
