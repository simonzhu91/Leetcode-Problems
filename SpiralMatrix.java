public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> alist = new ArrayList<Integer>();
        if(matrix.length == 0)
            return alist;
            
        layer(alist, matrix, 0, 0, matrix.length, matrix[0].length);
        return alist;
    }
    
    public void layer(List<Integer> alist, int [][] matrix, int startX, int startY, int dimX, int dimY){
       
       // stop when either dimension is less than or equal to 0
       if(dimX <= 0 || dimY <= 0)
            return;
       
       // or if one of the dimensions is 1        
       if(dimX == 1){
           for(int i = startY ;i < startY + dimY; i++){
               alist.add(matrix[startX][i]);
           }
           return;
       } 
       else if(dimY == 1){
            for(int i = startX; i < startX + dimX; i++){
               alist.add(matrix[i][startY]);
           }
           return;
       }
       
        int i = startY;
        int j = startX;
        
        for(i = startY; i < startY + dimY; i++){
            alist.add(matrix[startX][i]);
        }
        i -= 1;
        
        for(j = startX + 1; j < startX + dimX; j++){
            alist.add(matrix[j][i]);
        }
        j -= 1;
        
        for(i = i-1 ; i >= startY; i--){
            alist.add(matrix[j][i]);
        }
        i += 1;
        
        for(j = j-1; j >= startX + 1; j--){
            alist.add(matrix[j][i]);
        }
        j += 1;
        
        layer(alist, matrix, startX + 1, startY + 1, dimX - 2, dimY - 2);
    }
}