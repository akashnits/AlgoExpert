import java.util.*;

class Program {
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
		
		flatten(root);
		
    return root;
  }
	
	public static void flatten(BinaryTree root) {
        if(root == null)
            return;
        
        
        flatten(root.left);
        //check if node have left child, if not, we don't need to flatten
        if(root.left != null){
            
            //detach right child and store in temp
            BinaryTree temp = root.right;
            
            //attach left child to right of root and make left child null
            root.right = root.left;
            root.left= null;
            
            //attach node stored in temp at the bottom-right of new right child
            BinaryTree right = root.right;
            while(right.right != null){
                right = right.right;
            }
            
            right.right = temp;
        }
        flatten(root.right);
        
    }

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
