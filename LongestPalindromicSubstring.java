public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        /* Algo: Compute every single possible substring of s and check if it is a palindrome (Brute Force) */
        
        if(s == null)
            return null;
        
        if(s.equals(""))
            return "";
        
        int length = s.length();
        int longest_palindrome_start = -1;
        int longest_length = 0;
        
        
        for(int i = 0; i < length; i++){
            
            // for odd palindromes
            int left = i, right = i;
            while(left >= 0 && right < length){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                
                if(right - left + 1 > longest_length){
                    longest_length = right - left + 1;
                    longest_palindrome_start = left;
                }
                
                left--;
                right++;
            }
            
            // for even palindromes
            left = i; right = i+1;
            while(left >= 0 && right < length){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }
                
                if(right - left + 1 > longest_length){
                    longest_length = right - left + 1;
                    longest_palindrome_start = left;
                }
                
                left--;
                right++;
            }
            
        }
        
        return s.substring(longest_palindrome_start, longest_palindrome_start + longest_length);
    }
}