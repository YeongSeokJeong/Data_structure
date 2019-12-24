package Tree;

public class TreeNode {//���̳ʸ� Ʈ������ �� ����� ������ �ϴ� Ŭ�����̴�.
	private Object item;
	private TreeNode left;
	private TreeNode right;
	//item�� �����͸� �����ϴ� ������ �ǽ��ϰ�, left,right�� ���� ���ʳ��� ������ ����� ��ġ�� �����ϴ� �������� ������ �Ѵ�.
	
	public TreeNode() {
		this.item = null;
		this.left = null;
		this.right = null;
	}
	//��忡 �������� �����ϴ� ������ �Ѵ�.
	public TreeNode(Object item) {
		this.item = item;
		this.left = null;
		this.right = null;
	}
	//��忡�� �����ϰ��ִ� ���� �� �����͸� �����Ѵ�.
	public Object getItem() {
		return item;
	}
	//��忡�� ������ ���� ������ �������� �����Ѵ�.
	public void setItem(Object item) {
		this.item = item;
	}
	//����� ���� ��带 �����ϴ� �Լ��̴�.
	public TreeNode getLeft() {
		return left;
	}
	//����� ���� ��带 �����ϴ� �Լ��̴�.
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	//����� ������ ��带 �����ϴ� �Լ��̴�.
	public TreeNode getRight() {
		return right;
	}//����� ������ ��带 �����ϴ� �Լ��̴�.
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
