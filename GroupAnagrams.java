public class GroupAnagrams {
    
    /* Idea: Looking for all groups of strings who are anagrams.
    
    Idea 1:
    Sort the characters in each string and then use compareTo to compare all pairs of strings 
    You can use Arrays.sort on a string by 1st converting the string to a character array
    
    use .toCharArray() on string
    
    Idea 2:
    Sort the characters in each string and add sorted string to a hash map, mapped to the frequency that it occurs
    Scan the keys of the HashMap and return all the keys that have a occurence of 2 or more
    */
    
     public ArrayList<String> anagrams(String[] strs) {
        
        ArrayList<String> toRet = new ArrayList<String>();

        // maps the sorted string to the number of occurences
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        // maps the sorted string to its original strings
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(int i = 0; i < strs.length; i++){

            char [] tmp = strs[i].toCharArray();
            // converts the character array
           Arrays.sort(tmp) ;
           
           String toAdd = new String(tmp);

           if(map.containsKey(toAdd)){
                map.get(toAdd).add(strs[i]);
           }else{
                ArrayList<String> h = new ArrayList<String>();
                h.add(strs[i]);
                map.put(toAdd, h);
           }

           if(result.containsKey(toAdd)){
               result.put(toAdd, result.get(toAdd) + 1);
           }else{
                result.put(toAdd, 1);
           }
        }

        // s is the sorted strings that we stored in result
       for(String s : result.keySet()){
           if(result.get(s) >= 2){
                for(String val : map.get(s))
                    toRet.add(val);
           }
       }

       
        return toRet;
    }
}