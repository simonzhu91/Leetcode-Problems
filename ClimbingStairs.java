public class ClimbingStairs {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(n == 0 || n == 1)
            return 1;
        
        int [] arr = new int[n + 1];
        int i;
        arr[0] = 1;
        arr[1] = 1;
        
        for(i = 2; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i - 2]; 
        }
        
        return arr[i - 1];
            
        
    }
}