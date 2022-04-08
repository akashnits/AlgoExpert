import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
			// we heapify in reverse order: starting at rightmost leaf's parent
			// decrementing and going till root
			int n = array.size();
			int lastIndex = n-1;
			int firstParentIdx = ((lastIndex)-1)/2;
			for( int currIdx= firstParentIdx; currIdx >=0; currIdx--){
				siftDown(currIdx, n-1, array);
			}
			return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      while( 2*currentIdx +1 <= endIdx){
				int lChild = 2* currentIdx +1;
				int rChild = lChild+1;
				
				int swapIdx = -1;
				// check if right child exist
				if(rChild > endIdx || heap.get(lChild) <= heap.get(rChild)){
						swapIdx = lChild;
				} else{
						swapIdx = rChild;
				}
				if(heap.get(swapIdx) < heap.get(currentIdx)){
					swap(heap, currentIdx, swapIdx);
					currentIdx = swapIdx;
				}else{
					return;
				}
			}
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      while(currentIdx > 0){
				// find parent node
				int parentIdx = (currentIdx -1)/2;
				if(heap.get(parentIdx) > heap.get(currentIdx)){
					swap(heap, currentIdx, parentIdx);
					currentIdx = parentIdx;
				}else{
					break;
				}
			}
    }

    public int peek() {
			int n = heap.size();
			if( n > 0){
				return heap.get(0);
			}
      return -1;
    }

    public int remove() {
			int n = heap.size();
			if(n > 0){
				swap(heap, 0, n-1);
				int removed = heap.get(n-1);
				heap.remove(n-1);
				siftDown(0, heap.size()-1, heap);
				return removed;
			}
			return -1;
    }

    public void insert(int value) {
      heap.add(value);
			siftUp(heap.size()-1, heap);
    }
		
		private void swap(List<Integer> heap, int idx1, int idx2){
			int temp = heap.get(idx1);
			heap.set(idx1, heap.get(idx2));
			heap.set(idx2, temp);
		}
  }
}
