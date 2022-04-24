import java.util.*;

class Program {
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public boolean linkedListPalindrome(LinkedList head) {
		LinkedList slow = head;
		LinkedList fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkedList last = reverseHalf(slow, null);
		LinkedList first= head;
		// compare now
		while(last != null){
			if(first.value != last.value){
				return false;
			}
			last = last.next;
			first = first.next;
		}
    return true;
  }
	
	public LinkedList reverseHalf(LinkedList head, LinkedList prev){
		LinkedList curr= head;
		LinkedList next;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
}
