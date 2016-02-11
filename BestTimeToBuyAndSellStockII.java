public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        
		if(prices == null || prices.length == 0 || prices.length == 1){
        	return 0;
        }

        int total = 0;
        int min = -1;
        
        for(int i = 0; i < prices.length; i++){
            
            // if i is a local minimum
            if(isMin(i, prices)){
                //System.out.println("New Min: " + i);
            	min = i;
            }
            
            else if(isMax(i, prices)){
                if(min != -1){
                	//System.out.println("New Max: " + i);
                    total += prices[i] - prices[min];                    
                    min = -1;
                }
            }
            
        }
        
        return total;
    }
    
    public boolean isMin(int i, int[] a){
    	//System.out.println("Min: " + i);
        return ((i == 0 && a[i+1] > a[i]) || (i == a.length-1 && a[i-1] > a[i]) || (i > 0 && i < a.length -1 && a[i-1] >= a[i] && a[i+1] > a[i]));
    }
    
    public boolean isMax(int i, int[] a){
//    	System.out.println("Max: " + i);
        return ((i == 0 && a[i+1] < a[i]) || (i == a.length-1 && a[i-1] < a[i]) || (i > 0 && i < a.length-1 && a[i-1] < a[i] && a[i+1] <= a[i]));
    }
	
}