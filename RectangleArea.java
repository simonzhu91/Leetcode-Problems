public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - intersection(A, B, C, D, E, F, G, H);
    }
    
    public static int intersection(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        int overlap = 0;
        
        if(left < right && bottom < top){
            overlap = (right - left) * (top - bottom);
        }
        
        return overlap;
        
    }
}