class Solution {
    int givenSum;
    public boolean canSplitArray(List<Integer> nums, int m) {
        givenSum = m;
        int n = nums.size();
        if(n <= 2){
            return true;
        }


        return canPartitionNWays(nums, 0, n-1, new Boolean[n][n]);
    }
    
    
    boolean canPartitionNWays(List<Integer> nums, int start, int end, Boolean[][] dp){
        
        // base condition 
        // case1: subarray length == 1
        if(end - start + 1 == 1){
            dp[start][end] = true;
            return dp[start][end];
        }

        // case2: sum of subarray >= m, we need to partition further; else return false
        if(calculateSubArraySum(nums, start, end) < givenSum){
            dp[start][end] = false;
            return dp[start][end]; 
        }

        if(dp[start][end] != null){
            return dp[start][end];
        }

        
        // choice - divide into subarrays of length equals or greater than 2
        for(int j = start; j < end ; j++){

            // partition into two halves
            if( canPartitionNWays(nums, start, j, dp) && canPartitionNWays(nums, j+1, end, dp)){
                dp[start][end]= true;
                return dp[start][end];
            }
        }
        dp[start][end] = false;
        return dp[start][end];
    }
    
    
    int calculateSubArraySum(List<Integer> nums, int start, int end){
        int sum =0;
        
        for(int i=start; i <=end; i++ ){
            sum += nums.get(i);
        }
        return sum;
    }
}
