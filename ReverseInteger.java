public class ReverseInteger {
    
    // take off the ones digit at each time and append it to the new number
    // at each step, multiply your total by 10 and divide your x by 10
    public int reverse(int x) {
        
        if(x == 0)
            return 0;
        
        boolean flag = false;
        
        if(x < 0){
            flag = true;
            x *= -1;
        }
            
        
        int total = 0;
        
        while(x != 0){
             total *= 10;
       
            total += x % 10;
                 
            x /= 10;
           
            
        }
 
        if(flag){
            total *= -1;
        }
               
        return total;
    }
}