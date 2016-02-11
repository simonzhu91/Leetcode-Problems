public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int val = 0;
        
        for(int i=0; i<nums.length;i++){
            val^=nums[i];
        }
        
        val = (val & (val - 1)) ^ val;
        int A = 0;
        int B = 0;
        
        for(int i=0;i<nums.length;i++){
            if((val & nums[i]) == 0){
                A ^= nums[i];
            }
            else{
                B ^= nums[i];
            }
        }
        
        return new int[]{A, B};
        
    }
}