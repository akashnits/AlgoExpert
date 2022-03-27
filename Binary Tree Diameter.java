import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int binaryTreeDiameter(BinaryTree tree) {
		height(tree);
    return result;
  }
	int result = -1;
	
	private int height(BinaryTree root){
		
		if(root == null){
			return 0;
		}
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		int diameter = lh + rh;
		result = Math.max(diameter, result);
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
