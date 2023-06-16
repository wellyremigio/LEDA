package revisao;

public class Cousins {
	
	BSTNode<Integer> xParent;
	BSTNode<Integer> yParent;
	int xHeight;
	int yHeight;
	
	public boolean cousins(BSTNode<Integer> root, BSTNode<Integer> x, BSTNode<Integer> y) {
		information(root, x, y, 0, null);
		if(xHeight == yHeight && xParent != yParent) {
			return true;
		}else {
			return false;
		}
	}
	
	private void information(BSTNode<Integer> node, BSTNode<Integer> x, BSTNode<Integer> y, int height, BSTNode<Integer> prev) {
		if(node != null && !node.isEmpty()) {
			if(node.getData() == x.getData()) {
				xParent = prev;
				xHeight = height;
			}
			if(node.getData() == y.getData()) {
				yParent = prev;
				yHeight = height;
			}
			prev = node;
			information(node.getLeft(), x, y, height++, prev);
			height--;
			information(node.getRight(), x, y, height++, prev);
		}
	}
	
	public static void main(String[] args) {
		BSTNode<Integer> n1 = new BSTNode<>();
		BSTNode<Integer> n2 = new BSTNode<>();
		BSTNode<Integer> n3 = new BSTNode<>();
		BSTNode<Integer> n4 = new BSTNode<>();
		BSTNode<Integer> n5 = new BSTNode<>();
		BSTNode<Integer> n6 = new BSTNode<>();
		BSTNode<Integer> n7 = new BSTNode<>();

		
		n1.setData(5);
		n2.setData(3);
		n3.setData(10);
		n4.setData(7);
		n5.setData(11);
		n6.setData(2);
		n7.setData(4);

		
		n1.setParent(new BSTNode<>());
		n1.setLeft(n2);
		n1.setRight(n3);
		
		n2.setParent(n1);
		n2.setLeft(n6);
		n2.setRight(n7);
		
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
		
		n7.setParent(n2);
		n7.setLeft(new BSTNode<>());
		n7.setRight(new BSTNode<>());
		
		Cousins e = new Cousins();
		System.out.println(e.cousins(n1, n4, n7));
	}

}
