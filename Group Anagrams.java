import java.util.*;

class Program {
  public static List<List<String>> groupAnagrams(List<String> words) {
		// create a map of frequencyArray : words
		Map<String, List<String>> map = new HashMap();
		
		for(String word: words){
			// create a frequency array
			int[] freq = new int[26];
			for(char c: word.toCharArray()){
				// build a frequency array for this word
				freq[c-'a'] += 1; 
			}
			
			// convert this frequency array to string
			StringBuilder sb = new StringBuilder();
			for(int val: freq){
				sb.append(String.valueOf(val));
			}
			String key = sb.toString();
			
			// check if this key exists in map
			if(!map.containsKey(key)){
				List<String> list = new ArrayList();
				map.put(key, list);
			}
			
			map.get(key).add(word);
		}
    return new ArrayList(map.values());
  }
}
