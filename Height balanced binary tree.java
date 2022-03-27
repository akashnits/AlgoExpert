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
	
	boolean result= true;

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
		height(tree);
    return result;
  }
	
	public int height(BinaryTree root){
        
        //base condition
        if(root == null || !result)
            return -1;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh - rh ) > 1){
           result = false; 
        }
        
        return 1 + Math.max(lh, rh);
    }
}
