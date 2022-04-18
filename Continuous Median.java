import java.util.*;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
  static class ContinuousMedianHandler {
		PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count = 0;
    double median = 0;

		ContinuousMedianHandler() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
    }
		
    public void insert(int num) {
      count++;
        // step 1: decide base on size
        if(minHeap.size() < maxHeap.size()){
            // add to min heap
            minHeap.add(num);
        }else{
            // add to max heap
            maxHeap.add(num);
        }
        
        // step 2: rebalance
        rebalance(minHeap, maxHeap);
    }

    public double getMedian() {
			if(count == 0){
            return 0;
        }
        double median; 
        if(count % 2 == 0){
            median = (minHeap.peek() + maxHeap.peek()) /2.0;
        }else{
            median= maxHeap.peek();
        }
        return median;
    }
		
		private void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        
        if(minHeap.size() == 0 || maxHeap.size() == 0){
            return;
        }
       // compare minHeap and maxHeap top
        if(minHeap.peek() < maxHeap.peek()){
            int min = minHeap.poll();
            int max = maxHeap.poll();
            minHeap.add(max);
            maxHeap.add(min);
        }
    }
  }
}
