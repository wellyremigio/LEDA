package leetcode;

import java.util.ArrayList;
import java.util.List;

import revisao.BSTNode;

public class MinimumAbsoluteDiff {
	
	int min = 10000;
	BSTNode<Integer> prev = null;
	
	private void order(BSTNode<Integer> node) {
		if(node != null && !node.isEmpty()) {
			order((BSTNode<Integer>) node.getLeft());
			if(prev != null) {
				int diff = node.getData() - prev.getData();
				if(diff < min) {
					min = diff;
				}
			}
			prev = node;
			order((BSTNode<Integer>) node.getRight());
		}
	}
	
	
	public int findMinDiff(BSTNode<Integer> root) {
		order(root);
		return min;
	}
}
