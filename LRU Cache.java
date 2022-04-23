import java.util.*;

// Do not edit the class below except for the insertKeyValuePair,
// getValueFromKey, and getMostRecentKey methods. Feel free
// to add new properties and methods to the class.
class Program {
  static class LRUCache {
    int maxSize;
		Map<String, DListNode> cache;
		DListNode tail;
		DListNode head;
		int size;

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
			cache = new HashMap();
			size = 0;
			head = new DListNode();
			tail = new DListNode();
			head.next = tail;
			tail.prev = head;
    }

    public void insertKeyValuePair(String key, int value) {
      // two cases - either update or add
			// case 1: add a new node - we add this close to the head
			DListNode node = cache.get(key);
			if( node == null ){ 
				// cache doesn't contain this, we add a new node else update existing node
				DListNode newNode = new DListNode();
				newNode.val = value;
				newNode.key = key;
				
				//add to doubly linked list
				addNodeAtFront(newNode);
				
				// put it in the cache
				cache.put(key, newNode);
				size++;
				// now that we have added the node, we need to check if size of LRU exceeds capacity
				if(size > maxSize){
					// we need to evict least recently used node, i.e. evict node from the back of queue 
					DListNode removeNode = tail.prev;
					// remove from doubly linked list
					removeNode(removeNode);
					// remove from cache
					cache.remove(removeNode.key);
					size--;
				}
			}else{
				// update node
				node.val = value;
				// move this closer to head
				moveToHead(node);
			}
    }

    public LRUResult getValueFromKey(String key) {
			DListNode node = cache.get(key);
			if(node == null){
				return null;
			}
			// move node to head before returning value
			
			moveToHead(node);
			
      return new LRUResult(true, node.val);
    }

    public String getMostRecentKey() {
			// check if list isn't empty
			if(head.next != tail){
				DListNode node = head.next;
				return node.key;
			}
      return null;
    }
		
		public void addNodeAtFront(DListNode node){
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	public void removeNode(DListNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public void moveToHead(DListNode node){
		removeNode(node);
		addNodeAtFront(node);
	}
  }

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }
	
	static class DListNode {
		int val;
		String key;
		DListNode next;
		DListNode prev;
		
		DListNode(){
			
		}
	}
}
