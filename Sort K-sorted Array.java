import java.util.*;
import java.util.stream.Collectors;

class Program {

  public int[] sortKSortedArray(int[] array, int k) {
		int n = array.length;
		// create a sub-list of k+1 elements and heapify
		int endIdx = Math.min(k, n-1); 
		int[] subArray = Arrays.copyOfRange(array, 0, endIdx+1);
		List<Integer> list = Arrays.stream(subArray)
      												 .boxed()
      												 .collect(Collectors.toList());
		List<Integer> heap = heapify(list);
		
		int sortedIdx=0;
		// loop to insert the element at k+1 element
		for(int i=k+1; i < n; i++){
			int min = remove(heap);
			array[sortedIdx] = min;
			sortedIdx++;
			insert(array[i], heap);
		}
		
		while(heap.size() != 0){
			int min = remove(heap);
			array[sortedIdx] = min;
			sortedIdx++;
		}
    return array;
  }
	
	private List<Integer> heapify(List<Integer> array){
		// construct min heap from given array
		int lastParentIdx = (array.size()-2)/2;
		for(int i = lastParentIdx; i >=0; i--){
			siftDown(array, i, array.size()-1);
		}
		return array;
	}
	
	private void siftDown(List<Integer> array, int currIdx, int endIdx){
		while(currIdx * 2 + 1 <= endIdx){
			int lChild = currIdx * 2 + 1;
			int rChild = lChild +1;
			int swapIdx = -1;
			
			if(rChild > endIdx || array.get(lChild) <= array.get(rChild)){
				// take left
				swapIdx = lChild;
			}else{
				// take right
				swapIdx = rChild;
			}
			
			// check if we can swap i.e. array[swapIndex] < array[currIdx]
			if(array.get(swapIdx) < array.get(currIdx)){
				swap(array, swapIdx, currIdx);
				currIdx = swapIdx;
			}else{
				return;
			}
		}
	}
	
	 	public int remove(List<Integer> heap) {
 			int n = heap.size();
 			if(n > 0){
 				swap(heap, 0, n-1);
 				int removed = heap.get(n-1);
 				heap.remove(n-1);
 				siftDown(heap, 0, heap.size()-1);
 				return removed;
 			}
 			return -1;
     }

  	public void insert(int value, List<Integer> heap) {
      heap.add(value);
 			siftUp(heap.size()-1, heap);
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
	
	
	
	private void swap(List<Integer> array, int idx1, int idx2){
		int temp = array.get(idx1);
		array.set(idx1, array.get(idx2));
		array.set(idx2, temp);
	}
}
