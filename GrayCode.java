public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        
        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> prev = new ArrayList<Integer>();
        
        if(n == 0)
        {
            alist.add(0);
            return alist;
        }
        
        if(n == 1){
            alist.add(0);
            alist.add(1);
            return alist;
        }
        else{
            prev = grayCode(n-1);
            int mostSig = 1 << n - 1;
            
            // add all, adds all the contents of prev to alist
            alist.addAll(prev);
            
            for(int i = prev.size() - 1; i >= 0; i--){
                alist.add(prev.get(i) + mostSig);
            }
            
            return alist;
        }
    }
}