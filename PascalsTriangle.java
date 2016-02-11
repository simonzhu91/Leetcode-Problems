public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        ArrayList<Integer> next = new ArrayList<Integer>();
        
        if(numRows <= 0)
            return alist;
        
        level.add(1);
        alist.add(level);
            
        if(numRows == 1){
         return alist;
        }
        else{
            for(int a = 0; a < numRows - 1; a++){
                next.add(1);
                //traverses the previous level until 2nd to last
                for(int i = 0; i < level.size() - 1; i++){
                    next.add(level.get(i) + level.get(i+1));
                }
                next.add(1);
            
                alist.add(next);
                level = next;
                next = new ArrayList<Integer>();
            }
        }
        
        return alist;
    }
}