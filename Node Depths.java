import java.util.*;

class Program {

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
		
    return solve(root, 0);
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
	
	private static int solve(BinaryTree root, int depth){
		if(root == null)
			return 0;
		
		// traverse the tree
		return depth + solve(root.left, depth +1) + solve(root.right, depth +1);
	}
}
