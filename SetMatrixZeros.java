public class SetMatrixZeros {
     public static void setZeroes(int[][] matrix) {
        
        
        int row = -1;
        int col = -1;
        boolean first = false;
        // Note: The Solution object is instantiated only once and is reused by each test case.
        for(int i = 0; i < matrix.length; i++){
            for(int a = 0; a < matrix[i].length; a++){
                //looks for first 0
                if(matrix[i][a] == 0 && first == false){
                    row = i;
                    col = a;
                    first = true;
                }   
                
                else if(matrix[i][a] == 0){
                    matrix[row][a] = 0;
                    matrix[i][col] = 0;
                }
            }
        }
        
        if(row != -1 && col != -1){
        //goes through column if any elements are 0
        for(int i = 0; i < matrix.length; i++){
           if(matrix[i][col] == 0 && i != row){
                //sets that row to 0
                for(int a = 0; a < matrix[i].length; a ++){
                    
                    matrix [i][a] = 0;
                    
                }
           }
        }
        
        for(int i = 0; i < matrix[row].length; i++){
           if(matrix[row][i] == 0 && i != col){
                //sets that row to 0
                for(int a = 0; a < matrix.length; a ++){
                   
                    matrix [a][i] = 0;
                    
                }
           }
        }
        
           //sets the tracking row and col to 0
           for(int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
            
            for(int i = 0; i < matrix[row].length; i++){
                matrix[row][i] = 0;
            }
        }
    }
}