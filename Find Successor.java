import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

	BinaryTree toFind;
	BinaryTree result= null;
	boolean found = false;
  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		toFind = node;
		inOrderTraversal(tree);
    return result;
  }
	
	private void inOrderTraversal(BinaryTree root){
		if(root == null){
			return;
		}
		
		inOrderTraversal(root.left);
		if(found){
			result = root;
			found = false;
		}
		if(toFind.value == root.value){
			found = true;
		}
		inOrderTraversal(root.right);
	}
}
