package array_graph;

public class Graph {
	private int[][] adj_matrix;//각 정점간 인접 여부를 담아줄 행렬
	private int vertex_size;//모든 정점의 개수를 담은 정수형 변수
	
	public Graph(int vertex_size) {
		this.adj_matrix = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;
		//정점의 개수 * 정점의 개수 크기로 행렬을 선언한다.
	}
	public void add_edge(int i,int k) {
		if(i<vertex_size && k < vertex_size) {//i,k의 크기를 확인하여 정점수보다 큰경우 오류로 판단
			this.adj_matrix[i][k] = 1;//조건문을 통과한경우 i,k k,i 의 행렬의 위치에 모두 1을 삽입한다.
			this.adj_matrix[k][i] = 1;
		}
		else {
			return;
		}
	}
	public void delete_edge(int i, int k) {
		if(i<vertex_size && k < vertex_size) {//i,k의 각 크기를 비교해 정점의 수보다 큰 수가 들어오면 실행을 하지 않는다.
			this.adj_matrix[i][k] = 0;//i,k k,i각 인접여부를 0으로 변경한다.
			this.adj_matrix[k][i] = 0;
		}
		else
			return;
	}
	public void show() {
		if(this.vertex_size ==0) {
			System.out.println("[INFO] no vertex");
		}
		for(int i = 0;i<this.vertex_size;i++) {//각 정점 별 확인 위한 반복문
			String temp = "";
			for(int j = 0;j<this.vertex_size;j++) {//각 정점을 나타내는 행의 열을 한칸씩 뒤로 미루며 실행
				if(this.adj_matrix[i][j] == 1) {
					temp +=j+" ";//인접관계가 존재하는경우 문자열에 i 정점과 인접관계인 j 정점을 추가
				}
			}
			System.out.println((i + " : " + temp));// 정점별 출력
		}
	}
}
