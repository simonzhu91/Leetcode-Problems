public class SearchInsertPosition {
    
    public int searchInsert(int A[], int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }
    
    public int binarySearch(int A[], int start, int end, int target){
        
        if(start > end){
            return start;
        }
        
        int mid = (start + end)/2;
        
        if(A[mid] > target){
            return binarySearch(A, start, mid - 1, target);
        }
        else if(A[mid] < target){
            return binarySearch(A, mid+1, end, target);
        }
        else{
            return mid;
        }
    }
}