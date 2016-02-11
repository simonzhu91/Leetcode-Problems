public class Permutations {
    
    
    public List<List<Integer>> permute(int[] nums) {
        
        if(nums.length == 0){
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> result = helper(nums, 0);    
        return result;
    }
    
    public ArrayList<Integer> clone(List<Integer> array){
        ArrayList<Integer> alist = new ArrayList<Integer>();
        
        for(int i = 0; i < array.size(); i++){
            alist.add(array.get(i));
        }
        
        return alist;
    }
    
    public List<List<Integer>> helper(int[]nums, int index){
        
        
        
        if(index == nums.length - 1){
            List<List<Integer>> toRet = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[index]);
            toRet.add(list);
            return toRet;
        }
        
        else{
            int firstVal = nums[index];
            
            List<List<Integer>> result = helper(nums, index + 1);
            
            List<List<Integer>> toRet = new ArrayList<List<Integer>>();
            
            for(int i = 0; i < result.size(); i++){
                for(int j = 0; j <= result.get(i).size(); j++){
                    // make copy of arrayList
                    ArrayList<Integer> copy = clone(result.get(i));
                    
                    copy.add(j, firstVal);
                    toRet.add(copy);
                
                }
            }
            
            return toRet;
            
        }
    }
}