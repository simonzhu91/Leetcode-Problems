public class MinSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int left=0, right = 0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        
        while(right < nums.length){
            
            if(sum + nums[right] < s){
                sum  += nums[right];
                right++;
            }
            
            else{
                min_len = Math.min(min_len, right - left + 1);
                sum -= nums[left];
                left++;
            }
            
        }
        
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}