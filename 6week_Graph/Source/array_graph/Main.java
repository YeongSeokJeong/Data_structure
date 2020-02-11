package array_graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5);
		graph.add_edge(0, 1);
		graph.add_edge(0, 2);
		graph.add_edge(1, 2);
		graph.add_edge(1, 3);
		graph.add_edge(2, 3);
		graph.add_edge(3, 4);
		System.out.println("Graph");
		graph.show();
		graph.delete_edge(0, 1);
		graph.delete_edge(1, 3);
		System.out.println("\n==0-1 1-3 Delete==");
		graph.show();
	}

}
