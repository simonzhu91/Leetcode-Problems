public class LetterCombinationsOfAPhoneNumber {
    HashMap<Character, TreeSet<Character>> map = new HashMap<Character, TreeSet<Character>>();

	public ArrayList<String> letterCombinations(String digits) {

        TreeSet<Character> set2 = new TreeSet<Character>();

	    set2.add('a');
	    set2.add('b');
	    set2.add('c');
	    
	    TreeSet<Character> set3 = new TreeSet<Character>();

	    set3.add('d');
	    set3.add('e');
	    set3.add('f');

	    TreeSet<Character> set4 = new TreeSet<Character>();

	    set4.add('g');
	    set4.add('h');
	    set4.add('i');

	    TreeSet<Character> set5 = new TreeSet<Character>();

	    set5.add('j');
	    set5.add('k');
	    set5.add('l');

	    TreeSet<Character> set6 = new TreeSet<Character>();

	    set6.add('m');
	    set6.add('n');
	    set6.add('o');

	    TreeSet<Character> set7 = new TreeSet<Character>();

	    set7.add('p');
	    set7.add('q');
	    set7.add('r');
	    set7.add('s');

	    TreeSet<Character> set8 = new TreeSet<Character>();

	    set8.add('t');
	    set8.add('u');
	    set8.add('v');

	    TreeSet<Character> set9 = new TreeSet<Character>();

	    set9.add('w');
	    set9.add('x');
	    set9.add('y');
	    set9.add('z');

	    // adds each set into the map
	    map.put('0', new TreeSet<Character>());
	    map.put('1', new TreeSet<Character>());
	    map.put('2', set2);
	    map.put('3', set3);
	    map.put('4', set4);
	    map.put('5', set5);
	    map.put('6', set6);
	    map.put('7', set7);
	    map.put('8', set8);
	    map.put('9', set9);

	    ArrayList<String> expr = new ArrayList<String>();
	    helper(digits, "", expr);

	    return expr;

    }

    public void helper(String digits, String toBuild, ArrayList<String> expr){

    	// base case if there are no more digits, then return expr
    	if(digits.equals("")){
    		expr.add(toBuild);
    	}

    	else{
	    		TreeSet<Character> set = map.get(digits.charAt(0));

	    		for(Character c : set){
	    			helper(digits.substring(1), toBuild + c, expr);
	    		}
	    	}
   		}

}