public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int pos = -1;
        
        for(int i = 0; i < digits.length ; i++){
            if(digits[i] != 9)
                pos = i;
        }
        
        //add 1 to the last non-9 digit
        if(pos != -1){
            digits[pos]++;
            
            for(int a = pos+1; a < digits.length; a++){
                digits[a] = 0;
            }
            
            return digits;
        }
        //if all 9's
        else{
            int []arr = new int[digits.length + 1];
            
            arr[0] = 1;
            for(int i = 1; i < arr.length; i++){
                arr[i] = 0;
            }
            return arr;
        }
    }
}