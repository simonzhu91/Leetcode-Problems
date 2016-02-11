class TrieNode {
    
    public char c;
    public HashMap<Character, TrieNode> map;
    public boolean isLeaf;
    
    public TrieNode(){
        map = new HashMap<Character, TrieNode>();
    }
    
    // Initialize your data structure here.
    public TrieNode(char c) {
        this.c = c;
        map = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode n = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            if(n.map.containsKey(c)){
                n = n.map.get(c);
            }else{
                TrieNode node = new TrieNode(c);
                n.map.put(c, node);
                n = n.map.get(c);
            }
            
            if(i == word.length() - 1){
                n.isLeaf = true;
            }
        }
    }

   
    public TrieNode searchHelper(String word){
        TrieNode n = root;
        
        for(int i = 0; i < word.length(); i++){
            if(n.map.containsKey(word.charAt(i))){
                n = n.map.get(word.charAt(i));
            }else{
                return null;
            }
        }
        return n;
    }

    public boolean search(String word) {
      TrieNode n = searchHelper(word);
      
      if(n == null || !n.isLeaf){
          return false;
      }
      return true;
    }

    public boolean startsWith(String prefix) {
        return searchHelper(prefix) != null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");