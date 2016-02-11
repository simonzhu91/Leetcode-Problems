public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = Integer.MIN_VALUE;
        
        while(start < end){
            area = Math.max(area, Math.min(height[start], height[end]) * (end - start));
            
            if(height[start] < height[end])
                start ++;
            
            else if(height[start] > height[end])
                end --;
            
            else{
                start++;
                end--;
            }
        }
        return area;
        
    }
}