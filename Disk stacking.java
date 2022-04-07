import java.util.*;

class Program {
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		int n = disks.size();
		disks.sort((disk1, disk2) -> disk1[2] - disk2[2]);
		int maxHeight = Integer.MIN_VALUE;
		int maxHeightIndex = -1;
		int[] dp = new int[n];
		for(int i=0; i< n; i++){
			Integer[] disk = disks.get(i);
			dp[i] = disk[2];
		}
		
		int[] indices = new int[n];
		Arrays.fill(indices, -1);
		
		for(int i=0; i < n ; i++){
			for(int j=0; j < i; j++){
				if(canPlaceOnTop(disks.get(i), disks.get(j))){
					Integer[] currDisk = disks.get(i);
					if(dp[j] + currDisk[2] > dp[i]){
						// we can include this
						dp[i] = currDisk[2] + dp[j];
						indices[i] = j;
					}
				}
			}
			if(dp[i] > maxHeight){
				maxHeight = dp[i];
				maxHeightIndex = i;
			}
		}
		
		List<Integer[]> result = new ArrayList();
		int k = maxHeightIndex;
		while(k != -1){
			result.add(0, disks.get(k));
			k = indices[k];
		}
		
    return result;
  }
	
	private static boolean canPlaceOnTop(Integer[] bottom, Integer[] top){
		return ((bottom[0] > top[0]) && (bottom[1] > top[1]) && (bottom[2] > top[2])); 
	}
}
