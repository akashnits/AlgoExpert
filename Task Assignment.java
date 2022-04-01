import java.util.*;

class Program {

  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // value to index mapping
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int n = tasks.size();
		for(int i=0; i < n; i++){
			int value = tasks.get(i);
			List<Integer> list = map.getOrDefault(value, new ArrayList());
			list.add(i);
			map.put(value, list);
		}
		
		// sort the tasks array
		Collections.sort(tasks);
		
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		// use two pointers - start and end to iterate through 
		int start = 0;
		int end = n-1;
		while(start < end){
			System.out.println("called");
			ArrayList<Integer> taskList = new ArrayList();
			int task1 = tasks.get(start++);
			int task2 = tasks.get(end--);
			
			// find index of task1 and task2
			List<Integer> list1 = map.get(task1);
			int index1= list1.get(0);
			
			List<Integer> list2 = map.get(task2);
			int index2 = list2.get(0);
			
			result.add(new ArrayList<Integer>(Arrays.asList(index1, index2)));
			// remove index from list stored in map
			list1.remove(0);
			list2.remove(0);
		}
		
    return result;
  }
}
