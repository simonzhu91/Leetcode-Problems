public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        // loop from 1 - n, count number of factors of 5
        // But note, 25 gives 2 5's, as does 125 gives 3 5's
        // 25, 125, 625, etc.
        
        // 5, 10, 15, 20, 25, 30...
        // Every power of 5, gives an extra 5
        
        if(n < 0)
            return -1;
            
        long i = 5;
        long count = 0;
        while(i <= n){
            
            count += n / i;
            i *= 5;
        }
        
        return (int)count;
        
    }
}