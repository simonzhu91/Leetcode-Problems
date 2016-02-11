public class AddBinary {
    public String addBinary(String a, String b) {
        
        // prepads the strings to the be same length
        int a_len = a.length();
        int b_len = b.length();
        
        if(a_len > b_len){
            for(int i = 0; i < a_len - b_len; i++){
                b = "0" + b;
            }
            b_len = a_len;
        }else{
            for(int i = 0; i < b_len - a_len; i++){
                a = "0" + a;
            }
            a_len = b_len;
        }
        
        String sum = "";
        char carry = '0';
        
        for(int i = a_len-1; i >= 0; i--){
            int a_digit = a.charAt(i) - '0';
            int b_digit = b.charAt(i) - '0';
            int carry_digit = carry - '0';
            
            int sum_digit = a_digit + b_digit + carry_digit;
            
            if(sum_digit == 3){
                sum = "1" + sum;
                carry = '1';
            }
            else if(sum_digit == 2){
                sum = "0" + sum;
                carry = '1';
            }
            else if(sum_digit == 1){
                sum = "1" + sum;
                carry = '0';
            }
            else{
                sum = "0" + sum;
                carry = '0';
            }
        }
        
        if(carry - '0' > 0){
            sum = "1" + sum;
        }
        
        return sum;
    }
}