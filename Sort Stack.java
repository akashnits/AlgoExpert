import java.util.*;

class Program {

  public ArrayList<Integer> sortStack(ArrayList<Integer> list) {
		ArrayList<Integer> result = new ArrayList();
		if(list.size() == 0){
			return result;
		}
    Stack<Integer> stack = new Stack();
		for(int value: list){
			stack.push(value);
		}
		
		Stack sorted_stack = sort_stack(stack);
		while(!stack.isEmpty()){
			result.add((int)stack.pop());
		}
    return result;
  }
	
	// returns sorted stack
	private Stack sort_stack(Stack<Integer> stack){
		if(stack.size() == 1){
			return stack; // stack size of 1 is sorted
		}
		
		int val = (int) stack.pop(); // we make the input smaller and recurse over it
		Stack sorted_stack = sort_stack(stack);
		return insert(sorted_stack, val);
	}
	
	private Stack insert(Stack<Integer> sorted_stack, int value){
		// base condition
		if(sorted_stack.size() == 0 || (value <= (int) sorted_stack.peek())){
			// we push the value and return the stack
			sorted_stack.push(value);
			return sorted_stack;
		}
		
		int popped = sorted_stack.pop(); // we make input smaller and recurse over it
		sorted_stack = insert(sorted_stack, value);
		sorted_stack.push(popped); // push the popped value back
		return sorted_stack;
	}
}
