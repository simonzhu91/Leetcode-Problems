public class HappyNumber {

    
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        return isHappyHelper(n, set);
    }
    
    public boolean isHappyHelper(int n, HashSet<Integer> set){
        if(n == 1){
            return true;
        }
        
        // if it contains, we already visited before
        if(set.contains(n)){
            return false;
        }else{
            set.add(n);
        }
        
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        
        return isHappyHelper(sum, set);
    }
}