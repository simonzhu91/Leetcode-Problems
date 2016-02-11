public class MissingNumber {
    
    // 1, 2, 3, 4
    // 1, 2, 3
    
    // 0, 1
    
    // Add all the numbers together and subtract from (n * n+1) / 2
    public int missingNumber(int[] nums) {
        int total = 0;
        int abs_total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        
        abs_total = (int)(nums.length * (((double)(nums.length + 1)) / 2));
        return abs_total - total;
    }
}