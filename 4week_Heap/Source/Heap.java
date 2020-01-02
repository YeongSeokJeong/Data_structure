package Heap;

public class Heap {
	private int nNode;
	private int maxSize;
	private int heap[];

	public Heap() {
		nNode = 0;//처음에 노드의 크기는 0으로 지정한다.
		maxSize = 5;//힙의 최대 크기
		heap = new int[maxSize];//힙은 완전이진트리이므로 배열에 원소를 저장한다.
	}

	private void heapFull() {//힙이 가득찼을때
		maxSize++;//힙이 가득차면 최대크기를 하나늘림
		int tempHeap[] = new int[maxSize];//새로운 힙 정의
		for (int i = 0; i < maxSize - 1; i++) {
			tempHeap[i] = heap[i];
		}//새로운 힙에 이전 힙의 원소를 삽입
		heap = tempHeap;//힙에 새로운 힙을 삽입
	}

	public void insert(int item) {
		if (maxSize == nNode+1)//힙의 사이즈가 포화된 상태라면
			heapFull();//힙의 사이즈를 하나 늘려준다.
		nNode++;//새로운 원소가 들어오므로 nNode를 하나 늘려준다.
		heap[nNode] = item;//힙의 마지막 원소에 아이템으로 새로들어오는 원소를 삽입
		int n = nNode;
		while (n > 1) {//일단은 루트노드까지 확인을 하기위해 while문 반복
			if (item > heap[(int) (n / 2)]) {//만약 들어오는 아이템이 해당 노드의 부모노드보다 크다면
				//부모노드와 자식노드를 변경하고 노드의 포인터는 자식으로 옮겨간다.
				int temp = heap[(int) (n/ 2)]; 
				heap[(int) (n / 2)] = heap[n];
				heap[n] = temp;
				n = (int) (n / 2);
			} else//부모노드가 자식노드보다 크거나 같은경우 반복문 종료
				break;
		}
		
	}

	public int delete() {
		if(nNode == 0)//비어있는 힙 이라면 메소드 종료
			return 0;
		int item = heap[1];//마지막에 루트를 리턴할 원소
		int temp = heap[nNode];//temp에는 원래 힙의 마지막 위치에 있는 원소를 삽입
		nNode --;//삭제 연산이므로 nNode는 하나 줄여준다.
		int i = 1;//부모 노드의 포인터
		int j = 2;//자식 노드의 포인터
		while(j<=nNode) {//자식 노드가 힙이 가진 노드의 개수보다 작거나 같은 경우 반복문 반복
			if(j<nNode) {//자식 가운데 큰 노드의 인덱스를 j에 지정한다.
				if(heap[j]<heap[j+1])
					j ++;
			}
			if(temp>=heap[j])//만약 크기 비교를 하여 temp의 원소가 자식 노드보다 크다면 반복문 종료
				break;
			heap[i] = heap[j];//부모노드에 자식 노드를 삽입한다.
			i = j;//부모노드의 포인터를 자식으로 옮긴다.
			j = j*2;//자식노드의 포인터를 자식노드의 자식으로 올긴다.
		}
		heap[i] = temp;//크기비교가 끝났으므로 i번째 원소에 temp를 삽입
		return item;
	}
	
	public void show() {
		for(int i = 1; i <= nNode; i++) {
			System.out.print(heap[i] + " | ");
		} 
		System.out.println();
	}
}
