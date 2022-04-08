import java.util.*;

class Program {
  public static LinkedList findLoop(LinkedList head) {
		LinkedList slow = head;
		LinkedList fast = head;
		
		do{
			slow= slow.next;
			fast = fast.next.next;
		}while(slow != fast);
		
		// we have found the loop
		// move slow back to head and keep fast to collision point
		slow = head;
		
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		
    return slow;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
