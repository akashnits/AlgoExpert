import java.util.*;

class Program {

  public boolean generateDocument(String characters, String document) {
    
		if(characters.length() < document.length()){
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArray = characters.toCharArray();
		// iterate over characters
		for(Character c : charArray){
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		// iterate over document
		char[] documentArray = document.toCharArray();
		for(Character d: documentArray){
			if(!map.containsKey(d) || map.get(d) == 0){
				return false;
			}
			map.put(d, map.get(d)-1);
		}
		
    return true;
  }
}
