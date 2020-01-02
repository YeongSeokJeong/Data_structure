package Heap;

public class Heap {
	private int nNode;
	private int maxSize;
	private int heap[];

	public Heap() {
		nNode = 0;//ó���� ����� ũ��� 0���� �����Ѵ�.
		maxSize = 5;//���� �ִ� ũ��
		heap = new int[maxSize];//���� ��������Ʈ���̹Ƿ� �迭�� ���Ҹ� �����Ѵ�.
	}

	private void heapFull() {//���� ����á����
		maxSize++;//���� �������� �ִ�ũ�⸦ �ϳ��ø�
		int tempHeap[] = new int[maxSize];//���ο� �� ����
		for (int i = 0; i < maxSize - 1; i++) {
			tempHeap[i] = heap[i];
		}//���ο� ���� ���� ���� ���Ҹ� ����
		heap = tempHeap;//���� ���ο� ���� ����
	}

	public void insert(int item) {
		if (maxSize == nNode+1)//���� ����� ��ȭ�� ���¶��
			heapFull();//���� ����� �ϳ� �÷��ش�.
		nNode++;//���ο� ���Ұ� �����Ƿ� nNode�� �ϳ� �÷��ش�.
		heap[nNode] = item;//���� ������ ���ҿ� ���������� ���ε����� ���Ҹ� ����
		int n = nNode;
		while (n > 1) {//�ϴ��� ��Ʈ������ Ȯ���� �ϱ����� while�� �ݺ�
			if (item > heap[(int) (n / 2)]) {//���� ������ �������� �ش� ����� �θ��庸�� ũ�ٸ�
				//�θ���� �ڽĳ�带 �����ϰ� ����� �����ʹ� �ڽ����� �Űܰ���.
				int temp = heap[(int) (n/ 2)]; 
				heap[(int) (n / 2)] = heap[n];
				heap[n] = temp;
				n = (int) (n / 2);
			} else//�θ��尡 �ڽĳ�庸�� ũ�ų� ������� �ݺ��� ����
				break;
		}
		
	}

	public int delete() {
		if(nNode == 0)//����ִ� �� �̶�� �޼ҵ� ����
			return 0;
		int item = heap[1];//�������� ��Ʈ�� ������ ����
		int temp = heap[nNode];//temp���� ���� ���� ������ ��ġ�� �ִ� ���Ҹ� ����
		nNode --;//���� �����̹Ƿ� nNode�� �ϳ� �ٿ��ش�.
		int i = 1;//�θ� ����� ������
		int j = 2;//�ڽ� ����� ������
		while(j<=nNode) {//�ڽ� ��尡 ���� ���� ����� �������� �۰ų� ���� ��� �ݺ��� �ݺ�
			if(j<nNode) {//�ڽ� ��� ū ����� �ε����� j�� �����Ѵ�.
				if(heap[j]<heap[j+1])
					j ++;
			}
			if(temp>=heap[j])//���� ũ�� �񱳸� �Ͽ� temp�� ���Ұ� �ڽ� ��庸�� ũ�ٸ� �ݺ��� ����
				break;
			heap[i] = heap[j];//�θ��忡 �ڽ� ��带 �����Ѵ�.
			i = j;//�θ����� �����͸� �ڽ����� �ű��.
			j = j*2;//�ڽĳ���� �����͸� �ڽĳ���� �ڽ����� �ñ��.
		}
		heap[i] = temp;//ũ��񱳰� �������Ƿ� i��° ���ҿ� temp�� ����
		return item;
	}
	
	public void show() {
		for(int i = 1; i <= nNode; i++) {
			System.out.print(heap[i] + " | ");
		} 
		System.out.println();
	}
}
