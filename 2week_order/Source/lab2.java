package Tree;

public class lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTree root;
		BTree LeftTemp;
		BTree RightTemp;
		
		BTree LeftSubroot;
		BTree RightSubroot;
		//Ʈ���� ���� �ϱ����� ���� ������ �ǽ��Ѵ�.
		BTree empty = new BTree();
		//empty�� ����ִ� Ʈ���� �ǹ��Ѵ�.
		LeftTemp = new BTree(empty,'A',empty);
		RightTemp = new BTree(empty,'B',empty);
		//Left,Right�� ���� A,B�� ������ �ܸ�����̴�.
		
		LeftSubroot = new BTree(LeftTemp,'+',RightTemp);
		//leftsubroot�� leftTemp,righttemp�� ���� ���ʰ� ���������� ��� +�� ������ Ʈ�������̴�.
		LeftTemp = new BTree(empty,'C',empty);
		RightTemp = new BTree(empty,'D',empty);
		//Left,Right�� ���� C,D�� ������ �ܸ�����̴�.
		
		RightSubroot = new BTree(LeftTemp,'/',RightTemp);
		//leftsubroot�� leftTemp,righttemp�� ���� ���ʰ� ���������� ��� /�� ������ Ʈ�������̴�
		root = new BTree(LeftSubroot,'*',RightSubroot);
		//root�� ���� ����Ʈ���� ������ ���� Ʈ���� ������ *�� ������ Ʈ�������̴�.
		System.out.println("\n[INFO] ��ȯ ���� ��ȸ(inorder) ");
		root.InOrder();
		System.out.println("\n[INFO] ��ȯ ���� ��ȸ(preorder) ");
		root.PreOrder();
		System.out.println("\n[INFO] ��ȯ ���� ��ȸ(postorder) ");
		root.PostOrder();
		System.out.println("\n[INFO] ���ȯ ���� ��ȸ(inorder) ");
		root.iterInorder();
		System.out.println("\n[INFO] ���ȯ ���� ��ȸ(preorder) ");
		root.iterPreorder();
		
		BTree copytree = root.copy();
		if(root.equals(copytree)) {
			System.out.println("\nroot and copy are the same^^");
		}else {
			System.out.println("\nroot and copy are not the same:(");
		}
	}

}
