import java.util.*;

class Program {
  public static int waterArea(int[] heights) {
		int n = heights.length;
		if(n == 0){
			return 0;
		}
		int[] leftHeightMax = new int[n];
		leftHeightMax[0] = 0;
		int[] rightHeightMax = new int[n];
		rightHeightMax[n-1]=0;
		
		int leftMax = 0;
		for(int i=1; i < n ; i++){
			leftMax= Math.max(leftMax, heights[i-1]);
			leftHeightMax[i] = leftMax;
		}
		int rightMax = 0;
		for(int i=n-2; i >= 0 ; i--){
			rightMax= Math.max(rightMax, heights[i+1]);
			rightHeightMax[i] = rightMax;
		}
		
		int totalWaterTapped =0;
		for(int j=0 ; j < n; j++){
			int height = heights[j];
			// we can trap water upto min height without spillover
			int minHeight = Math.min(leftHeightMax[j], rightHeightMax[j]);
			
			// we can only trap water at index i if minHeight is greater than currHeight
			if(minHeight > height){
				int waterTrapped = minHeight - height;
				totalWaterTapped += waterTrapped;
			}
		}
    return totalWaterTapped;
  }
}
