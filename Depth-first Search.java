import java.util.*;

class Program {
  // Do not edit the class below except
  // for the depthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

		
		public List<String> depthFirstSearch(List<String> array) {
      // Write your code here.
			DFS(array, this);
      return array;
    }
		
		public List<String> DFS(List<String> array, Node node){
			array.add(node.name);
			for(Node child: node.children){
				DFS(array, child);
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
