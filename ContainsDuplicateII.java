public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int distance = Math.abs(i - map.get(nums[i]));
                if(distance <= k)
                    return true;
                else{
                    map.put(nums[i], i);
                }
            }
            else{
                map.put(nums[i], i);
            }
            
        }
        
        return false;
    }
}