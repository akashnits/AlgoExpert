import java.util.*;

class Program {
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
		// Create a sufix trie and search startsWith
		Trie trie = new Trie();
		for(int i=0; i < bigString.length(); i++){
			trie.insert(bigString.substring(i));
		}
		
		List<Boolean> result = new ArrayList();
		for(String word: smallStrings){
			result.add(trie.startsWith(word));
		}
    return result;
  }
	
	
	static class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i =0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
		public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(!node.containsKey(ch)){
                return false;
            }else{
                node = node.get(ch);
            }
        }
        return true;
    }
    
    static class TrieNode {
        
        Map<Character, TrieNode> children;
        char endSymbol = '#';
        
        TrieNode(){
            children = new HashMap();
        }
        
        public boolean containsKey(char ch){
            return children.containsKey(ch);
        }
        
        public TrieNode get(char ch){
            return children.get(ch);
        }
        
        public void put(char ch, TrieNode trieNode){
            children.put(ch, trieNode);
        }
        
        public void setEnd(){
            children.put(endSymbol, null);
        }
        
        public boolean isEnd(){
            return children.containsKey(endSymbol);
        }
    }
	}
}
