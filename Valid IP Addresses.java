import java.util.*;

class Program {

  public ArrayList<String> validIPAddresses(String string) {
		ArrayList<String> result = new ArrayList();
		for(int i=1; i <= Math.min( string.length(), 3); i++){
			String part1 = string.substring(0,i);
			if(!validPart(part1)){
				continue;
			}
			
			for(int j=i; j <= Math.min(string.length(), i+3); j++){
				String part2 = string.substring(i, j);
				if(!validPart(part2)){
					continue;
				}
				
				for(int k=j; k <= Math.min(string.length(), j+3); k++){
					String part3 = string.substring(j, k);
					if(!validPart(part3)){
						continue;
					}
					
					String part4 = string.substring(k, string.length());
					if(!validPart(part4)){
						continue;
					}
					
					// all parts are valid
					String ip = part1+"."+part2+"."+part3+"."+part4;
					result.add(ip);
					System.out.println(ip);
				}
			}
		}
    return result;
  }
	
	private boolean validPart(String part){
		if(part.isEmpty()){
			return false;
		}
		
		int value = Integer.parseInt(part);
		if(value > 255){
			return false;
		}
		
		return part.length() == String.valueOf(value).length(); // check leading zero
	}
}
