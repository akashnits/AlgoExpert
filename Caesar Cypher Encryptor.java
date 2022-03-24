import java.util.*;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
		StringBuilder sb = new StringBuilder();
		int normalizedKey = key % 26;
		for(int i=0; i < str.length(); i++){
			int ascii;
			char c = str.charAt(i);
			ascii = (int) c + normalizedKey;
			if(ascii <= 122){
				c = (char) ascii;
			}else{
				c = (char) (96+ (ascii - 122));
			}
			sb.append(c);
		}
    return sb.toString();
  }
}
