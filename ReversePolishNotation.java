public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<Integer>();
        
        for(String sym : tokens){
            if(isOperator(sym)){
                int operand_1 = operand.pop();
                int operand_2 = operand.pop();
                
                int result = 0;
            
                switch(sym){
                    case "+": result = operand_2 + operand_1; break;
                    case "*": result = operand_2 * operand_1; break;
                    case "/": result = operand_2 / operand_1; break;
                    case "-": result = operand_2 - operand_1; break;
                }
            
            operand.push(result);
                
            }else{
                operand.push(Integer.parseInt(sym));
            }
        }
        
        return operand.peek();
    }
    
    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
}