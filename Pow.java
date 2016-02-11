public class Pow {
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        
        boolean flag = false;
        if(n < 0){
            flag = true;
            n *= -1;
        }
        
        double total = 1;
        
        while(n != 0){
            if(n % 2 == 1){
                total *= x;
                n -= 1;
            }    
            
            else{
                x *= x;
                n /= 2;
            }
            
        }
        
        if(flag){
            total = 1 / total;
        }
            
        return total;
    }
}