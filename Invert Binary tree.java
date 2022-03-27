import java.util.*;

class Program {
  public static void invertBinaryTree(BinaryTree root) {
    // Write your code here.
		
		if(root == null){
			return;
		}
		
		// decide 
		// swap left and right trees
		BinaryTree temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		// recurse on your decision
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
		return;
		
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
