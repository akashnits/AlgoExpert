import java.util.*;

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
		if(head == null)
			return null;
		LinkedList prev = null;
		LinkedList curr = head;
		LinkedList next = head.next;
		while(curr != null){
			curr.next = prev;
			prev = curr;
			curr = next;
			if(curr != null){
				next = curr.next;
			}
		}
    return prev;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
