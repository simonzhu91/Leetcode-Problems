public class PalindromeNumber {
    
    /* Reverse an integer and check if the integer is same as before */
    public boolean isPalindrome(int x) {
       
       if(x < 0)
       return false;
    
        if(x == 0)
            return true;
        
        int reverse = reverse(x);
        return reverse == x;
        
    }
    
    public int reverse(int x){
        int total = 0;
        
        while(x != 0){
            total *= 10;
            total += x % 10;
            x /= 10;
        }
        return total;
    }
}