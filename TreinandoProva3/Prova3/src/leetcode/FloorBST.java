package leetcode;

import revisao.BSTImpl;
import revisao.BSTNode;

public class FloorBST extends BSTImpl<Integer> {
	
	public Integer floor(Integer[] array, int numero) {
		Integer resposta = null;
		if(array != null && array.length > 0) {
			for(Integer i: array) {
				insert(i);
			}
			resposta = recursive(getRoot(), numero, resposta);
		}
		return resposta;
	}
	
	private Integer recursive(BSTNode<Integer> node, int numero, Integer floor) {
		if(!node.isEmpty()) {
			if(numero > node.getData()) {
				floor = recursive(node.getRight(), numero, node.getData());
				
			}else if(numero < node.getData()) {
				floor = recursive(node.getLeft(), numero, floor);
				
			}else {
				floor = node.getData();
			}
		}
		return floor;
	}
}
