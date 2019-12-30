package BSTree;

class TreeNode {
	public int item;
	public TreeNode left;
	public TreeNode right;
}

public class BST {
	private TreeNode root = new TreeNode();

	public BST() {
		this.root = null;
	}

	public void search(int item) {
		if (searchBST(this.root, item) == null) {
			System.out.println("[INFO] " + item + " Not Existing");
		} else {
			System.out.println("[INFO] " + item + " Existing");
		}
	}

	public TreeNode searchBST(TreeNode B, int item) {
		TreeNode p = B;//Ʈ�� ��带 ã���ִ� ������
		while (p != null) {//Ʈ���� ����ִٸ� null�� ��ȯ
			if (p.item < item) {
				p = p.right;//���ϴ� �� ���� ����� ���� ������� ������ ����Ʈ���� �����͸� �ű��.
			} else if (p.item > item) {
				p = p.left;//���ϴ� �� ���� ����� ���� ū ��� ���� ����Ʈ���� �����͸� �ű��.
			} else {
				break;//���ϴ� Ʈ���� ã�� ��� �ݺ��� ����
			}
		}
		return p;
	}

	public void insert(int item) {
		TreeNode p = this.root;//Ʈ���� ��ȯ�ϴ� ������
		TreeNode q = new TreeNode();//������ ����� �θ��带 ����Ű�� ������
		while (p != null) {
			q = p;//q�� �θ��带 ����Ű���� �ݺ����� �����ϴ� �������� ���� �Է��Ѵ�.
			if (item < p.item) {
				p = p.left;//ã�� ������ ����� ���� ū��� �����ʹ� ���� ����Ʈ���� �Ű�����.
			} else if (item > p.item) {
				p = p.right;//ã�� ������ ����� ���� ���� ��� �����ʹ� ������ ����Ʈ���� �Ű�����.
			} else
				return;
		}
		TreeNode newNode = new TreeNode();//���Ӱ� �� ��带 �����Ѵ�.
		newNode.item = item;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {//����Ʈ�� ��ü�� ����ִ°��
			root = newNode;
		}
		if (item < q.item) {//p�� �ܸ���� �̹Ƿ� �θ���� ũ�⸦ ���Ͽ� ���� �����Ѵ�.
			q.left = newNode;
		} else {
			q.right = newNode;
		}
	}

	public void delete(int item) {
		deleteBST(this.root, item);
	}

	private TreeNode maxNode(TreeNode m) {//Ʈ�� ��� ���� ū ���� ã�� �Լ��̴�.
		TreeNode p = m;
		if (p == null)//����ִ� ����� ��� ����ִ� ��带 �״�� �����Ѵ�.
			return p;
		else if (p.right == null)//������ ��尡 ����ִ� ��� �ش� ��带 �����Ѵ�.
			return p;
		else {
			while (p.right != null) {//Ʈ�� ��� ���� ū ���� ã�ƾ� �ϹǷ� ������ ���� ��� ������ �ܸ�����϶����� �����δ�.
				p = p.right;
			}
			return p;
		}
	}

	private void deleteBST(TreeNode root, int item) {
		TreeNode p = root;//������ ��带 �����Ѵ�.
		TreeNode parent = p;//������ ����� �θ��带 �����Ѵ�.
		TreeNode q = null;

		while (p != null) {//�������� ã�������� �ݺ��Ѵ�.
			if (p.item > item) {//�����Ϸ��� ��尡 �ش� ��庸�� ū ���. 
				q = p;//�θ��带 ����
				p = p.left;//���� ���� �����͸� �ű��.
			} else if (p.item < item) {//�����Ϸ��� ��尡 �ش� ��庸�� ���� ���
				q = p;//�θ��带 ����
				p = p.right;//������ ���� �����͸� �ű��.
			} else//�����Ϸ��� ��带 ã���� �ش� �ݺ��� ���� 
				break;
		}
		if (p.left == null && p.right == null) {//�ܸ� ����� ���.
			if (parent.left == null)//�θ����� ���� �ڽ��� ����ִٸ� 
				parent.right = null;//������ �ڽ��� ���� �ȴ�.
			else//�θ����� ������ �ڽ��� ����ִٸ�
				parent.left = null;//���� �ڽ��� ���� �ȴ�.
		} else if (p.left == null || p.right == null) {//�ϳ��� �ڽĸ� �ִ� ���
			if(p.left!= null) {//������ �ڽ� ��尡 �ִ°��.
				if (parent.left == p)//���� �ڽ��� ������ ����� ���
					parent.left = p.left;//���� �ڽĿ� ������ ����� ���� �ڽ��� ����Ų��.
				else//������ �ڽ��� ������ ����� ���
					parent.right = p.left;//������ �ڽ��� p�� ���� �ڽ��� ����Ų��.
			}
			else {//�θ� ����� ���� ��忡 �ڽ��� �ִ°�� �θ����� �ڽ����� ������ �ڽ��� �����Ѵ�.
				if (parent.left == p)
					parent.left = p.right;
				else
					parent.right = p.right;
			}
		} else if (p.left != null && p.right != null) {//���� �ڽ��� ��� �ִ°��
			q = maxNode(p.left);//q�� ���� �ڽ��� ���� ū ��带 �����Ѵ�.
			p.item = q.item;
			deleteBST(p.left, p.item);//p�� ���� ����Ʈ���� ���� �ڽĳ��� �� ���� ��ġ�� ��带 �����Ѵ�.
			p.left = null;
		}
	}

	public void split(BST bBST , BST cBST , int x) {
		TreeNode Large = new TreeNode();//cBST�� ��Ʈ�� �� �������
		TreeNode Small = new TreeNode();//bBST�� ��Ʈ�� �� �������
		TreeNode L = Large;//Large����� ������ ������ �ϴ� ���
		TreeNode S = Small;//Small�� ������ ������ �ϴ� ���
		TreeNode p = root;//����� Ű���� Ȯ���ϴ� ���
		
		while(p != null) {
			if(p.item == x) {//Ű���� ã�����
				S.right = p.left; // S�������� ������ ��忡 p ����� ���� �ڽ��� �����Ѵ�.
				L.left = p.right;//L�������� ���� ��忡 p����� ������ �ڽ��� �����Ѵ�.
				cBST.root = Large.left;//cBST�� ��Ʈ���� Large����� ���� ����Ʈ���� ����
				bBST.root = Small.right;//bBST�� ��Ʈ���� Small����� ������ ����Ʈ���� ����
				return;
			}
			else if(x<p.item) {//Ű������ ����� ���� ū���
				L.left = p;//L����� �����ڽ� �����ʹ� ���� p��带 ����Ű��
				L = p;//L���� p�� ���� ��ġ�� ���� �Űܰ���
				p = p.left;//p���� Ű���� ã�� ���� ���� �Űܰ���.
			}
			else {//Ű������ ����� ���� ���� ���
				S.right = p;//S����� ������ �ڽ� �����Ϳ� p��带 ����
				S = p;//S���� p��尡 ���� ��ġ�� ���� �Űܰ�
				p = p.right;//p���� Ű���� ã�� ������ ������� �Űܰ���.
			}
		}
		//Ű���� ã�� ���Ѱ�� 
		cBST.root = Large.left;
		bBST.root = Small.right;
	}

	public void show() {
		showBST(this.root);
		System.out.println();
	}

	private void showBST(TreeNode B) {
		if (B != null) {
			System.out.print("[");
			showBST(B.left);
			System.out.print(B.item);
			showBST(B.right);
			System.out.print("]");
		}
	}

}
