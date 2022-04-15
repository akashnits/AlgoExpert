import java.util.*;

class Program {
  public static String longestSubstringWithoutDuplication(String s) {
    		if(s.length() < 2){
            return s;
        }
				String result = "";
        int maxWindow = Integer.MIN_VALUE;
        Set<Character> set = new HashSet();
        int l=0;
        int r=0;
        set.add(s.charAt(0));
        while(r < s.length()-1){
            ++r;
            if(set.contains(s.charAt(r))){
                int length = r-l;
								if(length > maxWindow){
									maxWindow = length;
									result = s.substring(l,r);
								}
                //shrink
                while(s.charAt(l) != s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }else{
                set.add(s.charAt(r));
								int length = r-l+1;
                if(length > maxWindow){
									maxWindow = length;
									result = s.substring(l,r+1);
								}
            }
        }
        
        return result;
  }
}

