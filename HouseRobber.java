public class HouseRobber {
    public int rob(int[] nums) {
        int [] memoize = new int[nums.length];
        
        for(int i = 0;i < nums.length;i++){
            memoize[i] = -1;
        }
        
        return helper(nums, 0, memoize);
    }
    
    public int helper(int [] nums, int index, int[] memoize){
        if(index < 0 || index >= nums.length)
            return 0;
        
        int val = 0;
        
        if(memoize[index] == -1){
            val = Math.max(
                nums[index] + helper(nums, index+2, memoize),
                helper(nums, index+1, memoize)
            );
        }
        
        else{
            val = memoize[index];
        }
        
        memoize[index] = val;
        return val;
    }
    
}