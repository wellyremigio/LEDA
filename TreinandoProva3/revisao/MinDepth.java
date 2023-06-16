package revisao;

public class MinDepth {
	
	public int minDepth(BSTNode<Integer> node) {
		if(node == null || node.isEmpty()) {
			return 0;
		}
		if(node.getLeft() != null && node.getRight() != null) {
			return  min(minDepth(node.getLeft()), minDepth(node.getRight())) + 1;
		}else {
			return max(minDepth(node.getLeft()), minDepth(node.getRight())) + 1;
		}
		
	}
	
	private int min(int left, int right) {
		if(left < right) {
			return left;
		}
		return right;
	}
	
	private int max(int left, int right) {
		if(left > right) {
			return left;
		}
		return right;
	}
	
	public static void main(String[] args) {
		BSTNode<Integer> n1 = new BSTNode<>();
		BSTNode<Integer> n2 = new BSTNode<>();
		BSTNode<Integer> n3 = new BSTNode<>();
		BSTNode<Integer> n4 = new BSTNode<>();
		BSTNode<Integer> n5 = new BSTNode<>();
		BSTNode<Integer> n6 = new BSTNode<>();
		//BSTNode<Integer> n7 = new BSTNode<>();

		
		n1.setData(5);
		n2.setData(3);
		n3.setData(10);
		n4.setData(7);
		n5.setData(11);
		n6.setData(2);
		//n7.setData(4);

		
		n1.setParent(new BSTNode<>());
		n1.setLeft(n2);
		n1.setRight(n3);
		
		n2.setParent(n1);
		n2.setLeft(n6);
		n2.setRight(new BSTNode<>());
		
		n3.setParent(n1);
		n3.setLeft(n4);
		n3.setRight(n5);
		
		n4.setParent(n3);
		n4.setLeft(new BSTNode<>());
		n4.setRight(new BSTNode<>());
		
		n5.setParent(n3);
		n5.setLeft(new BSTNode<>());
		n5.setRight(new BSTNode<>());
		
		n6.setParent(n2);
		n6.setLeft(new BSTNode<>());
		n6.setRight(new BSTNode<>());
		
		//n7.setParent(n2);
		//n7.setLeft(new BSTNode<>());
		//n7.setRight(new BSTNode<>());
		
		MinDepth e = new MinDepth();
		System.out.println(e.minDepth(n1));
	}
}
