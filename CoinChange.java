public class CoinChange {
    int [] globalCoins;
    int [][] dp;
    
    public int coinChange(int[] coins, int amount) {
        globalCoins = coins;
        
        dp = new int [coins.length+1][amount+1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        int res = makeChange(0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    // state: index, amount
    
    public int makeChange(int index, int amount){
        if(amount == 0){
            return 0;
        }
        
        if(index >= globalCoins.length || amount < 0){
            return Integer.MAX_VALUE;
        }
        
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        
        else{
        
            int res1 = makeChange(index, amount - globalCoins[index]);
            int res2 = makeChange(index + 1, amount);
            
            if(res1 != Integer.MAX_VALUE){
                res1 += 1;
            }
            
            int result = Math.min(
                res1,
                res2
            );
            
            dp[index][amount] = result;
            
            return result;
        }
    }
}