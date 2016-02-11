public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return generateSubset(S, S.length - 1);
    }
    
    public ArrayList<ArrayList<Integer>> generateSubset(int[] S, int index){
        ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        // {{}, {1}}
        if(index == 0){
        	
        	ArrayList<Integer> temp = new ArrayList<Integer>();
            alist.add(temp);
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
        	temp2.add(S[0]);
            alist.add(temp2);
            return alist;
           
        }else{
            ArrayList<ArrayList<Integer>> prev = generateSubset(S, index - 1);
            ArrayList<ArrayList<Integer>> prev2 = generateSubset(S, index - 1);
            alist.addAll(prev);
            for(ArrayList<Integer> arr : prev2){
                arr.add(S[index]);
            }
            alist.addAll(prev2);
            return alist;
        }
    }
}