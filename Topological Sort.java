import java.util.*;

class Program {
	static ArrayList<ArrayList<Integer>> graph;
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    // create a graph
		graph = new ArrayList();
		for(int job: jobs){
			graph.add(new ArrayList());
		}
		
		// add edges
		for(Integer[] edge: deps){
			graph.get(edge[0]-1).add(edge[1]-1);
		}
		
		// create indegree array
		int[] indegree = new int[jobs.size()];
		for(List<Integer> row: graph){
			for(int v: row){
				indegree[v]++;
			}
		}
		
		return topologicalSort(indegree);
  }
	
	// using Kahn's algorithm - BFS from leaves to inwards
	private static List<Integer> topologicalSort(int[] indegree){
		Queue<Integer> q = new LinkedList();
		// add all leaves to queue
		for(int i=0; i < indegree.length; i++){
			if(indegree[i] == 0){
				//leaf
				q.offer(i);
			}
		}
		
		List<Integer> result = new ArrayList();
		
		while(!q.isEmpty()){
			int processed= q.poll();
			result.add(processed+1);
			for(int neighbor: graph.get(processed)){
				if(--indegree[neighbor] == 0){
					q.offer(neighbor);
				}
			}
		}
		
		// if number of processed vertices != total number of vertices, graph isn't DAG
		if( indegree.length != result.size()){
			return new ArrayList();
		}else{
			return result;
		}
		
	}
}
