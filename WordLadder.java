public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int count = 1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int j = 0; j < size; j++){
                String word = queue.remove();
                
                if(word.equals(endWord)){
                    return count;
                }
                
                for(int i = 0; i < word.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c != word.charAt(i)){
                            char[] s = word.toCharArray();
                            s[i] = c;
                            String trans = new String(s);
                            
                            if(wordList.contains(trans)){
                                queue.add(trans);
                                wordList.remove(trans);
                            }
                        }
                    }
                }
            }
            
            count++;
        }
        
        return 0;
    }
}