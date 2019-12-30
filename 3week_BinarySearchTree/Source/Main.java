package BSTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST aBST = new BST();
		System.out.println("[INFO] Insert ===");
		
		aBST.insert(15);
		aBST.insert(11);
		aBST.insert(70);
		aBST.insert(5);
		aBST.insert(13);
		aBST.insert(50);
		aBST.show();
		
		System.out.println("[INFO] Search ===");
		
		aBST.search(50);
		
		System.out.println("[INFO] Delete ===");
		aBST.delete(11);
		aBST.show();
		
		BST bBST = new BST();
		BST cBST = new BST();
		
		System.out.println("[INFO] Split ===");
		aBST.split(bBST, cBST, 13);
		System.out.println("left tree");
		bBST.show();
		
		System.out.println("right tree");
		cBST.show();
		
	}

}
