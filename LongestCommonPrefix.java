public class LongestCommonPrefix {
    /* Find the longest common prefix in an array of strings
    ["Pokemon", "Poket", "Pokets", "Pokey", "Poke Her Please"]
    
        Idea: Have pointer to an index to each of the Strings in the String array
        if the characters at each of the indicies are identical, we add that character to prefix and increment the index
        if not, then we return the prefix
    */
    
   public String longestCommonPrefix(String[] arrs){
    if(arrs.length == 0)
      return "";
    
    int shortest = Integer.MAX_VALUE;
    for(int i = 0; i < arrs.length; i++){
      if(shortest > arrs[i].length()){
        shortest = arrs[i].length();
      }
    }
    
    // String s = "";
    int index = 0;
    while(index < shortest){
      for(int i = 0; i < arrs.length - 1; i++){
        if(arrs[i].charAt(index) != arrs[i+1].charAt(index)){
          return arrs[0].substring(0, index);
        }
      }
      index++;
    }
    return arrs[0].substring(0, index);
    
  }
    
    
}