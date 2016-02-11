public class ThreeSumClosest {
    
   /**
     * Original Problem: Is there any pair of 3 numbers that sum to target?
     * New Problem: Is there any pair of 3 numbers that sum closest to target?
     * 
     * Brute force solution, find the sum of every possible group of 3 numbers and track which one is closest to target
     * O(n^3)
     * 
     * 1. Sort the array
     * 2. For each element in the array, have 2 pointers at the remaining parts of array, and try to sum up to target
     * O(n^2)
     * 3. Find the closest element to the target instead of exactly to the target
     * 
     */
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closestSum = Integer.MAX_VALUE;
        
        int left, right;
        for(int i = 0; i < num.length-2; i++){
            left = i+1;
            right = num.length - 1;
            
            while(left < right){
                
                // we havent found a closestSum yet, just take the first sum
                if(closestSum == Integer.MAX_VALUE){
                     closestSum = num[left] + num[right] + num[i];
                }
                
                // checks for the closest of sums
                else if(Math.abs(closestSum - target) > (Math.abs(target - (num[left] + num[right] + num[i])))){
                        closestSum = num[left] + num[right] + num[i];
                        
                        // if you sum up to target, there is no possible closer sum
                        if(closestSum == target){
                            return target;
                        }
                }
                
                
                if(num[left] + num[right] + num[i] < target){
                    left++;
                }
                else{
                    right--;
                }
            }
            
        }
        return closestSum;
    }
}