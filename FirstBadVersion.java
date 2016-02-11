/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return (int)helper(1, n);
    }
    
    public double helper(int start, int end){
        
        if(start > end){
            return -1;
        }
        
        
        int mid = (int)(((double)start + (double)end) / 2);
        
        boolean isBad = isBadVersion(mid);
        
        if(isBad){
            // is this the first bad version?
            if(mid == 1 || !isBadVersion(mid - 1)){
                return mid;
            }
            else{
                return helper(start, mid-1);
            }
        }
        else{
            return helper(mid+1, end);
        }
        
    }
}