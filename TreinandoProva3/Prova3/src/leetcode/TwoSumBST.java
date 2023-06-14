package leetcode;

import revisao.BSTNode;

public class TwoSumBST {
	
	public boolean twoSum(BSTNode<Integer> root, int k) {
		return run(root, root, k);
	}
	
	private boolean run(BSTNode<Integer> root, BSTNode<Integer> current, int k) {
		if(current == null || current.isEmpty()) {
			return false;
		}
		if(find(root, k-current.getData(), current)) {
			return true;
		}
		return run(root, current.getLeft(), k) || run(root, current.getRight(), k);
	}
	
	private boolean find(BSTNode<Integer> node, int val, BSTNode<Integer> current) {
		if(node == null || node.isEmpty()) {
			return false;
		}
		if(val > node.getData()) {
			return find(node.getRight(), val, current);
			
		}else if(val < node.getData()) {
			return find(node.getLeft(), val, current);
			
		}else if(val == node.getData()) {
			return node != current;
		}
		return false;
	}
}
