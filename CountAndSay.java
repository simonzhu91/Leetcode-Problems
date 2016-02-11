public class CountAndSay {
    /* Idea: for loop from 1 to n, and calculate the next step for each */
    
      public String countAndSay(int n) {
       
       // base case
       if(n == 1)
            return "1";
            
       int occurence;
       int val;
       int i = 0;
       String expr = "1";
       String next = "";
       
       for(int a = 1; a < n; a++){
           
           i = 0;
           while(i < expr.length()){
               val = Character.getNumericValue(expr.charAt(i));
               occurence = 0;
               
               // keep incrementing for all duplicates
               while(i != expr.length() && Character.getNumericValue(expr.charAt(i)) == val){
                   i++;
                   occurence++;
               }
               
               next += "" + occurence + val;
            }

            expr = next;
            next = "";

       }
       
       return expr;
       
    }
    
    
    
    
    // from string to int, call atoi(String)
    // from int to string, call String.valueOf(int)
}