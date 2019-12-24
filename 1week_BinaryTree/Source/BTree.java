package Tree;

public class BTree {
	private TreeNode root = new TreeNode();
	//root���� ��ü Ʈ���� level�� 0�κп� ��ġ�ϴ� ����̴�.
	public BTree() {
		root = null;
	}//�����ڷ� ó���� ��忡 �����ͳ� �ƴϸ� ����Ǿ��մ� ��尡 ���� �������� �ʴ� ��쿡 ������ �Ͽ� ȣ���Ѵ�.
	public BTree(BTree left ,Object item, BTree right) {
		root.setItem(item);
		root.setLeft(left.root);
		root.setRight(right.root);
	}//�����ڷ� ���࿡ ����� ���� ����Ʈ���� ������ ����Ʈ���� �����Ѵٸ� �׸� �޾� root�� ������ ���ʿ� �ش� ��带 �����Ѵ�.
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}//���࿡ Ʈ������ ��Ʈ�� ����ִٸ� true�� �����ϰ� ������� ���� ��쿡�� false�� �����Ѵ�.
	public Object rootData() {
		if(root == null)
			return null;
		return root.getItem();
	}//root�� �����͸� �����ϴ� �Լ��̴�. ���࿡ root�� �ƹ� �����͵� �������� �ʴ´ٸ�, root�� item�� �����Ѵ�.
	public BTree leftSubTree() {
		BTree leftsub = new BTree();
		leftsub.root = this.root.getLeft();
		if(root.getLeft()!= null)
			return leftsub;
		return null;
	}//root�� ���� ����Ʈ���� �����ϴ� �Լ��̴�. ����Ʈ���� �����ϱ� �빮�� ���� Ʈ���� �ϳ� �����ϰ� �ش��ϴ� Ʈ���� ��Ʈ�� ���� ����Ʈ���� ��Ʈ�� �����Ѵ�.
	public BTree rightSubTree() {
		BTree rightsub = new BTree();
		rightsub.root = this.root.getRight();
		if(root.getLeft()!=null)
			return rightsub;
		return null;
	}//root�� ������ ����Ʈ���� �����ϴ� �޼����̴�. ������ ����Ʈ���� �����ϴ� �Լ��̱� ������ �ش��ϴ� Ʈ���� ��Ʈ�� ������ ����Ʈ���� ��Ʈ�� �����Ѵ�.
	public void show() {
		BTree right = this.rightSubTree();
		BTree left = this.leftSubTree();
		
		System.out.println("root : " + this.rootData());//�ش� ��Ʈ�� �����͸� ����Ѵ�.
		System.out.println("Left Sub Tree root : " + left.root.getItem());//�ش� �������� ���� ����Ʈ���� ��Ʈ�����͸� ����Ѵ�.
		System.out.println("Right Sub Tree root : " + right.root.getItem());//�ش� Ʈ���� ������ ����Ʈ���� ��Ʈ �����͸� ����Ѵ�.
	}
}
