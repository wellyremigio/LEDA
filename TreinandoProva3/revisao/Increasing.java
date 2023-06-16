package revisao;

import java.util.ArrayList;

public class Increasing<T extends Comparable<T>> {
	
	public BSTNode<T> increasingOrder(BSTNode<T> root){
		ArrayList<T> list = new ArrayList<>();
		order(root, list);
		return buildTree(list);
	}
	
	private void order(BSTNode<T> node, ArrayList<T> list) {
		if(node != null && !node.isEmpty()) {
			order(node.getLeft(), list);
			list.add(node.getData());
			order(node.getRight(), list);
		}
	}
	
	private BSTNode<T> buildTree(ArrayList<T> list){
		if(list.size() == 0) {
			return null;
		}
		BSTNode<T> root = new BSTNode<>(list.remove(0));
		root.setRight(buildTree(list));
		return root;
	}
	
	public static void main(String[] args) {
		BSTNode<Integer> n1 = new BSTNode<>();
		BSTNode<Integer> n2 = new BSTNode<>();
		BSTNode<Integer> n3 = new BSTNode<>();
		BSTNode<Integer> n4 = new BSTNode<>();
		BSTNode<Integer> n5 = new BSTNode<>();
		BSTNode<Integer> n6 = new BSTNode<>();
		BSTNode<Integer> n7 = new BSTNode<>();

		
		n1.setData(60);
		n2.setData(20);
		n3.setData(200);
		n4.setData(150);
		n5.setData(1000);
		n6.setData(13);
		n7.setData(35);

		
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
		
		Increasing<Integer> e = new Increasing();
		BSTNode<Integer> ancestral = e.increasingOrder(n1) ;
		System.out.println(ancestral.getData());
	}
}
