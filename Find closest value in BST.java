import java.util.*;

class Program {
	static int closest = -1;
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		
		search(tree, target, Integer.MAX_VALUE);
    return closest;
  }
	
	static void search(BST root, int target, int minDiff){
		if(root == null){
			return;
		}
		
		if(Math.abs(root.value - target) < minDiff){
			closest = root.value;
			minDiff = Math.abs(root.value - target);
		}
		// make a choice to either go left/right
		if(target > root.value){
			// search right subtree
			search(root.right, target, minDiff);
		}else{
			// search left subtree
			search(root.left, target, minDiff);
		}
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
