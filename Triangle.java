public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(triangle == null)
            return 0;
        if(triangle.size() == 0)
            return 0;
    
        //for 1 row        
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        
        while(triangle.size() >= 2){
            ArrayList<Integer> currRow = triangle.get(triangle.size() - 2);
            ArrayList<Integer> nextRow = triangle.get(triangle.size() - 1);
            
            for(int i = 0; i < currRow.size(); i++){
            //replaces the 2nd to last row with sum of current value and smaller of bottom adjacent spaces
            currRow.set(i, 
                currRow.get(i) 
                + Math.min(nextRow.get(i), nextRow.get(i + 1)));
                
            //removes the last row    
            triangle.remove(nextRow);
            }
        }
        
        return triangle.get(0).get(0);
        
    }
}