public class SingleNumberII {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(Integer a : A){
            if(map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            }
            else{
                map.put(a, 1);
            }
        }
        
        for(Integer a : map.keySet()){
            if(map.get(a) == 1){
                return a;
            }
        }
        return 0;
        
    }
}