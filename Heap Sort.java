import java.util.*;

class Program {
  public static int[] heapSort(int[] array) {
		buildHeap(array);
		heapSortHelper(array, 0, array.length-1);
    return array;
  }
	
	private static void buildHeap(int[] array){
		int firstParentIdx = (array.length-2)/2;
		for(int currIdx = firstParentIdx; currIdx >=0; currIdx--){
			siftDown(array, currIdx, array.length-1);
		}
	}
	
	private static void heapSortHelper(int[] array, int start, int end){
		if(start >= end){
			return;
		}
		
		// last index with first
		swap(array, start, end);
		siftDown(array, start, end-1);
		heapSortHelper(array, start, end-1);
	}
	
	private static void siftDown(int[] array, int curr, int end){
		while( curr*2 +1 <= end){
			int left = curr*2 +1;
			int right = left+1;
			int swapIndex = -1;
			if(right > end || array[left] >= array[right]){
				swapIndex = left;
			}else{
				swapIndex = right;
			}
			if(array[curr] < array[swapIndex]){
				swap(array, curr, swapIndex);
				curr= swapIndex;
			}else{
				return;
			} 
		}
	}
	
	private static void swap(int[] heap, int idx1, int idx2){
			int temp = heap[idx1];
			heap[idx1]= heap[idx2];
			heap[idx2]= temp;
		}
}
