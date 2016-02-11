public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int total = 0;
        int val = 0;
        
        for(int i = 0; i < s.length(); i++){
            total *= 26;
            val = s.charAt(i) - 'A' + 1;
            total += val;
        }
        
        return total;
    }
}