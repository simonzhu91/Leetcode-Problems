public class UniquePaths {
    
	  public int uniquePaths(int m, int n) {
		        int [][]arr = new int[m][n];
		        
		        for(int i = 0; i < arr.length; i ++){
		        	for(int a = 0; a < arr[i].length; a++){
		        		arr[i][a] = -1;
		        	}
		        }
		        
		        //initialize the right most column to 1
		        for(int i = 0; i < arr[m-1].length; i++){
		        	arr[m-1][i] = 1;
		        }
		        
		        //initialize the left most column to 1
		        for(int i = 0; i < arr.length; i++){
		        	arr[i][n-1] = 1;
		        }
		        
		        for(int i = arr.length-2; i >= 0; i--){
		        	for(int a = arr[i].length-2; a >= 0; a--){
		        		arr[i][a] = arr[i+1][a] + arr[i][a+1];
		        	}
		        }
		        
		        return arr[0][0];
		  }
}