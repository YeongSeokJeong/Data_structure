package node_graph;

public class Node {
	int vertex;//������ ���尪�� ��� ����
	Node link;//������ ���� ������ ��带 �����ϴ� ��ũ
	
	public Node(int v,Node link) {
		this.vertex = v;
		this.link = link;
	}
}
