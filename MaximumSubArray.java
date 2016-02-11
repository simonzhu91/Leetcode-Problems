public class MaximumSubArray {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        
        // check if all the numbers are negative, if so return the max of them
        for(int i = 0; i < A.length; i++){
            
            if(A[i] >= 0){
                flag = false;
            }
            
            // finds the largest of the values
            if(A[i] > max){
                max = A[i];
            }
            
        }
        
        if(flag){
            return max;
        }
        
        // start rest of code
        int localMax = 0;
        int absMax = 0;
        
        for(int i = 0; i < A.length; i++){
            localMax += A[i];
            
            if(localMax < 0)
                localMax = 0;
                
            else if(localMax > absMax){
                absMax = localMax;
            }
            
        }
        return absMax;
        
    }
}