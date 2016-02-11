public class PascalsTriangleII {
    
    /* Recursive algorithm by nature 
        getRow(2).size = getRow(1).size + 1
        initialize first and last element to 1
        middle elements are sum(i , i-1)
        
    */
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> toRet = new ArrayList<Integer>();
        
        if(rowIndex == 0){
            toRet.add(1);
            return toRet;
        }
        
        else if(rowIndex == 1){
            toRet.add(1);
            toRet.add(1);
            return toRet;
        }
        else{
            toRet.add(1);
            ArrayList<Integer> prevRow = getRow(rowIndex - 1);
            for(int i = 1; i < prevRow.size() ; i++){
                toRet.add(prevRow.get(i) + prevRow.get(i - 1));
            }
            toRet.add(1);
            return toRet;
        }
    }
}