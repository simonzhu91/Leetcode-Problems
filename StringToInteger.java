public class StringToInteger {
    public int myAtoi(String str) {
        
        if(str == null || str.length() == 0){
            return 0;
        }
        
        str = str.trim();
        
        int sign = 1;
        int i = 0;
        long val = 0;
        
        if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(str.charAt(i) == '+'){
            sign = 1;
            i++;
        }
        
        while(i < str.length()){
            
            if(Character.isDigit(str.charAt(i))){
                val *= 10;
                val += (str.charAt(i) - '0');
                i++;
            }else{
                return (int) val * sign;
            }
            
            if(sign == 1 && val > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && (-1 * val) < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int) val * sign;
    }
}