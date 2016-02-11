public class ValidNumber {
    public boolean isNumber(String s) {
        if(s == null)
            return false;
        
        s = s.trim();
        
        if(s.length() == 0)
            return false;
            
        return (
            // decimal values with a digit on either side of "."
            // not floats
            s.matches("[+-]?[0-9]*[.]?[0-9]+") 
            || s.matches("[+-]?[0-9]+[.]?[0-9]*") 
            
            // floating point values with or without e
            || s.matches("[+-]?[0-9]+[.]?[0-9]*[eE][+-]?[0-9]+[f]?")
            || s.matches("[+-]?[0-9]*[.]?[0-9]+[eE][+-]?[0-9]+[f]?")
        );
    }
}