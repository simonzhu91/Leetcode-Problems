import java.util.*;

public class BulbSwitcher {
    
    // n = 5
    // 1st: on on on on on
    // 2nd: on off on off on
    // 3rd: on off off on on
    // 4th: on off off off on
    // perfect squares are on
    // all others are off
    // count number of perfect squares to n
    
    public int bulbSwitch(int n) {
        
        if(n == 0)
            return 0;
        
        int product = 0;
        int count = 0;
        while(product <= n){
            count += 1;
            product = (int)Math.pow(count, 2);
        }
        
        return count-1;
    }
    
    
}