public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int j = 0;
        
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            
            // this is not your starting point
            if(sum < 0){
                j = i+1;
                sum = 0;
            }
            
        }
        
        if(total < 0)
            return -1;
        
        return j;
    }
}