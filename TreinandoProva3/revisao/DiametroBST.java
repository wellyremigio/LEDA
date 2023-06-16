package revisao;

public class DiametroBST {
	
	int resposta = 0;
	private int height(BSTNode<Integer> node) {
		if(node == null || node.isEmpty()) {
			return 0;
		}
		int left = height(node.getLeft());
		int right = height(node.getRight());
		
		resposta = max(resposta, left+right);
		return 1 + max(left, right);
	}
	
	public int diametro(BSTNode<Integer> root) {
		height(root);
		return resposta;
	}
	
	private int max(int a, int b) {
		if(a > b) {
			return a;
		}
		return b;
	}
	
	
	public static void main(String[] args) {
		BSTNode<Integer> n1 = new BSTNode<>();
		BSTNode<Integer> n2 = new BSTNode<>();
		BSTNode<Integer> n3 = new BSTNode<>();
		BSTNode<Integer> n4 = new BSTNode<>();
		BSTNode<Integer> n5 = new BSTNode<>();
		BSTNode<Integer> n6 = new BSTNode<>();
		BSTNode<Integer> n7 = new BSTNode<>();
		BSTNode<Integer> n8 = new BSTNode<>();

		
		n1.setData(5);
		n2.setData(3);
		n3.setData(10);
		n4.setData(9);
		n5.setData(11);
		n6.setData(8);
		n7.setData(7);
		n8.setData(4);

		
		n1.setParent(new BSTNode<>());
		n1.setLeft(n2);
		n1.setRight(n3);
		
		n2.setParent(n1);
		n2.setLeft(new BSTNode<>());
		n2.setRight(n8);
		
		n3.setParent(n1);
		n3.setLeft(n4);
		n3.setRight(n5);
		
		n4.setParent(n3);
		n4.setLeft(n6);
		n4.setRight(new BSTNode<>());
		
		n5.setParent(n3);
		n5.setLeft(new BSTNode<>());
		n5.setRight(new BSTNode<>());
		
		n6.setParent(n4);
		n6.setLeft(n7);
		n6.setRight(new BSTNode<>());
		
		n7.setParent(n6);
		n7.setLeft(new BSTNode<>());
		n7.setRight(new BSTNode<>());
		
		n8.setParent(n2);
		n8.setLeft(new BSTNode<>());
		n8.setRight(new BSTNode<>());
		
		DiametroBST v = new DiametroBST();
		System.out.println(v.diametro(n1));
		
	}

}
