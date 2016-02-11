public class ZigZagConversion {
   public String convert(String s, int nRows) {
    	if(s == null){
    		return null;
    	}
    	
    	if(nRows == 1){
    		return s;
    	}
    	
        char [][] matrix = new char[nRows][s.length()];
        
        int xCoord = 0;
        int yCoord = 0;
        boolean direction = false;
        int length = s.length();
        
        for(int i = 0; i < length; i++){
            matrix[xCoord][yCoord] = s.charAt(i);
            
            // bottom index and going down
            if(xCoord == nRows - 1 && direction == false){
            	direction = !direction;
            }
            
            // top index and going diagonal
            else if(xCoord == 0 && direction == true){
            	direction = !direction;
            }
            
            // moves down
            if(xCoord < nRows-1 && direction == false){
                xCoord++;
            }
            // moves up diagonally
            else if(xCoord > 0 && direction == true){
                xCoord-=1;
                yCoord+=1;
                direction = true;
            }
            
        }
        
        char[] toRet = new char[s.length()];
        int index = 0;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < length; j++){
                if(matrix[i][j] != '\u0000'){
                    toRet[index] = matrix[i][j];
                    index++;
                }
            }
        }
        
        return new String(toRet);
    }
            
    
}