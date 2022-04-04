import java.util.*;

class Program {

  public char[] minimumCharactersForWords(String[] words) {
    Map<Character, Integer> resultMap = new HashMap();
		for(String word: words){
			Map<Character, Integer> freqMap = new HashMap();
			for(char c: word.toCharArray()){
				freqMap.put(c, freqMap.getOrDefault(c,0)+1);
				if(!resultMap.containsKey(c)){
					resultMap.put(c, 1);
				}else{
					// only increase if required
					if(freqMap.get(c) > resultMap.get(c)){
						resultMap.put(c, resultMap.get(c)+1);
					}
				}
			}
		}
		List<Character> result = new ArrayList();
		for(Map.Entry<Character, Integer> entry: resultMap.entrySet()){
			int freq = entry.getValue();
			char c = entry.getKey();
			while(freq-- > 0){
				result.add(c);
			}
		}
		
		char[] toReturn = new char[result.size()];
		
		for(int i=0; i < result.size(); i++){
			toReturn[i] = result.get(i);
		}
		
    return toReturn;
  }
}
