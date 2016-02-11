//[2, 3, -2, 4, 10, -3] => 1. max_so_far 2. min_so_far 3. abs_max 4. abs_min

//the max_so_far at every step can be either the (max_so_far * a[i], min_so_far * a[i], a[i])
//the min_so_far at every step can be either the (max_so_far * a[i], min_so_far * a[i], a[i])
//update abs_max or min if max or min_so_far exceeds it

// max_so_far = 1440
// min_so_far = -3

// abs_max = 1440
// abs_min = -480

// abs_max and min should start at 1

/*
    [1, 4, -2, 3]
    max_so_far = 3
    min_so_far = -24
    abs_max = 4
    abs_min = -24

*/
public class MaxProductSubarray {
    public int maxProduct(int[] A) {
        int max_so_far = A[0];
        int min_so_far = A[0];
        int abs_max = A[0];
        int abs_min = A[0];
        int temp;
        
        for(int i = 1; i < A.length; i++){
            temp = max_so_far;
            max_so_far = Math.max(Math.max(max_so_far * A[i], min_so_far * A[i]), A[i]);
            min_so_far = Math.min(Math.min(temp * A[i], min_so_far * A[i]), A[i]);
            
            if(max_so_far > abs_max){
                abs_max = max_so_far;
            }
            if(min_so_far < abs_min){
                abs_min = min_so_far;
            }
            
        }
        
        return abs_max;
    }
}