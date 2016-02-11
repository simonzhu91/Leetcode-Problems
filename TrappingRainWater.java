public class TrappingRainWater {
    public int trap(int[] height) {
        
        int left = 0, right = height.length - 1, lower = 0, level = 0, water = 0;
        
        while(left < right){
            
            if(height[left] < height[right]){
                lower = left;
                left++;
            }
            else{
                lower = right;
                right--;
            }
            
            level = Math.max(height[lower], level);
            water += level - height[lower];
            
        }
        
        return water;
        
    }
}