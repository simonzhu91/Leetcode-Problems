public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        if(s == null || t == null)
            return true;
        
        if(s.length() != t.length())
            return false;
        
        int[] array = new int[256];
        
        for(int i = 0; i < s.length(); i++){
            array[s.charAt(i)] ++;    
        }
        
        for(int j = 0; j < t.length(); j++){
            array[t.charAt(j)] --;
        }
        
        for(int k = 0; k < 256; k++){
            if(array[k] != 0)
                return false;
        }
        
        return true;
    }
}