public class JumpGame {
    public boolean canJump(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        
        while(i < A.length-1){
            if(set.contains(i)){
                return false;
            } else{
                set.add(i);
            }
            
            i += A[i];
        }
        
        if(i > A.length - 1){
            return true;  
        }
        else{
            return true;
        }
    }
}