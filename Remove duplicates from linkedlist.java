import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    // Write your code here.
		LinkedList result = linkedList;
		
		LinkedList currNode = linkedList;
		LinkedList nextNode = linkedList.next;
		
		while(nextNode != null){
			if(currNode.value == nextNode.value){
				nextNode = nextNode.next;
				currNode.next = nextNode;
				continue;
			}
			currNode = currNode.next;
			nextNode = nextNode.next;
		}
    return result;
  }
}
