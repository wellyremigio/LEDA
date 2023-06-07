package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer resposta = null;
		if(array != null && array.length > 0) {
			for(Integer num: array) {
				insert(num);
			}
			resposta = recursiveFloor(getRoot(), numero, resposta);
		}
		return resposta;
	}
	
	
	private Integer recursiveFloor(BSTNode<Integer> node, double numero, Integer floor) {
		if(!node.isEmpty()) {
			if(numero > node.getData()) {
				floor = recursiveFloor((BSTNode<Integer>) node.getRight(), numero, node.getData());
				
			}else if(numero < node.getData()) {
				floor = recursiveFloor((BSTNode<Integer>) node.getLeft(), numero, floor);
				
			}else {
				floor = node.getData();
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer resposta = null;
		if(array != null && array.length > 0) {
			for(Integer num: array) {
				insert(num);
			}
			resposta = recursiveCeil(getRoot(), numero, resposta);
		}
		return resposta;
	}
	
	private Integer recursiveCeil(BSTNode<Integer> node, double numero, Integer ceil) {
		if(!node.isEmpty()) {
			if(numero < node.getData()) {
				ceil = recursiveCeil((BSTNode<Integer>) node.getLeft(), numero, node.getData());
				
			}else if(numero > node.getData()) {
				ceil = recursiveCeil((BSTNode<Integer>) node.getRight(), numero, ceil);
				
			}else {
				ceil = node.getData();
			}
		}
		return ceil;
	}
}
