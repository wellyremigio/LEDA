package leetcode;

import revisao.BSTImpl;
import revisao.BSTNode;

public class Ceil extends BSTImpl<Integer> {
	
	public Integer ceil(Integer[] array, int num) {
		Integer resposta = null;
		if(array != null && array.length > 0) {
			for(Integer i: array) {
				insert(i);
			}
			resposta = recursive(getRoot(), num, resposta);
		}
		return resposta;
	}
	
	private Integer recursive(BSTNode<Integer> node, int num, Integer ceil) {
		if(!node.isEmpty()) {
			if(num > node.getData()) {
				ceil = recursive(node.getRight(), num, ceil);
				
			}else if(num < node.getData()) {
				ceil = recursive(node.getLeft(), num, node.getData());
				
			}else {
				ceil = node.getData();
			}
		}
		return ceil;
	}
}
