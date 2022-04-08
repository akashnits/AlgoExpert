import java.util.*;

class Program {
	
	static LinkedList lastNode= null;
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
		
		int size = calculateSize(head);
		int newK = k % size;
		if(newK == 0){
			return head;
		}
		if(newK < 0){
			newK = size + newK;
		}
		int steps = size-newK-1;
		LinkedList node = head;
		while(steps-- > 0){
			node = node.next;
		}
		
		lastNode.next = head;
		head = node.next;
		node.next = null;
    return head;
  }
	
	private static int calculateSize(LinkedList curr){
		int count =0;
		while(curr != null){
			count++;
			lastNode = curr;
			curr= curr.next;
		}
		return count;
	}

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
