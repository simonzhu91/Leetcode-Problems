public class Sqrt {
    public int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    
        /* Algorithm is have a upper and lower bounds. and start at n/2. if n/2 ^ 2 is > x, then you know range is [0, n/2], then record n/2 as your upper bounds, then try n/4, if still greater, then update n/4 as upper bounds, if less, then update n/4 as lower bounds. wait till you get upper and lower bounds differ by 1 only */
        
        long lower = 0;
        long upper = x;
        
        if(x == 1)
            return 1;
     
        //keeps going until upper and lower differ by 1
        do {
            
            //if upper and lower values differ by 1, we break
            if(upper - lower <= 1){
                break;
            }
            
            long val = (lower + upper) / 2;
            
            if(val * val > x){
                upper = val;
            }
            else {
                lower = val;
            }
            
            
        } while(true);
        
        return (int)lower;
    }
}