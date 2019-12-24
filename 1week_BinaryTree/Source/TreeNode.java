package Tree;

public class TreeNode {//바이너리 트리에서 각 노드의 역할을 하는 클래스이다.
	private Object item;
	private TreeNode left;
	private TreeNode right;
	//item은 데이터를 저장하는 역할을 실시하고, left,right는 각각 왼쪽노드와 오른쪽 노드의 위치를 저장하는 포인터의 역할을 한다.
	
	public TreeNode() {
		this.item = null;
		this.left = null;
		this.right = null;
	}
	//노드에 아이템을 저장하는 역할을 한다.
	public TreeNode(Object item) {
		this.item = item;
		this.left = null;
		this.right = null;
	}
	//노드에서 저장하고있는 원소 즉 데이터를 리턴한다.
	public Object getItem() {
		return item;
	}
	//노드에서 데이터 저장 공간에 아이템을 저장한다.
	public void setItem(Object item) {
		this.item = item;
	}
	//노드의 왼쪽 노드를 리턴하는 함수이다.
	public TreeNode getLeft() {
		return left;
	}
	//노드의 왼쪽 노드를 지정하는 함수이다.
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	//노드의 오른쪽 노드를 리턴하는 함수이다.
	public TreeNode getRight() {
		return right;
	}//노드의 오른쪽 노드를 지정하는 함수이다.
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
