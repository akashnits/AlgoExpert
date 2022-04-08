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

// recursive approach

import java.util.*;

class Program {
	static LinkedList result;
  public static LinkedList reverseLinkedList(LinkedList head) {
		
		reverse(null, head);
    return result;
  }
	
	private static void reverse(LinkedList prev, LinkedList curr){
		if(curr == null){
			result = prev;
			return;
		}
		
		LinkedList next = curr.next;
		curr.next = prev;
		reverse(curr, next);
	}

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

