public class GameOfLife {
    
    public boolean inBounds(int [][]board, int x, int y){
        return (x >= 0 && x < board.length) && (y >= 0 && y < board[0].length);
    }
    
    public int countCells(int [][]board, int x, int y){
        int count = 0;
        
        for(int i = x-1; i <= x+1; i++){
          for(int j = y-1; j <= y+1; j++){
            if(inBounds(board, i, j) && (i != x || j != y)){
              if(board[i][j] == 1){
                count++;
              }
            }
          }
        }
        
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        int [][] updatedBoard = new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(countCells(board, i, j) < 2 && board[i][j] == 1){
                    updatedBoard[i][j] = 0;
                }
                
                else if(countCells(board, i, j) > 3 && board[i][j] == 1){
                    updatedBoard[i][j] = 0;
                }
                
                else if(countCells(board, i, j) == 3 && board[i][j] == 0){
                    updatedBoard[i][j] = 1;
                }
                else{
                    updatedBoard[i][j] = board[i][j];
            
                }        
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = updatedBoard[i][j];
            }
        }
    }
}