package node_graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(7);
		graph.add_edge(0, 1);
		graph.add_edge(0, 2);
		graph.add_edge(0, 3);
		graph.add_edge(0, 4);
		
		graph.add_edge(1, 4);
		
		graph.add_edge(2, 4);
		graph.add_edge(2, 5);
		
		graph.add_edge(3, 5);
		
		graph.add_edge(5, 6);
		
		System.out.println("Graph");
		graph.show();
		
		System.out.println("\n==0-1 1-3 Delete==");
		graph.delete_edge(0, 4);
		graph.show();
	}

}
