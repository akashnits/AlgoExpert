import java.util.*;

class Program {
  public static int allKindsOfNodeDepths(BinaryTree root) {
		
    return depthSum(root, 0);
  }
	
	private static int depthSum(BinaryTree root, int depth){
		if(root == null)
			return 0;
		
		int depthSum = (depth * (depth+1))/2;
		return depthSum + depthSum(root.left, depth+1) + depthSum(root.right, depth+1);
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
}
