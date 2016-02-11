public class RotateImage {
    
    public void rotate(int [][] matrix){
		int n = matrix.length;
		
		for(int layer = 0; layer < n/2; layer++){
			int first = layer; 
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++){
				
				
				int offset = i - first;
				
				// save top left
				int temp = matrix[first][i];
				
				// move bottom left to top left
				matrix[first][i] = matrix[last - offset][first];
				
				// move bottom right to bottom left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// move top right to bottom right
				matrix[last][last - offset] = matrix[i][last];
				
				// move the top left to top right
				matrix[i][last] = temp;
				
			}
		}
	}
}