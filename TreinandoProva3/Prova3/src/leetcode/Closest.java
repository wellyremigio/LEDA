package leetcode;

import revisao.BSTImpl;
import revisao.BSTNode;

public class Closest extends BSTImpl<Integer> {
	
	public Integer closest(Integer[] array, int n) {
		Integer resposta = null;
		if(array != null && array.length > 0) {
			for(Integer i: array) {
				insert(i);
			}
			Integer floor = recursiveFloor(getRoot(), n, resposta);
			Integer ceil = recursiveCeil(getRoot(), n, resposta);
			
			int diffF = n - floor;
			int diffC = ceil - n;
			
			if(diffF <= diffC) {
				resposta = floor;
				
			}else{
				resposta = ceil;
			}
		}
		return resposta;
	}
	
	private Integer recursiveFloor(BSTNode<Integer> node, int n, Integer floor) {
		if(!node.isEmpty()) {
			if(n < node.getData()) {
				floor = recursiveFloor(node.getLeft(), n, floor);
				
			}else if(n > node.getData()) {
				floor = recursiveFloor(node.getRight(), n, node.getData());
				
			}else {
				floor = node.getData();
			}
		}
		return floor;
	}
	
	private Integer recursiveCeil(BSTNode<Integer> node, int n, Integer ceil) {
		if(!node.isEmpty()) {
			if(n > node.getData()) {
				ceil = recursiveCeil(node.getRight(), n, ceil);
				
			}else if(n < node.getData()) {
				ceil = recursiveCeil(node.getLeft(), n, node.getData());
				
			}else {
				ceil = node.getData();
			}
		}
		return ceil;
	}
}
