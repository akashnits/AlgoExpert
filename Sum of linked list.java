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

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
	
		 //add both the lists
		LinkedList itr1= linkedListOne;
		LinkedList itr2= linkedListTwo;
		LinkedList result= new LinkedList(Integer.MIN_VALUE);
		LinkedList currentNode= null;
		LinkedList prev= result;
		int carry= 0;
		int nodeValue= 0;
		
		while(itr1 != null || itr2 != null){
			int a=0;
			int b=0;
			if(itr1 != null){
				a= itr1.value;
				itr1= itr1.next;
			}
			if(itr2 != null){
				b= itr2.value;
				itr2= itr2.next;
			}
			
			nodeValue= (a + b+ carry) % 10 ;
			carry = (a + b + carry) /10;
			
				currentNode= new LinkedList(nodeValue);
				prev.next= currentNode;
				prev= currentNode;
			
		} 
        if(carry == 1){
            currentNode= new LinkedList(carry);
			prev.next= currentNode;
        }
				
    return result.next;
  }
}
