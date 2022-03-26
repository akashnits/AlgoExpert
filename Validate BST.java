import java.util.*;

class Program {
  public static boolean validateBst(BST tree) {
    // Write your code here.
		return isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
	
	private static boolean isBST(BST tree, int start, int end){
		if(tree == null)
			return true;
		
		if( tree.value < start || tree.value >= end ){
			return false;
		}
		
		return isBST(tree.left, start, tree.value) && isBST(tree.right, tree.value, end);
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
