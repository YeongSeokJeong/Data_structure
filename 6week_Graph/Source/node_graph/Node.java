package node_graph;

public class Node {
	int vertex;//정점의 저장값을 담는 변수
	Node link;//정점과 인접 관계인 노드를 연결하는 링크
	
	public Node(int v,Node link) {
		this.vertex = v;
		this.link = link;
	}
}
