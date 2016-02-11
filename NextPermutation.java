public class NextPermutation {
    public void nextPermutation(int[] num) {
        /* Strange Algorithm: 
        1. Find the 1st number from right to left that violates the increasing order 
        2. From right to left, find the first number that is greater than the previous
        3. Swap them
        4. Reverse all numbers to the left of the 1st number's index
        */
        
        if(num.length == 1){
            return;
        }
        
        // Finds the number from right that violates increasing order
        int end = num[num.length - 1];
        int i = 0;
        for(i = num.length - 2; i >= 0; i--){
            if(num[i] < end){
                break;
            }
            else{
                end = num[i];
            }
        }
        // System.out.println(i);
        
        // if we found this number, swaps with the first value greater
        if(i >= 0){
            for(int j = num.length - 1; j >= 0; j--){
                if(num[j] > num[i]){
                    // System.out.println("Swapping " + i + " " + j);
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                    break;
                }
            }
        }
        
        // reverse digits to the right of the partition index
        for(int k = num.length - 1; k > (num.length - 1 + i + 1) / 2; k--){
            
            // System.out.println("Swapping " + k + " " + (i + 1 + (num.length-1)-k));
            int temp = num[k];
            num[k] = num[i + 1 + (num.length-1)-k];
            num[i + 1 + (num.length-1)-k] = temp;
        }
        
    }
}