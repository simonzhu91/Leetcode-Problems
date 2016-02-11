public class FindPeakElement {
    
    // 6 1 2 3 4 5 6
    // 1 2 3 4 5 6 1
    
    // if increasing, then call on right
    // if peak, then return
    // if trough, call on left
    
    public int findPeakElement(int[] nums) {
        int st = 0, end = nums.length-1;
        
        while(st <= end){
            
            if(st == end)
                return st;
            if((end - st) == 1)
                return nums[end] > nums[st] ? end : st;
            
            int mid = (st + end) / 2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if(nums[mid] < nums[mid+1] && nums[mid-1] < nums[mid]){
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        return -1;
        
        // return binarySearch(nums, 0, nums.length-1);
    }
    
    // public int binarySearch(int [] nums, int st, int end){
    //     if(st > end)
    //         return -1;
        
    //     if(st == end)
    //         return st;
            
    //     if((end - st) == 1)
    //         return nums[end] > nums[st] ? end : st;
            
    //     int mid = (st + end) / 2;
        
    //     if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
    //         return mid;
    //     }
    //     else if(nums[mid] < nums[mid+1] && nums[mid-1] < nums[mid]){
    //         return binarySearch(nums, mid+1, end);
    //     }
    //     else{
    //         return binarySearch(nums, st, mid-1);
    //     }
        
    // }
}