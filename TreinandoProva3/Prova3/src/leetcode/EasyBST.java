package leetcode;

import java.util.ArrayList;

import revisao.BSTImpl;
import revisao.BSTNode;

public class EasyBST<T extends Comparable<T>> extends BSTImpl<T>{
	
	//Converter um array ordenado em uma árvore balanceada
	public BSTNode<T> sortedArrayToBST(T[] array){
		BSTNode<T> result = null;
		if(array != null && array.length > 0) {
			result = recursiveSorted(array, 0, array.length-1);
		}
		return result;
	}
	
	private BSTNode<T> recursiveSorted(T[] array, int left, int right){
		if(left > right) {
			return null;
		}
			
		int middle = (left + right) / 2;
		BSTNode<T> root = new BSTNode<>();
		root.setData(array[middle]);
		root.setLeft(recursiveSorted(array, left, middle-1));
		root.setRight(recursiveSorted(array, middle+1, right));
		return root;
	}

}
