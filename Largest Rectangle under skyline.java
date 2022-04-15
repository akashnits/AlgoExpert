import java.util.*;

class Program {

  public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
		int n = buildings.size();
   	int[] leftArray = new int[n];
		int[] rightArray = new int[n];
		int maxArea = 0;
		if(buildings.size() == 0){
			return 0;
		}
		// left array contains index of first value which is lesser than height[i] to the left of i
		// right array contains index of first value which is lesser than height[i] to the right of i

		leftArray[0] = -1;
		rightArray[n-1] = n;
		
		for(int i=1; i < n; i++){
			int l = i-1;
			while(l >= 0 && buildings.get(i) <= buildings.get(l)){
				l = leftArray[l];
			}
			leftArray[i] = l;
		}
		
		for(int j=n-2; j>=0; j--){
			int r = j+1;
			while(r < n && buildings.get(j) <= buildings.get(r)){
				r = rightArray[r];
			}
			rightArray[j] = r;
		}
		
		for(int i=0; i < n; i++){
			int r = rightArray[i];
			int l = leftArray[i];
			maxArea = Math.max((r-l-1) * buildings.get(i), maxArea);
		}

    return maxArea;
  }
}

