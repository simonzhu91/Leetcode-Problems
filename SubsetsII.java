public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> temp = new ArrayList<Integer>();

    Arrays.sort(num);

    	return helper(num, num.length - 1);
    }

    /* Recursively call helper with 1 less element in the array 
	   When the array hits size 0, add an empty array to alist
	   For each of the other steps, store the results of the previous steps and for each make a copy and append another element to it
    */

    public ArrayList<ArrayList<Integer>> helper(int [] num, int index){
    	
    	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> t = new ArrayList<Integer>();

    	// base case
    	if(index == -1){
    		temp.add(t);
    		return temp;
    	}

    	else{
    		// recursive step!

    		// recursively call for 1 less element in the array
    		ArrayList<ArrayList<Integer>> results = helper(num, index-1);
    		int length = results.size();

    		for(int i = 0; i < length; i++){

    			ArrayList<Integer> t2 = new ArrayList<Integer>();

    			// copies all the elements over from the original arrayList into a deep copy
    			for(int a = 0; a < results.get(i).size(); a++){
    					t2.add(results.get(i).get(a));
    			}

    			// adds the missing element
    			t2.add(num[index]);

    			if(!results.contains(t2)){
    				// adds the new arrayList to the results
    				results.add(t2);
    			}
    		}

    		return results;
    	}
    }
}