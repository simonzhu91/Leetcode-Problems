public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(A.length == 0)
            return 0;

        // idea: 2 pointers, currIndex and i, currIndex is 1 less than i
        // if i != elem, A[currIndex++] = A[i], otherwise just i++
        int currIndex = -1;
        int i = 0;
        
        for(;i<A.length;i++){
            
            if(A[i] != elem){
                
                //if(currIndex == -1){
                  //  A[++currIndex] = A[i]
                //}
                
                A[++currIndex] = A[i];
            }
           
        }
        
        return currIndex + 1;
    }
}