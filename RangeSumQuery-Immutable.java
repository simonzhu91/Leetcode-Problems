public class RangeSumQuery-Immutable {

    int [] sum;
    // [-2 -2 1 -4 -2 -3]

    public NumArray(int[] nums) {
        
        sum = new int[nums.length];
        
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];    
            sum[i] = total;
        }

    }

    public int sumRange(int i, int j) {
        
        if(i == 0)  
            return sum[j];
        
        return sum[j] - sum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);