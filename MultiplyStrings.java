public class MultiplyStrings {
     public String sumString(String a, String b){
        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;

        int longer_length = longer.length();
        int shorter_length = shorter.length();
        
        // padding
        for(int i = 0; i < longer_length - shorter_length; i++){
            shorter = "0" + shorter;
        }

        int sum = 0;
        int carry = 0;
        String result = "";

        for(int i = longer.length() - 1; i >=0; i--){
            int a_val = longer.charAt(i) - '0';
            int b_val = shorter.charAt(i) - '0';

            sum = (a_val + b_val + carry) % 10;
            carry = (a_val + b_val + carry) / 10;

            result = sum + result;
        }

        if(carry != 0){
            result = "1" + result;
        }
        
         // removes 0's at the beginning of the string
        while(result.charAt(0) == '0' && result.length() != 1){
            result = result.substring(1);
        }

        return result;

    }

    public String sum(String [] arr){
        String res = "";


        for(int i = 0; i < arr.length; i++){
            res = sumString(res, arr[i]);
        }

        return res;
    }

    public String multiply(String num1, String num2) {
        String larger = num1.length() < num2.length() ? num2 : num1;
        String smaller = num1.length() < num2.length() ? num1 : num2;
        
        String [] arr = new String[smaller.length()];
        int carry = 0;
        String product = "";
        int count = 0;
        String result = "";
        
        for(int i=smaller.length()-1; i>=0; i--){
            int s_digit = smaller.charAt(i) - '0';
            
            for(int j=larger.length()-1; j>=0; j--){
                int l_digit = larger.charAt(j) - '0';
                product = ((s_digit * l_digit + carry) % 10) + product;
                carry = (s_digit * l_digit + carry) / 10;

                // if(i == 0){
                //     // System.out.println("Sum: " + product);

                // }
            }
            
            
            // Appends carry to the end
            if(carry != 0)
                product = carry + product;

            // if(i == 0){
            //     // System.out.println(carry);
            //     // System.out.println("Sum: " + product);
            // }

            carry = 0;
            arr[count] = "" + product;

            for(int t=0; t<count;t++){
                arr[count] += "0";
            }

            // System.out.println("Product: " + product);
            // System.out.println(arr[count]);

            product = "";
            count++;
        }
        result = sum(arr);
        
        return "" + result;
        
    }
}