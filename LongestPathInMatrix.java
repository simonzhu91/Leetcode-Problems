import java.util.*;

public class LongestPathInMatrix {
    int [][] board;
    int [][] cache;
    
    // Don't need to worry about revisiting cells, since the cells have to be strictly increasing
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length == 0)
            return 0;
        
        int maxPath = Integer.MIN_VALUE;
        board = matrix;
        cache = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int path = longestPathHelper(i, j, Integer.MIN_VALUE);

                if(path > maxPath){
                    maxPath = path;
                }
            }
        }
        return maxPath;
    }
    
    // Find the longest path for each index
    // recursive solution to find all possible paths
    public int longestPathHelper(int x, int y, int prev_val){
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] <= prev_val)
            return 0;

        if(cache[x][y] != 0){
            return cache[x][y];
        }

        int up = longestPathHelper(x, y-1, board[x][y]);
        int down = longestPathHelper(x, y+1, board[x][y]);
        int left = longestPathHelper(x-1, y, board[x][y]);
        int right = longestPathHelper(x+1, y, board[x][y]);
        
        int res = 1 + Math.max(Math.max(Math.max(up, down), left), right);
        cache[x][y] = res;
        return res;
    }
}