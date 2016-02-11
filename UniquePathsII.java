public class UniquePathsII {
 
        /**
	 * Find the uniquePath with obstacles: an entry of [1] in the maze
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int [][]paths = new int[m][n];
		
		boolean rowFlag = false;
		boolean colFlag = false;
		
		// traverse first row and first column
		// if run into a 1, then rest of elements in first row / column are 0
		// then traverse rest of matrix: paths[m][n] = paths[m-1][n] + paths[m][n-1]
		// return paths[m-1][n-1]
		
		for(int i = 0; i < m; i ++){
			for(int a = 0; a < n; a++){
				
			    if(i == 0 && a==0){
					if(obstacleGrid[0][0] == 0){
						paths[i][a] = 1;
					}else{
						paths[i][a] = 0;
					}
					
				}
				
				else if(i == 0){
					if(obstacleGrid[i][a] == 1){
						rowFlag = true;
					}
					if(!rowFlag)
						paths[i][a] = paths[i][a-1];
					else{
						paths[i][a] = 0;
					}
				}else if(a == 0){
					if(obstacleGrid[i][a] == 1){
						colFlag = true;
					}
					if(!colFlag)
						paths[i][a] = paths[i-1][a];
					else{
						paths[i][a] = 0;
					}
				}else{
					if(obstacleGrid[i][a] != 1){
						paths[i][a] = paths[i-1][a] + paths[i][a-1];
					}else{
						paths[i][a] = 0;
					}
				}
				
			}
		}
		
		return paths[m-1][n-1];
    
	
    }
}