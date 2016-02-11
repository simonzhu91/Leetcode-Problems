public class SortColors {
    public void sortColors(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0 ; i < A.length; i++){
            if(map.containsKey(A[i])){
            	map.put((Integer)(A[i]),  1+map.get(A[i]));
            }
            else{
                map.put(A[i], 1);
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(0) && map.get(0) != 0){
                A[i] = 0;
                map.put(0, map.get(0) - 1);
            }
            else if(map.containsKey(1) && map.get(1) != 0){
                A[i] = 1;
                map.put(1, map.get(1) - 1);
            }else if(map.containsKey(2) && map.get(2) != 0){
                A[i] = 2;
                map.put(2, map.get(2) - 1);
            }
            
        }
    }
	
}