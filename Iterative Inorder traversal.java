import java.util.function.Function;
import java.util.*;

class Program {
  public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {
      Stack<BinaryTree> stack = new Stack<BinaryTree>();
			BinaryTree curr = tree;
		
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = (BinaryTree) stack.pop();
            callback.apply(curr);
            curr = curr.right;
        }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}
