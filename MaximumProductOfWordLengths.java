public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        // Every bit represents if the character has been used
        // Since there are 26 characters, we need 26 bits to represent this
        // We use an integer
        // We create an array of integers, one to represent bit for each string
        // To see if 2 strings have overlap characters, we AND the 2 integers together and compare with 0
        // if result is equal to 0, we are good
        // for duplicates, we only mark that character once
        
        // brute force:
        // we search for every possible pair of numbers
        // check if they have same characters
        // if not, we take product and compare with our max product so far
        // O(n^2) runtime
        
        int [] arr = new int[words.length];
        
        for(int i=0;i<words.length;i++){
            for(int j=0; j<words[i].length(); j++){
                int index = words[i].charAt(j) - 'a';
                arr[i] = arr[i] | (1 << index);
            }
        }
        
        int product = 0;
        
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((arr[i] & arr[j]) == 0){
                    if((words[j].length() * words[i].length()) > product)
                        product = words[j].length() * words[i].length();
                }
            }
        }
        
        return product;
    }
}