public class TwoSum {
       
    public int[] twoSum(int [] array, int target){
       int [] arr = new int[2];
       
      if(array == null){
        return arr;
      }
      
      HashSet<Integer> set = new HashSet<Integer>();
      HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
      
      for(int i = 0; i < array.length; i++){
        
        int diff = target - array[i];
        
        if(set.contains((Integer)diff)){
          arr[0] = index.get(diff) + 1;
          arr[1] = i + 1;
          return arr;
        }
        else{
          set.add(array[i]);
          index.put(array[i], i);
        }
      }
      
      return arr;
      
      
    }

}