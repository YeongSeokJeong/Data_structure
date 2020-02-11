package node_graph;

import java.util.*;

public class Graph {
	private Node[] header;//각 정점의 정보를 담는 해더 너드
	private int vertex_size;//정점의 숫자를 저장하는 변수

	public Graph(int vertex_size) {
		this.header = new Node[vertex_size];//정점의 숫자만큼 해더의 수를 결정 및 생성한다
		this.vertex_size = vertex_size;//정점의 숫자를 저장
		for (int i = 0; i < this.vertex_size; i++) {
			this.header[i] = null;//모든 정점의 저장값을 null로 설정한다.
		}
	}

	public void show() {
		if (this.vertex_size == 0) {
			System.out.println("[INFO] no vertex");
		}
		for (int i = 0; i < vertex_size; i++) {//모든 노드를 순회하기 위해 정점의 수만큼 반복
			Node temp = header[i];//포인터 노드를 설정
			System.out.print(i + " : ");
			while (temp != null) {//temp가 비어있을 때까지 반복을하여 링크를 뽑는다.
				System.out.print(temp.vertex + " ");
				temp = temp.link;
			}
			System.out.println();
		}
	}

	public void add_edge(int i, int k) {
		Node temp = header[i];//포인터 노드 저장
		while (temp != null) {//해당 정점의 링크드 리스트를 순회하며 이미 인접관계를 만족하는지 확인
			if (temp.vertex != k)
				temp = temp.link;
			else//이미 정점간 인접관계를 만족하면 종료
				return;
		}
		if (header[i] == null)//비어있던 노드의 경우 해더에 새롭게 값을 넣어준다.
			header[i] = new Node(k, null);
		else {//비어있지 않은 노드의  경우에 기존의 노드를 링크로 삽입하고 새로운 노드를 앞으로 넣어준다.
			header[i] = new Node(k, header[i]);
		}

		if (header[k] == null)//k,i관계의 정점 역시 위와같은 과정을 거쳐 링크드 리스트를 만든다.
			header[k] = new Node(i, null);
		else {
			header[k] = new Node(i, header[k]);
		}
	}

	public void delete_edge(int i, int k) {
		if (header[i] == null || header[k] == null)//모두 비어있는 해더인경우 지울 값이 없으므로 return
			return;
		if (header[i].vertex == k)//header[i]가 저장한 값이 k인 경우 다음 노드의 값으로 바꿔준다.
			header[i] = header[i].link;
		else {//위의 조건문을 만족하지 않는 경우에 해당 노드를 삭제한다.
			Node parent = null;//부모 리스트를 저장하는 변수
			Node temp = header[i];//자식 리스트를 저장하는 변수
			while (temp != null) {//값을 찾을떄까지 반복
				if (temp.vertex != k) {
					parent = temp;
					temp = temp.link;
				} else//값을 찾을면 반복문을 종료한다.
					break;
			}//반복문이 종료되어 temp가 null이어도 부모의 다음 링크는 null값이므로 값의 변환 없다.
			parent.link = temp.link;//반복문이 종료되어 해당 노드의 다음노드에 링크를 이어준다.
		}

		if (header[k].vertex == i)//위와같이 k,i사이의 관계도한 동일하게 실시한다.
			header[k] = header[k].link;
		else {
			Node parent = null;
			Node temp = header[k];
			while (temp != null) {
				if (temp.vertex != i) {
					parent = temp;
					temp = temp.link;
				} else
					break;
			}
			parent.link = temp.link;
		}
	}
}
