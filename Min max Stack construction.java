import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
	
  static class MinMaxStack {
		Stack<Integer> stack = new Stack();
		Stack<Integer> minStack = new Stack();
		Stack<Integer> maxStack = new Stack();
		
    public int peek() {
      return stack.isEmpty() ? -1: stack.peek();
    }

    public int pop() {
			if(stack.isEmpty()){
				return -1;
			}
			int popped = stack.pop();
			if(popped == minStack.peek()){
				minStack.pop();
			}
			
			if(popped == maxStack.peek()){
				maxStack.pop();
			}
      return popped;
    }

    public void push(Integer number) {
			stack.push(number);
			if(minStack.isEmpty() || number <= minStack.peek()){
				minStack.push(number);
			}
			
			if(maxStack.isEmpty() || number >= maxStack.peek()){
				maxStack.push(number);
			}
    }

    public int getMin() {
      return minStack.isEmpty()? Integer.MIN_VALUE: minStack.peek();
    }

    public int getMax() {
      return maxStack.isEmpty()? Integer.MAX_VALUE: maxStack.peek();
    }
  }
}
