public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                count++;
        }
        
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        
        for(; index<nums.length;index++){
            nums[index] = 0;
        }
    }
}