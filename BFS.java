import java.util.*;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public List<String> breadthFirstSearch(List<String> array) {
			Queue<Node> q = new LinkedList<Node>();
			q.offer(this);
			
			while(!q.isEmpty()){
				Node popped = q.poll();
				array.add(popped.name);
				for(Node child: popped.children){
					q.offer(child);
				}
			}
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
