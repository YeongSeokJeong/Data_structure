package Tree;

public class lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTree root;
		BTree LeftTemp;
		BTree RightTemp;
		
		BTree LeftSubroot;
		BTree RightSubroot;
		//트리를 생성 하기위해 먼저 선언을 실시한다.
		BTree empty = new BTree();
		//empty는 비어있는 트리를 의미한다.
		LeftTemp = new BTree(empty,'A',empty);
		RightTemp = new BTree(empty,'B',empty);
		//Left,Right는 각각 A,B를 저장한 단말노드이다.
		
		LeftSubroot = new BTree(LeftTemp,'+',RightTemp);
		//leftsubroot는 leftTemp,righttemp를 각각 왼쪽과 오른쪽으로 삼는 +를 저장한 트리구조이다.
		LeftTemp = new BTree(empty,'C',empty);
		RightTemp = new BTree(empty,'D',empty);
		//Left,Right는 각각 C,D를 저장한 단말노드이다.
		RightSubroot = new BTree(LeftTemp,'/',RightTemp);
		//leftsubroot는 leftTemp,righttemp를 각각 왼쪽과 오른쪽으로 삼는 /를 저장한 트리구조이다
		root = new BTree(LeftSubroot,'*',RightSubroot);
		//root는 왼쪽 서브트리와 오른쪽 서브 트리를 저장한 *를 저장한 트리구조이다.
		root.show();
	}

}
