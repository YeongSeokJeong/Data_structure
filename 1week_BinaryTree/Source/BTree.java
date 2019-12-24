package Tree;

public class BTree {
	private TreeNode root = new TreeNode();
	//root노드는 전체 트리의 level의 0부분에 위치하는 노드이다.
	public BTree() {
		root = null;
	}//생성자로 처음에 노드에 데이터나 아니면 연결되어잇는 노드가 아직 존재하지 않는 경우에 선언을 하여 호출한다.
	public BTree(BTree left ,Object item, BTree right) {
		root.setItem(item);
		root.setLeft(left.root);
		root.setRight(right.root);
	}//생성자로 만약에 노드의 왼쪽 서브트리와 오른쪽 서브트리가 존재한다면 그를 받아 root의 오른쪽 왼쪽에 해당 노드를 삽입한다.
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}//만약에 트리에서 루트가 비어있다면 true를 리턴하고 비어있지 않은 경우에는 false를 리턴한다.
	public Object rootData() {
		if(root == null)
			return null;
		return root.getItem();
	}//root의 데이터를 리턴하는 함수이다. 만약에 root에 아무 데이터도 존재하지 않는다면, root의 item을 리턴한다.
	public BTree leftSubTree() {
		BTree leftsub = new BTree();
		leftsub.root = this.root.getLeft();
		if(root.getLeft()!= null)
			return leftsub;
		return null;
	}//root의 왼쪽 서브트리를 리턴하는 함수이다. 서브트리를 리턴하기 대문에 먼저 트리를 하나 선언하고 해당하는 트리에 루트의 왼쪽 서브트리의 루트를 삽입한다.
	public BTree rightSubTree() {
		BTree rightsub = new BTree();
		rightsub.root = this.root.getRight();
		if(root.getLeft()!=null)
			return rightsub;
		return null;
	}//root의 오른쪽 서브트리를 리턴하는 메서드이다. 오른쪽 서브트리를 리턴하는 함수이기 때문에 해당하는 트리에 루트의 오른쪽 서브트리의 루트를 삽입한다.
	public void show() {
		BTree right = this.rightSubTree();
		BTree left = this.leftSubTree();
		
		System.out.println("root : " + this.rootData());//해당 루트의 데이터를 출력한다.
		System.out.println("Left Sub Tree root : " + left.root.getItem());//해당 데이터의 왼쪽 서브트리의 루트데이터를 출력한다.
		System.out.println("Right Sub Tree root : " + right.root.getItem());//해당 트리의 오른쪽 서브트리의 루트 데이터를 출력한다.
	}
}
