import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
    // Write your code here.
    return (isAncestor(nodeOne, nodeTwo) && isAncestor(nodeTwo, nodeThree) || 
					 isAncestor(nodeThree, nodeTwo) && isAncestor(nodeTwo, nodeOne));
  }
	
	private boolean isAncestor(BST ancestor, BST child){
		if(ancestor == null || child == null){
			return false;
		}
		if(ancestor.value == child.value){
			return true;
		}
		
		if(ancestor.value < child.value){
			return isAncestor(ancestor.right, child);
		}else{
			return isAncestor(ancestor.left, child);
		}
	}
}
