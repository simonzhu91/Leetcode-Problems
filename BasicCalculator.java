public class BasicCalculator {
    public int calculate(String s) {
       
       Stack<Integer> stk = new Stack<Integer>();
       int val = 0, sign = 1;
       for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
               int t = s.charAt(i) - '0';
               
               while(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
                   t = t * 10 + s.charAt(i+1) - '0';
                   i++;
               }
               
               val += t * sign;
           }
           
           else if(s.charAt(i) == '-'){
               sign = -1;
           }
           else if(s.charAt(i) == '+'){
               sign = 1;
           }
           else if(s.charAt(i) == '('){
               stk.push(val);
               stk.push(sign);
               val = 0;
               sign = 1;
           }
           else if(s.charAt(i) == ')'){
               val = val * stk.pop() + stk.pop();
           }
       }
       
       return val;
    }
}