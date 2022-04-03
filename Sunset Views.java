import java.util.*;

class Program {

  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
		int i=0;
		int n = buildings.length;
		int j= n-1;
		int maxHeight = 0;
		ArrayList<Integer> result = new ArrayList();
		if(direction.equals("WEST")){
			while( i < n){
				if(buildings[i] > maxHeight){
					maxHeight = buildings[i];
					result.add(i);
				}
				i++;
			}
		}else{
			while(j >= 0 ){
				if(buildings[j] > maxHeight){
					maxHeight = buildings[j];
					result.add(0,j);
				}
				j--;
			}
		}
    return result;
  }
}
