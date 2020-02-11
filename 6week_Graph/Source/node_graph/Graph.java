package node_graph;

import java.util.*;

public class Graph {
	private Node[] header;//�� ������ ������ ��� �ش� �ʵ�
	private int vertex_size;//������ ���ڸ� �����ϴ� ����

	public Graph(int vertex_size) {
		this.header = new Node[vertex_size];//������ ���ڸ�ŭ �ش��� ���� ���� �� �����Ѵ�
		this.vertex_size = vertex_size;//������ ���ڸ� ����
		for (int i = 0; i < this.vertex_size; i++) {
			this.header[i] = null;//��� ������ ���尪�� null�� �����Ѵ�.
		}
	}

	public void show() {
		if (this.vertex_size == 0) {
			System.out.println("[INFO] no vertex");
		}
		for (int i = 0; i < vertex_size; i++) {//��� ��带 ��ȸ�ϱ� ���� ������ ����ŭ �ݺ�
			Node temp = header[i];//������ ��带 ����
			System.out.print(i + " : ");
			while (temp != null) {//temp�� ������� ������ �ݺ����Ͽ� ��ũ�� �̴´�.
				System.out.print(temp.vertex + " ");
				temp = temp.link;
			}
			System.out.println();
		}
	}

	public void add_edge(int i, int k) {
		Node temp = header[i];//������ ��� ����
		while (temp != null) {//�ش� ������ ��ũ�� ����Ʈ�� ��ȸ�ϸ� �̹� �������踦 �����ϴ��� Ȯ��
			if (temp.vertex != k)
				temp = temp.link;
			else//�̹� ������ �������踦 �����ϸ� ����
				return;
		}
		if (header[i] == null)//����ִ� ����� ��� �ش��� ���Ӱ� ���� �־��ش�.
			header[i] = new Node(k, null);
		else {//������� ���� �����  ��쿡 ������ ��带 ��ũ�� �����ϰ� ���ο� ��带 ������ �־��ش�.
			header[i] = new Node(k, header[i]);
		}

		if (header[k] == null)//k,i������ ���� ���� ���Ͱ��� ������ ���� ��ũ�� ����Ʈ�� �����.
			header[k] = new Node(i, null);
		else {
			header[k] = new Node(i, header[k]);
		}
	}

	public void delete_edge(int i, int k) {
		if (header[i] == null || header[k] == null)//��� ����ִ� �ش��ΰ�� ���� ���� �����Ƿ� return
			return;
		if (header[i].vertex == k)//header[i]�� ������ ���� k�� ��� ���� ����� ������ �ٲ��ش�.
			header[i] = header[i].link;
		else {//���� ���ǹ��� �������� �ʴ� ��쿡 �ش� ��带 �����Ѵ�.
			Node parent = null;//�θ� ����Ʈ�� �����ϴ� ����
			Node temp = header[i];//�ڽ� ����Ʈ�� �����ϴ� ����
			while (temp != null) {//���� ã�������� �ݺ�
				if (temp.vertex != k) {
					parent = temp;
					temp = temp.link;
				} else//���� ã���� �ݺ����� �����Ѵ�.
					break;
			}//�ݺ����� ����Ǿ� temp�� null�̾ �θ��� ���� ��ũ�� null���̹Ƿ� ���� ��ȯ ����.
			parent.link = temp.link;//�ݺ����� ����Ǿ� �ش� ����� ������忡 ��ũ�� �̾��ش�.
		}

		if (header[k].vertex == i)//���Ͱ��� k,i������ ���赵�� �����ϰ� �ǽ��Ѵ�.
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
