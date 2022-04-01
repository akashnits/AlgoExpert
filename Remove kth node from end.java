import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		
		int n =0;
		LinkedList node = head;
		while(node != null){
			n++;
			node = node.next;
		}
		
		int position = n - k+1; // position from start
		LinkedList nodeToRemove= head;
		
		LinkedList previous = null;
		while(--position > 0){
			previous= nodeToRemove;
			nodeToRemove = nodeToRemove.next;
		}
		
		LinkedList prev = previous;
		while(nodeToRemove.next != null){
			nodeToRemove.value = nodeToRemove.next.value;
			prev = nodeToRemove;
			nodeToRemove = nodeToRemove.next;
		}
		
		prev.next = null;
		
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
