package revisao;

import java.util.ArrayList;

import leetcode.EasyBST;

public class SortedArrayBST {
	
	public BSTNode<Integer> arrayToBST(Integer[] array){
		BSTNode<Integer> result = null;
		if(array != null && array.length > 0) {
			result = buildBST(array, 0, array.length-1);
		}
		return result;
	}
	
	private BSTNode<Integer> buildBST(Integer[] array, int left, int right){
		if(left > right) {
			return null;
		}
		int meio = (left+right) / 2;
		BSTNode<Integer> root = new BSTNode<>();
		root.setData(array[meio]);
		root.setLeft(buildBST(array, left, meio-1));
		root.setRight(buildBST(array, meio+1, right));
		return root;
	}
	
	
	public static void main(String[] args) {
		sortedArray();
	}
	public static void sortedArray() {
		EasyBST<Integer> e = new EasyBST<>();
		Integer[] array = {-10,-3,0,5,9};
		BSTNode<Integer> root = e.sortedArrayToBST(array);
		
		Integer[] retorno = preOrder(root);
		for(Integer i: retorno) {
			System.out.println(i);
		}
	}
	
	private static Integer[] preOrder(BSTNode<Integer> root) {
		ArrayList<Integer> list = new ArrayList<>();
		recursive(list, root);
		return (Integer[]) list.toArray(new Integer[list.size()]);
	}

	private static void recursive(ArrayList<Integer> list, BSTNode<Integer> node) {
		if(node != null && !node.isEmpty()) {
			list.add(node.getData());
			recursive(list, node.getLeft());
			recursive(list, node.getRight());
		}
	}
	

}
