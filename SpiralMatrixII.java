public class SpiralMatrixII {
      public int[][] generateMatrix(int n) {
	        int [][] toRet = new int[n][n];
	        
	        genHelper(toRet, n, 0, 1, n);
	        
	        return toRet;
	        
	    }
	    
	    public void genHelper(int [][] toRet , int n, int x, int start, int layer){
	        
	        if(layer == 0)
	        	return;
	        
	        if(layer == 1){
	        	toRet[x][x] = start;
	        	return;
	        }
	        	
	        
	        else{
	            for(int i = x; i <= n-1-x; i++){
	                toRet[x][i] = start;
	                start++;
	            }
	            
	            for(int i = x+1; i <= n-x-1; i++){
	                toRet[i][n-x-1] = start;
	                start++;
	            }
	            
	            for(int i = n-x-2; i >= x; i--){
	                toRet[n-x-1][i] = start;
	                start++;
	            }
	            
	            for(int i = n-x-2; i > x; i--){
	                toRet[i][x] = start;
	                start++;
	            }
	            
	            //System.out.println("Here!" + (n) + " " + (x+1) + " " + start + " " + (layer-2));
	            genHelper(toRet, n, x+1, start, layer-2);
	        }
	        
	    }
}