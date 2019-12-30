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
		TreeNode p = B;//트리 노드를 찾아주는 포인터
		while (p != null) {//트리가 비어있다면 null을 반환
			if (p.item < item) {
				p = p.right;//원하는 값 보다 노드의 값이 작은경우 오른쪽 서브트리로 포인터를 옮긴다.
			} else if (p.item > item) {
				p = p.left;//원하는 값 보다 노드의 값이 큰 경우 왼쪽 서브트리로 포인터를 옮긴다.
			} else {
				break;//원하는 트리를 찾은 경우 반복문 종료
			}
		}
		return p;
	}

	public void insert(int item) {
		TreeNode p = this.root;//트리를 순환하는 포인터
		TreeNode q = new TreeNode();//포인터 노드의 부모노드를 가리키는 포인터
		while (p != null) {
			q = p;//q가 부모노드를 가리키도록 반복문이 시작하는 지점에서 값을 입력한다.
			if (item < p.item) {
				p = p.left;//찾는 값보다 노드의 값이 큰경우 포인터는 왼쪽 서브트리로 옮겨진다.
			} else if (item > p.item) {
				p = p.right;//찾는 값보다 노드의 값이 작은 경우 포인터는 오른쪽 서브트리로 옮겨진다.
			} else
				return;
		}
		TreeNode newNode = new TreeNode();//새롭게 들어갈 노드를 선언한다.
		newNode.item = item;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {//이진트리 자체가 비어있는경우
			root = newNode;
		}
		if (item < q.item) {//p가 단말노드 이므로 부모노드와 크기를 비교하여 값을 삽입한다.
			q.left = newNode;
		} else {
			q.right = newNode;
		}
	}

	public void delete(int item) {
		deleteBST(this.root, item);
	}

	private TreeNode maxNode(TreeNode m) {//트리 가운데 가장 큰 값을 찾는 함수이다.
		TreeNode p = m;
		if (p == null)//비어있는 노드의 경우 비어있는 노드를 그대로 리턴한다.
			return p;
		else if (p.right == null)//오른쪽 노드가 비어있는 경우 해당 노드를 리턴한다.
			return p;
		else {
			while (p.right != null) {//트리 가운데 가장 큰 값을 찾아야 하므로 오른쪽 노드로 계속 움직여 단말노드일때까지 움직인다.
				p = p.right;
			}
			return p;
		}
	}

	private void deleteBST(TreeNode root, int item) {
		TreeNode p = root;//포인터 노드를 선언한다.
		TreeNode parent = p;//포인터 노드의 부모노드를 선언한다.
		TreeNode q = null;

		while (p != null) {//아이템을 찾을때까지 반복한다.
			if (p.item > item) {//삭제하려는 노드가 해당 노드보다 큰 경우. 
				q = p;//부모노드를 지정
				p = p.left;//왼쪽 노드로 포인터를 옮긴다.
			} else if (p.item < item) {//삭제하려는 노드가 해당 노드보다 작은 경우
				q = p;//부모노드를 지정
				p = p.right;//오른쪽 노드로 포인터를 옮긴다.
			} else//삭제하려는 노드를 찾으면 해당 반복문 종료 
				break;
		}
		if (p.left == null && p.right == null) {//단말 노드인 경우.
			if (parent.left == null)//부모노드의 왼쪽 자식이 비어있다면 
				parent.right = null;//오른쪽 자식을 비우게 된다.
			else//부모노드의 오른쪽 자식이 비어있다면
				parent.left = null;//왼쪽 자식을 비우게 된다.
		} else if (p.left == null || p.right == null) {//하나의 자식만 있는 경우
			if(p.left!= null) {//오른쪽 자식 노드가 있는경우.
				if (parent.left == p)//왼쪽 자식이 포인터 노드인 경우
					parent.left = p.left;//왼쪽 자식에 포인터 노드의 왼쪽 자식을 가리킨다.
				else//오른쪽 자식이 포인터 노드인 경우
					parent.right = p.left;//오른쪽 자식은 p의 왼쪽 자식을 가리킨다.
			}
			else {//부모 노드의 왼쪽 노드에 자식이 있는경우 부모노드의 자식으로 오른쪽 자식을 삽입한다.
				if (parent.left == p)
					parent.left = p.right;
				else
					parent.right = p.right;
			}
		} else if (p.left != null && p.right != null) {//양쪽 자식이 모두 있는경우
			q = maxNode(p.left);//q에 왼쪽 자식중 가장 큰 노드를 삽입한다.
			p.item = q.item;
			deleteBST(p.left, p.item);//p의 왼쪽 서브트리중 왼쪽 자식노드와 그 값이 겹치는 노드를 삭제한다.
			p.left = null;
		}
	}

	public void split(BST bBST , BST cBST , int x) {
		TreeNode Large = new TreeNode();//cBST의 루트로 들어갈 저장공간
		TreeNode Small = new TreeNode();//bBST의 루트로 들어갈 저장공간
		TreeNode L = Large;//Large노드의 포인터 역할을 하는 노드
		TreeNode S = Small;//Small의 포인터 역할을 하는 노드
		TreeNode p = root;//노드의 키값을 확인하는 노드
		
		while(p != null) {
			if(p.item == x) {//키값을 찾은경우
				S.right = p.left; // S포인터의 오른쪽 노드에 p 노드의 왼쪽 자식을 삽입한다.
				L.left = p.right;//L포인터의 왼쪽 노드에 p노드의 오른쪽 자식을 삽입한다.
				cBST.root = Large.left;//cBST의 루트에는 Large노드의 왼쪽 서브트리를 삽입
				bBST.root = Small.right;//bBST의 루트에는 Small노드의 오른쪽 서브트리를 삽입
				return;
			}
			else if(x<p.item) {//키값보다 노드의 값이 큰경우
				L.left = p;//L노드의 왼쪽자식 포인터는 현재 p노드를 가리키고
				L = p;//L노드는 p가 현재 위치한 노드로 옮겨간다
				p = p.left;//p노드는 키값을 찾아 왼쪽 노드로 옮겨간다.
			}
			else {//키값보다 노드의 값이 작은 경우
				S.right = p;//S노드의 오른쪽 자식 포인터에 p노드를 삽입
				S = p;//S노드는 p노드가 현재 위치한 노드로 옮겨감
				p = p.right;//p노드는 키값을 찾아 오른쪽 서브노드로 옮겨간다.
			}
		}
		//키값을 찾지 못한경우 
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
