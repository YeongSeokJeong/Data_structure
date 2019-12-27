package Tree;
import java.util.Stack;
class TreeNode{
	public Object item;
	public TreeNode left;
	public TreeNode right;
}
public class BTree {
	private TreeNode root = new TreeNode();
	//root노드는 전체 트리의 level의 0부분에 위치하는 노드이다.
	public BTree() {
		root = null;
	}//생성자로 처음에 노드에 데이터나 아니면 연결되어잇는 노드가 아직 존재하지 않는 경우에 선언을 하여 호출한다.
	public BTree(BTree left ,Object item, BTree right) {
		this.root.item = item;
		this.root.left = left.root;
		this.root.right = right.root;
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
		return root.item;
	}//root의 데이터를 리턴하는 함수이다. 만약에 root에 아무 데이터도 존재하지 않는다면, root의 item을 리턴한다.
	public BTree leftSubTree() {
		BTree leftsub = new BTree();
		leftsub.root = this.root.left;
		if(root.left!= null)
			return leftsub;
		return null;
	}//root의 왼쪽 서브트리를 리턴하는 함수이다. 서브트리를 리턴하기 대문에 먼저 트리를 하나 선언하고 해당하는 트리에 루트의 왼쪽 서브트리의 루트를 삽입한다.
	public BTree rightSubTree() {
		BTree rightsub = new BTree();
		rightsub.root = this.root.right;
		if(root.left!=null)
			return rightsub;
		return null;
	}//root의 오른쪽 서브트리를 리턴하는 메서드이다. 오른쪽 서브트리를 리턴하는 함수이기 때문에 해당하는 트리에 루트의 오른쪽 서브트리의 루트를 삽입한다.
	public void show() {
		BTree right = this.rightSubTree();
		BTree left = this.leftSubTree();
		
		System.out.println("root : " + this.rootData());//해당 루트의 데이터를 출력한다.
		System.out.println("Left Sub Tree root : " + left.root.item);//해당 데이터의 왼쪽 서브트리의 루트데이터를 출력한다.
		System.out.println("Right Sub Tree root : " + right.root.item);//해당 트리의 오른쪽 서브트리의 루트 데이터를 출력한다.
	}
	public void PostOrder() {
		ThePostOrder(this.root);
	}
	public void ThePostOrder(TreeNode T) {
		if(T!= null) {
			ThePostOrder(T.left);
			ThePostOrder(T.right);
			System.out.print(T.item + " ");
		}
	}
	//순환 함수를 사용한 후위순회 방법이다. 왼쪽과 오른쪽 노드를 각각 순환함수를 사용해 먼저 출력하고 루트의 데이터를 출력한다.
	public void PreOrder() {
		ThePreOrder(this.root);
	}
	public void ThePreOrder(TreeNode T) {
		if(T!=null) {
			System.out.print(T.item+ " ");
			ThePreOrder(T.left);
			ThePreOrder(T.right);
		}
	}
	//순환함수를 사용한 전위순회 방법이다. 먼저 루트데이터를 출력하고, 왼쪽과 오른쪽 을 각각 순회 함수에 넣어 출력하는 방법이다.
	public void InOrder() {
		TheInOrder(this.root);
	}
	public void TheInOrder(TreeNode T) {
		if(T!=null) {
			TheInOrder(T.left);
			System.out.print(T.item+ " ");
			TheInOrder(T.right);
		}
	}
	//순환 함수를 사용한 중위 순회 방법이다. 중위 순회는 가운데 루트노드가 가운데 오는 방법이므로 , 왼쪽 서브트리 오른쪽 서브트리를 순회한후 데이터를 출력한다.
	public void iterInorder() {//비순환 방식을 사용한 중위 순회 방법이다.
		Stack<TreeNode> stack = new Stack<TreeNode>();//p의 현재 위치의 부모노드를 저장하기 위한 스텍공간이다.
		TreeNode p = root;
		while(p!=null || stack.isEmpty()!= true) {//p가 null이거나 stack이 비었으면 순환이 끝난것으로 간주한다.
			if(p != null) {//while문을 사용한 순회가 끝나고 노드가 null이 아닌 원소가 존재할시 실행
				stack.push(p);//중위 우선순회이기 때문에 먼저 왼쪽 서브트리를 순회하기위해 스택에 부모노드인 루트를 넣는다.
				p = p.left;//p노드는 먼저 왼쪽 노드를 가리킨다.
			}
			else {//왼쪽 트리로 순회가 끝나고, 스택이 비어있지 않다면, 실행한다.
				p = stack.pop();//stack에 저장된 노드를 팝 하여 부모노드를 꺼낸다.
				System.out.print(p.item + " ");//서브트리의 아이템을 꺼내어 출력한다.
				p = p.right;//오른쪽 서브트리로 p포인터가 가리키도록 한다.
			}
		}
	}
	
	public void iterPreorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();//부모노드의 주소를 저장하기위한 스텍을 지정한다.
		TreeNode p = root;
		
		while(p != null || stack.isEmpty()!=true) {//p가 null이거나 stack이 비었으면 순환이 끝난것으로 간주한다.
			if(p!= null) {//while문을 사용한 순회가 끝나고 노드가 null이 아닌 원소가 존재할시 실행
				System.out.print(p.item + " ");//전위 순회이기 때문에 먼저 루트의 즉 포인터가 가리키는 노드의 값을 먼저 출력한다.
				stack.push(p);//부모노드인 p노드를 스텍에 삽입한다.
				p = p.left;//왼쪽노드를 포인터가 가리키도록 한다.
			}
			else {//왼쪽 트리로 순회가 끝나고, 스택이 비어있지 않다면, 실행한다
				p = stack.pop();//pop을 실행하여 부모노드를 가리킨다.
				p = p.right;//부모노드의 오른쪽 자식으로 포인터를 옮겨간다.
			}
		}
	}
	
	public BTree copy() {
		BTree newTree = new BTree();
		newTree.root = theCopy(root);//루트를 복사하여 새로운 이진트리에 복사한다.
		return newTree;
	}
	private TreeNode theCopy(TreeNode T) {
		if(T==null)//노드가 비어있다면 null값을 리턴한다.
			return null;
		//왼쪽자식,오른쪽자식을 복사한 후에 새로운 노드를 생성하여 데이터 왼쪽 오른쪽 노드를 삽입한다.
		TreeNode l = T.left;
		TreeNode r = T.right;
		TreeNode newNode = new TreeNode();
		newNode.item = T.item;
		newNode.left = l;
		newNode.right = r;
		return newNode;
	}
	public boolean equals(BTree S) {
		return theEquals(this.root,S.root);
	}
	public boolean theEquals(TreeNode S, TreeNode T) {
		//둘다 모두 비어있는 노드라면 참값을 리턴한다.
		if(S == null && T== null)
			return true;
		//루트의 데이터도 같고, 왼쪽, 오른쪽 서브트리도 순환 함수를 사용하여 점검한후 만약 이 조건이 모두 맞다면 참값을 리턴한다.
		else if(S!= null && T!= null) {
			if (theEquals(S.left,T.left)) {
				if(theEquals(S.right,T.right)) {
					if(S.item.equals(T.item)) {
						return true;
					}
				}
			}
		}
		return false;
	
	}
}
