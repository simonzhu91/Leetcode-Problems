public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.equals("") || s == null)
            return 0;
            
        String [] arr = s.split(" ");
        
        if(arr.length == 0)
            return 0;
        return arr[arr.length - 1].length();
    }
}