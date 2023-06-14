package leetcode;

public class TesteMain {
	/*
	 * package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(2);
		tree.insert(4);
		tree.insert(1);
		tree.insert(8);
		tree.insert(7);
		tree.insert(9);
		System.out.println("Busca em largura:");
		buscaEmLargura(tree);
		System.out.println();
		System.out.println();
		System.out.println("Increasing Order:");
		increasingOrder(tree);
		System.out.println();
		System.out.println();
		System.out.println("Range sum:");
		rangeSum(tree);
		System.out.println();
		System.out.println("Search in BST:");
		searchBST(tree);
	}
	
	private static void searchBST(Tree<Integer> tree) {
		SearchInBST search = new SearchInBST();
		TreeNode<Integer> result = search.searchBST(tree.getRoot(), 3);
		
		
	}
	
	private static void increasingOrder(Tree<Integer> tree) {
		OrdenateTree order = new OrdenateTree();
		TreeNode<Integer> result = order.increasingOrder(tree.getRoot());
		
		while (result != null && result.getRight() != null && !result.getRight().isEmpty()) {
			System.out.print(result.getData() + " ");
			result = result.getRight();
		}
	}
	
	private static void rangeSum(Tree<Integer> tree) {
		RangeSum rangeSum = new RangeSum();
		System.out.println(rangeSum.rangeSumBST(tree.getRoot(), 0, 11));
	}
	
	private static void buscaEmLargura(Tree<Integer> tree) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (!tree.isEmpty()) {
			queue.add(tree.getRoot());
			
			while (!queue.isEmpty()) {
				TreeNode<Integer> current = queue.remove();
				System.out.print(current.getData() + " ");
				
				if (!current.getLeft().isEmpty()) {
					queue.add(current.getLeft());
				}
				if (!current.getRight().isEmpty()) {
					queue.add(current.getRight());
				}
			}
		}
	}
	
}

	 */

}
