public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        
        int start = 0, end = 0;
        List<String> toRet = new ArrayList<String>();
        String str = "";
        
        if(nums.length == 0)
            return toRet;
        
        for(int i = 0; i < nums.length - 1; i++){
            
            // if consecutive
            if(nums[i] + 1 == nums[i + 1]){
                end++;
                
                // if the start, adds the string
                if(i == start){
                    str = nums[i] + "";
                }
            }
            
            // if not consecutive
            else{
                if(start != end){
                    str += "->" + nums[i];
                }
                else{
                    str = nums[i] + "";    
                }
                
                toRet.add(str);
                start = i+1;
                end = i+1;
            }
        }
        
        // covers the last element
        if(start == end){
            toRet.add(nums[end]+"");
        }
        else{
            str += "->" + nums[end];
            toRet.add(str);
        }
        
        return toRet;
    
    }
}