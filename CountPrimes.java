public class CountPrimes {
    
    // 1 2 3 4 5 6 7 8 9 10
    // x x   x   x   x x x
    
    public int countPrimes(int n) {
        boolean [] primes = new boolean[n];
        
        for(int i = 2; i < n; i++){
            primes[i] = true;
        }
        // loop from 2 to sqrt(n)
        // Mark each multiple of the number as false
        // Go through and count the number of trues in the primes array
        // O(n log log n)?
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(primes[i] == true){
                for(int j = 2*i; j < n; j += i){
                    primes[j] = false;
                }
            }
        }
        
        int toRet = 0;
        for(int i = 2; i < n; i++){
            if(primes[i] == true){
                toRet++;
            }
        }
        
        return toRet;
    }
}