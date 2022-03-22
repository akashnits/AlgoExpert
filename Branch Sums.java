import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
	
	static ArrayList<Integer> result;

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		result =  new ArrayList<Integer>();
		pathSum(root, 0);
    return result;
  }
	
	private static void pathSum(BinaryTree root, int sum){
		if(root == null){
			return;
		}
		
		if(isLeafNode(root)){
			// add to result and return
			result.add(sum+root.value);
			return;
		}
		
		// traverse the tree
		pathSum(root.left, sum+root.value);
		pathSum(root.right, sum+root.value);
	}
	
	private static boolean isLeafNode(BinaryTree root){
		return root.left == null && root.right == null;
	}
}
