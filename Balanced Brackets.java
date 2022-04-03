import java.util.*;

class Program {
  public static boolean balancedBrackets(String str) {
		char[] charArray = str.toCharArray();
    Stack<Character> stack = new Stack();
        for(char c: charArray){
            switch(c){
                case '(' : 
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
								case '}':
							  case ']':
									if(stack.isEmpty() || stack.pop() != c) return false; 
							default: continue;
            }
        }
        return stack.isEmpty();
  }
}
