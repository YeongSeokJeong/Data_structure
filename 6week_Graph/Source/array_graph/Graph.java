package array_graph;

public class Graph {
	private int[][] adj_matrix;//�� ������ ���� ���θ� ����� ���
	private int vertex_size;//��� ������ ������ ���� ������ ����
	
	public Graph(int vertex_size) {
		this.adj_matrix = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;
		//������ ���� * ������ ���� ũ��� ����� �����Ѵ�.
	}
	public void add_edge(int i,int k) {
		if(i<vertex_size && k < vertex_size) {//i,k�� ũ�⸦ Ȯ���Ͽ� ���������� ū��� ������ �Ǵ�
			this.adj_matrix[i][k] = 1;//���ǹ��� ����Ѱ�� i,k k,i �� ����� ��ġ�� ��� 1�� �����Ѵ�.
			this.adj_matrix[k][i] = 1;
		}
		else {
			return;
		}
	}
	public void delete_edge(int i, int k) {
		if(i<vertex_size && k < vertex_size) {//i,k�� �� ũ�⸦ ���� ������ ������ ū ���� ������ ������ ���� �ʴ´�.
			this.adj_matrix[i][k] = 0;//i,k k,i�� �������θ� 0���� �����Ѵ�.
			this.adj_matrix[k][i] = 0;
		}
		else
			return;
	}
	public void show() {
		if(this.vertex_size ==0) {
			System.out.println("[INFO] no vertex");
		}
		for(int i = 0;i<this.vertex_size;i++) {//�� ���� �� Ȯ�� ���� �ݺ���
			String temp = "";
			for(int j = 0;j<this.vertex_size;j++) {//�� ������ ��Ÿ���� ���� ���� ��ĭ�� �ڷ� �̷�� ����
				if(this.adj_matrix[i][j] == 1) {
					temp +=j+" ";//�������谡 �����ϴ°�� ���ڿ��� i ������ ���������� j ������ �߰�
				}
			}
			System.out.println((i + " : " + temp));// ������ ���
		}
	}
}
