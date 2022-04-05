import java.util.*;

class Program {
  // Do not edit the class below except for the
  // populateSuffixTrieFrom and contains methods.
  // Feel free to add new properties and methods
  // to the class.
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      // find suffix
			int n = str.length();
			// iterate over suffixes
			for(int i=0; i <n; i++){
				String suffix = str.substring(i);
				pushSuffix(suffix);
			}
    }
		
		private void pushSuffix(String suffix){
			// iterate over characters in suffix
			TrieNode prevNode = root;
			for(char c: suffix.toCharArray()){
				if(prevNode.children.containsKey(c)){
					prevNode = prevNode.children.get(c);
				}else{
					Map<Character, TrieNode> map = prevNode.children;
					map.put(c, new TrieNode());
					prevNode = prevNode.children.get(c);
				}
			}
			
			prevNode.children.put(endSymbol, null);
		}

    public boolean contains(String str) {
			TrieNode node = root;
			for(char c: str.toCharArray()){
				// search in children - hashmap
				Map<Character, TrieNode> map = node.children;
				if(map.containsKey(c)){
					node = node.children.get(c);
				}else{
					return false;
				}
			}
			
			// check that last children is endSymbol
      return node.children.containsKey(endSymbol);
    }
  }
}
