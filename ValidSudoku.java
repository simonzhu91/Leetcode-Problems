public class Solution {
    public boolean checkBox(char [][] matrix, int i , int j){
        
        HashSet<Character> set = new HashSet<Character>();
        
        for(int x = i; x <= i+2; x++){
            for(int y = j; y <= j+2; y++){
                if(set.contains(matrix[x][y])){
                    return false;
                }
                else if(matrix[x][y] != '.'){
                    set.add(matrix[x][y]);
                }
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        char [][] matrix = board;
        
        HashSet<Character> set = new HashSet<Character>();
        
        // check row
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(set.contains(matrix[i][j])){
                    return false;
                }
                else if(matrix[i][j] != '.'){
                    set.add(matrix[i][j]);
                }
            }
            set = new HashSet<Character>();
        }
        
        // check columns
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(set.contains(matrix[j][i])){
                    return false;
                }
                else if(matrix[j][i] != '.'){
                    set.add(matrix[j][i]);
                }
            }
            set = new HashSet<Character>();
        }
        
        // check group of 3
        for(int i = 0; i < matrix.length / 3; i++){
            for(int j = 0; j < matrix[i].length / 3; j++){
                
                boolean result = checkBox(matrix, i * 3, j * 3);
                if(!result){
                //   System.out.println(0);
                  return false;
                }
            }
        }
        // System.out.println(1);
        return true;
    }
}