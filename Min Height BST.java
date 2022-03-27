import java.util.*;

class Program {
  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
		
    return constructBST(array, 0, array.size()-1);
  }
	
	private static BST constructBST(List<Integer> array, int l, int r){
		if(l > r){
			return null;
		}
		
		int mid = l + (r-l)/2;
		BST root = new BST(array.get(mid));
		root.left = constructBST(array, l, mid-1);
		root.right = constructBST(array, mid+1, r);
		
		return root;
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
