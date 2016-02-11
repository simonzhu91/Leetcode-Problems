public class LongestIncreasingSubsequence {
    
    int [][] dp;
    
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        // make an array with 1 extra size
        int []temp = new int[nums.length + 1];
        temp[0] = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            temp[i+1] = nums[i];
        }
        // int largest = Integer.MIN_VALUE;
        
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] > largest)
        //         largest = nums[i];
        // }
            
            
        dp = new int[temp.length + 1][temp.length];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(temp, 0, 1);
    }
    
    public int helper(int [] nums, int valueTakenIndex, int index){
        if(index >= nums.length)
            return 0;
        
        if(dp[valueTakenIndex][index] != -1){
            return dp[valueTakenIndex][index];
        }
        
        else{
            int res = 0;
            
            if(nums[index] > nums[valueTakenIndex]){
                res = Math.max(
                    helper(nums, valueTakenIndex, index+1), 
                    1+helper(nums, index, index+1)
                );
            }
            
            else{
                res = helper(nums, valueTakenIndex, index+1);
            }
                
            dp[valueTakenIndex][index] = res;    
            
            return res;
        }
    }
}