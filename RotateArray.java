public class RotateArray {
    public void rotate(int[] nums, int k) {
        
        // 1. split array into 2 sections, left and right
        // 2. Reverse the left and right section
        // 3. Combine the sections and reverse the result
        
        if(k > nums.length)
            k = k % nums.length;
            
        if(k == 0)
            return;
            
        reverse(nums, 0, nums.length-1 - k);
        reverse(nums, nums.length - k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        
    }
    
    public void reverse(int [] nums, int st, int end){
        
        if(nums.length == 1)
            return;
        
        if(end < st)
            return;
            
        for(int i = 0; i <= (end - st)/2; i++){
            int index1 = st + i;
            int index2 = end - i;
            
            int temp = nums[index2];
            nums[index2] = nums[index1];
            nums[index1] = temp;
        }
        
        // while(st < end){
        //     int temp = nums[st];
        //     nums[st] = nums[end];
        //     nums[end] = temp;
            
        //     st++;
        //     end--;
        // }
    }
}

// [2,3,4,5,6,1]