public class ReverseWordsInString {
    public String reverseWords(String s) {
        if(s == null)
            return null;
        
        String [] arr = s.split(" ");
        String toRet = "";
        
        for(int i = arr.length - 1; i >= 0; i--){
            if(!arr[i].equals(""))
            toRet += arr[i] + " ";
            
        }
        
        return toRet.trim();
    }
}