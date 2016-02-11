public class IntegerToRoman {
    
   public String []hundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    public String []tens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    public String []ones = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	     
	    public String intToRoman(int num) {
	        String toRet = "";
	        while(num >= 1000){
	            toRet += "M";
	            num -= 1000;
	        }
	        
	        for(int i = hundreds.length - 1; i >= 0; i--){
	            if(num >= 100 * (i+1)){
	                toRet += hundreds[i];
	                num -= 100 * (i+1);
	            }
	        }
	        
	         for(int i = tens.length - 1; i >= 0; i--){
	            if(num >= 10 * (i+1)){
	                toRet += tens[i];
	                num -= 10 * (i+1);
	            }
	        }
	        
	        for(int i = ones.length - 1; i >= 0; i--){
	            if(num >= 1 * (i+1)){
	                toRet += ones[i];
	                num -= 1 * (i+1);
	            }
	        }
	        
	        return toRet;
	        
	    }
}