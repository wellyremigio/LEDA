package leetcode;

import revisao.BSTNode;

public class SumRangeBST {
	
	public int rangeSum(BSTNode<Integer> root, int low, int high) {
		return recursiveSum(root, low, high);
	}
	
	private int recursiveSum(BSTNode<Integer> node, int low, int high) {
		int soma = 0;
		if(node != null && !node.isEmpty()) {
			if(node.getData() > low) {
				soma += recursiveSum(node.getLeft(), low, high);
			}
			if(node.getData() < high) {
				soma += recursiveSum(node.getRight(), low, high);
			}
			if(node.getData() >= low && node.getData() <= high) {
				soma += node.getData();
			}
		}
		return soma;
	}
}
