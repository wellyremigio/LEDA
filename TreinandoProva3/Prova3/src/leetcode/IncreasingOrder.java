package leetcode;

import java.util.ArrayList;

import revisao.BSTImpl;
import revisao.BSTNode;

public class IncreasingOrder<T extends Comparable<T>> {
	
	public BSTNode<T> increasingOrder(BSTNode<T> root){
		ArrayList<T> list = new ArrayList<>();
		inOrder(root, list);
		return buildBSTImpl(list);
	}
	
	private void inOrder(BSTNode<T> node, ArrayList<T> list) {
		if(node != null && !node.isEmpty()) {
			inOrder(node.getLeft(), list);
			list.add(node.getData());
			inOrder(node.getRight(), list);
		}
	}
	
	private BSTNode<T> buildBSTImpl(ArrayList<T> list){
		if(list.size() == 0) {
			return null;
		}
		BSTNode<T> root = new BSTNode(list.remove(0));
		root.setRight(buildBSTImpl(list));
		return root;
	}
}
