public class Strstr {
    public String strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return haystack.substring(i);
            }
        }
        return null;
    }
}