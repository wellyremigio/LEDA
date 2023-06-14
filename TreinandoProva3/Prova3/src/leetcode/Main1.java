package leetcode;

import java.util.ArrayList;

import revisao.BSTImpl;
import revisao.BSTNode;

public class Main1 {

	public static void main(String[] args) {
		BSTImpl<Integer> t = new BSTImpl<>();
		EasyBST<Integer> e = new EasyBST<>();
		t.insert(4);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(3);
		t.insert(5);
		t.insert(7);
		//t.insert(7);
		//t.insert(9);
		
		
		//Métodos
		//sortedArray();
		//MinimumAbsoluteDiff(t.getRoot());
		//rangeSum(t.getRoot());
		//twoSum(t.getRoot());
		//increasingOrder(t);
		closest();
	
	}
	
	
	
	//Tested in a dumb way - OK
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
	
	//Tested - OK
	public static void MinimumAbsoluteDiff(BSTNode<Integer> root) {
		MinimumAbsoluteDiff min = new MinimumAbsoluteDiff();
		System.out.println(min.findMinDiff(root));
	}
	
	//Tested - OK
	public static void rangeSum(BSTNode<Integer> root) {
		SumRangeBST m = new SumRangeBST();
		System.out.println(m.rangeSum(root, 9, 11));
	}

	//Tested - OK
	public static void twoSum(BSTNode<Integer> root) {
		TwoSumBST t = new TwoSumBST();
		System.out.println(t.twoSum(root, 1000));
	}
	
	
	//Tested - Kinda OK
	public static void increasingOrder(BSTImpl<Integer> tree) {
		IncreasingOrder<Integer> in = new IncreasingOrder<Integer>();
		BSTNode<Integer>result = in.increasingOrder(tree.getRoot());
		
		while(result != null && result.getRight() != null && !result.getRight().isEmpty()) {
			System.out.println(result.getData());
			result = result.getRight();
		}
		
	}
	
	public static void closest() {
		Closest c = new Closest();
		Integer[] array = {5, 3, 1, 6, 8};
		System.out.println(c.closest(array, 7));
	}
	
	

}
