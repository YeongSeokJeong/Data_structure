package Tree;
import java.util.Stack;
class TreeNode{
	public Object item;
	public TreeNode left;
	public TreeNode right;
}
public class BTree {
	private TreeNode root = new TreeNode();
	//root���� ��ü Ʈ���� level�� 0�κп� ��ġ�ϴ� ����̴�.
	public BTree() {
		root = null;
	}//�����ڷ� ó���� ��忡 �����ͳ� �ƴϸ� ����Ǿ��մ� ��尡 ���� �������� �ʴ� ��쿡 ������ �Ͽ� ȣ���Ѵ�.
	public BTree(BTree left ,Object item, BTree right) {
		this.root.item = item;
		this.root.left = left.root;
		this.root.right = right.root;
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
		return root.item;
	}//root�� �����͸� �����ϴ� �Լ��̴�. ���࿡ root�� �ƹ� �����͵� �������� �ʴ´ٸ�, root�� item�� �����Ѵ�.
	public BTree leftSubTree() {
		BTree leftsub = new BTree();
		leftsub.root = this.root.left;
		if(root.left!= null)
			return leftsub;
		return null;
	}//root�� ���� ����Ʈ���� �����ϴ� �Լ��̴�. ����Ʈ���� �����ϱ� �빮�� ���� Ʈ���� �ϳ� �����ϰ� �ش��ϴ� Ʈ���� ��Ʈ�� ���� ����Ʈ���� ��Ʈ�� �����Ѵ�.
	public BTree rightSubTree() {
		BTree rightsub = new BTree();
		rightsub.root = this.root.right;
		if(root.left!=null)
			return rightsub;
		return null;
	}//root�� ������ ����Ʈ���� �����ϴ� �޼����̴�. ������ ����Ʈ���� �����ϴ� �Լ��̱� ������ �ش��ϴ� Ʈ���� ��Ʈ�� ������ ����Ʈ���� ��Ʈ�� �����Ѵ�.
	public void show() {
		BTree right = this.rightSubTree();
		BTree left = this.leftSubTree();
		
		System.out.println("root : " + this.rootData());//�ش� ��Ʈ�� �����͸� ����Ѵ�.
		System.out.println("Left Sub Tree root : " + left.root.item);//�ش� �������� ���� ����Ʈ���� ��Ʈ�����͸� ����Ѵ�.
		System.out.println("Right Sub Tree root : " + right.root.item);//�ش� Ʈ���� ������ ����Ʈ���� ��Ʈ �����͸� ����Ѵ�.
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
	//��ȯ �Լ��� ����� ������ȸ ����̴�. ���ʰ� ������ ��带 ���� ��ȯ�Լ��� ����� ���� ����ϰ� ��Ʈ�� �����͸� ����Ѵ�.
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
	//��ȯ�Լ��� ����� ������ȸ ����̴�. ���� ��Ʈ�����͸� ����ϰ�, ���ʰ� ������ �� ���� ��ȸ �Լ��� �־� ����ϴ� ����̴�.
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
	//��ȯ �Լ��� ����� ���� ��ȸ ����̴�. ���� ��ȸ�� ��� ��Ʈ��尡 ��� ���� ����̹Ƿ� , ���� ����Ʈ�� ������ ����Ʈ���� ��ȸ���� �����͸� ����Ѵ�.
	public void iterInorder() {//���ȯ ����� ����� ���� ��ȸ ����̴�.
		Stack<TreeNode> stack = new Stack<TreeNode>();//p�� ���� ��ġ�� �θ��带 �����ϱ� ���� ���ذ����̴�.
		TreeNode p = root;
		while(p!=null || stack.isEmpty()!= true) {//p�� null�̰ų� stack�� ������� ��ȯ�� ���������� �����Ѵ�.
			if(p != null) {//while���� ����� ��ȸ�� ������ ��尡 null�� �ƴ� ���Ұ� �����ҽ� ����
				stack.push(p);//���� �켱��ȸ�̱� ������ ���� ���� ����Ʈ���� ��ȸ�ϱ����� ���ÿ� �θ����� ��Ʈ�� �ִ´�.
				p = p.left;//p���� ���� ���� ��带 ����Ų��.
			}
			else {//���� Ʈ���� ��ȸ�� ������, ������ ������� �ʴٸ�, �����Ѵ�.
				p = stack.pop();//stack�� ����� ��带 �� �Ͽ� �θ��带 ������.
				System.out.print(p.item + " ");//����Ʈ���� �������� ������ ����Ѵ�.
				p = p.right;//������ ����Ʈ���� p�����Ͱ� ����Ű���� �Ѵ�.
			}
		}
	}
	
	public void iterPreorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();//�θ����� �ּҸ� �����ϱ����� ������ �����Ѵ�.
		TreeNode p = root;
		
		while(p != null || stack.isEmpty()!=true) {//p�� null�̰ų� stack�� ������� ��ȯ�� ���������� �����Ѵ�.
			if(p!= null) {//while���� ����� ��ȸ�� ������ ��尡 null�� �ƴ� ���Ұ� �����ҽ� ����
				System.out.print(p.item + " ");//���� ��ȸ�̱� ������ ���� ��Ʈ�� �� �����Ͱ� ����Ű�� ����� ���� ���� ����Ѵ�.
				stack.push(p);//�θ����� p��带 ���ؿ� �����Ѵ�.
				p = p.left;//���ʳ�带 �����Ͱ� ����Ű���� �Ѵ�.
			}
			else {//���� Ʈ���� ��ȸ�� ������, ������ ������� �ʴٸ�, �����Ѵ�
				p = stack.pop();//pop�� �����Ͽ� �θ��带 ����Ų��.
				p = p.right;//�θ����� ������ �ڽ����� �����͸� �Űܰ���.
			}
		}
	}
	
	public BTree copy() {
		BTree newTree = new BTree();
		newTree.root = theCopy(root);//��Ʈ�� �����Ͽ� ���ο� ����Ʈ���� �����Ѵ�.
		return newTree;
	}
	private TreeNode theCopy(TreeNode T) {
		if(T==null)//��尡 ����ִٸ� null���� �����Ѵ�.
			return null;
		//�����ڽ�,�������ڽ��� ������ �Ŀ� ���ο� ��带 �����Ͽ� ������ ���� ������ ��带 �����Ѵ�.
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
		//�Ѵ� ��� ����ִ� ����� ������ �����Ѵ�.
		if(S == null && T== null)
			return true;
		//��Ʈ�� �����͵� ����, ����, ������ ����Ʈ���� ��ȯ �Լ��� ����Ͽ� �������� ���� �� ������ ��� �´ٸ� ������ �����Ѵ�.
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
