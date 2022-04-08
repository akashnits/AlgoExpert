import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
		LinkedList itr1= headOne;
		LinkedList itr2 = headTwo;
		LinkedList toReturn = new LinkedList(0);
		LinkedList result = toReturn;
		
		while(itr1 != null && itr2 != null){
			if(itr1.value >= itr2.value){
				// we take itr2
				result.next = itr2;
				itr2= itr2.next;
				result = result.next;
				result.next = null;
			}else{
				// we take itr1
				result.next = itr1;
				itr1= itr1.next;
				result = result.next;
				result.next = null;
			}
		}
		
		if(itr1 != null){
			result.next = itr1;
		}
		
		if(itr2 != null){
			result.next = itr2;
		}
    return toReturn.next;
  }
}
