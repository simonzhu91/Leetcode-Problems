public class GenerateParenthesis {
   public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> toRet = new ArrayList<String>();
        char [] c = new char[n * 2];
		
		helper(n, n, c, toRet, 0);   
        return toRet;
	}
	
	public void helper(int left, int right, char[] exp, ArrayList<String> toRet, int index){
		if(left == 0 && right == 0){
			toRet.add(new String(exp));
		}
		else{
			if(right >= left){
				if (left > 0) {
					exp[index] = '(';
					helper(left - 1, right, exp, toRet, index + 1);
				}

				if (right > 0) {
					exp[index] = ')';
					helper(left, right - 1, exp, toRet, index + 1);
				}
			}
		}
	}
}