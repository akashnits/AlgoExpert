import java.util.*;

class Program {

  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Write your code here.
		
		Arrays.sort(intervals, (a, b) -> a[0]- b[0]);
        List<int[]> result= new ArrayList();
        result.add(intervals[0]);
        for(int i=1; i < intervals.length; i++){
            int[] interval= intervals[i];
            
            int[] lastInterval= result.get(result.size()-1);
            //merge if incoming interval's start element is less/equal end element of result
            if(interval[0] <= lastInterval[1]){
                //merge
                int update= Math.max(lastInterval[1], interval[1]);
                lastInterval[1]= update;
                
            }else{
                //append to list
                result.add(interval);
            }
        }

    return result.toArray(new int[result.size()][]);
  }
}
