import java.util.*;
import java.util.stream.Collectors;

class Program {
  public static String shortenPath(String path) {
		if(path.equals("/")){
			return "/";
		}
		String delimiter = "/";
		String[] tokens = path.split(delimiter);
		List<String> tokenList = Arrays.asList(tokens);
		
		boolean hasLeadingSlash = tokenList.get(0).equals("");
		
		// remove empty string and single dot
		List<String> filtered = 
			tokenList.stream().filter(str -> !str.equals("."))
			.filter(str -> !str.equals(""))
			.collect(Collectors.toList());
		
		// remove .. and the value previous to it
		List<String> stack = new ArrayList<String>();
		if(hasLeadingSlash) stack.add("");
		for(String token: filtered){
			if(token.equals("..")){
				if(stack.size() == 0 || stack.get(stack.size()-1).equals("..")){
					stack.add(token);
				}else if(!stack.get(stack.size()-1).equals("")){
					stack.remove(stack.size()-1);
				}
			}else{
				stack.add(token);
			}
		}
		
		if(stack.size() == 1 && stack.get(0).equals("")) return "/";
    return  String.join(delimiter, stack);
  }
}

