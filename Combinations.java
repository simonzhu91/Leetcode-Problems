public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

		ArrayList<Integer> alist = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> toRet = new ArrayList<ArrayList<Integer>>();

		if(k > n)
			return toRet;

		  helper(n, k, 0, toRet, alist);

		  return toRet;
    }

    public void helper(int n, int k, int prev, ArrayList<ArrayList<Integer>>alist, ArrayList<Integer> toAdd){
    	if(toAdd.size() == k){
    		ArrayList<Integer> temp = new ArrayList<Integer>();

    		for(int i = 0; i < toAdd.size(); i++)
    			temp.add(toAdd.get(i));

    		// adds a deep copy
    		alist.add(temp);
    		return;
    	}

    	for(int i = prev + 1; i <= n; i++){
    		toAdd.add(i);
    		helper(n, k, i, alist, toAdd);
    		toAdd.remove(toAdd.size() - 1);
    	}
    }
}