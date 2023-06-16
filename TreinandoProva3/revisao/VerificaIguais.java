package revisao;

import leetcode.EqualsBST;

public class VerificaIguais {
	
	public boolean ehIgual(BSTNode<Integer> root1, BSTNode<Integer> root2) {
		boolean resposta = false;
		if(!root1.isEmpty() && !root2.isEmpty()) {
			resposta = rec(root1, root2);
		}
		return resposta;
	}
	
	private boolean rec(BSTNode<Integer> node1, BSTNode<Integer> node2) {
		boolean resposta = false;
		
		if(node1.isEmpty() && node2.isEmpty()) {
			resposta = true;
			
		}else if(!node1.isEmpty() && !node2.isEmpty()) {
			
			if(node1.getData().equals(node2.getData())) {
				resposta = rec(node1.getLeft(), node2.getLeft()) && rec(node1.getRight(), node2.getRight());
			}
		}
		return resposta;
	}
	
	public static void main(String[] args) {
		BSTNode<Integer> n1 = new BSTNode<>();
		BSTNode<Integer> n2 = new BSTNode<>();
		BSTNode<Integer> n3 = new BSTNode<>();
		BSTNode<Integer> n4 = new BSTNode<>();
		BSTNode<Integer> n5 = new BSTNode<>();
		BSTNode<Integer> n6 = new BSTNode<>();
		BSTNode<Integer> n7 = new BSTNode<>();
		
		BSTNode<Integer> c1 = new BSTNode<>();
		BSTNode<Integer> c2 = new BSTNode<>();
		BSTNode<Integer> c3 = new BSTNode<>();
		BSTNode<Integer> c4 = new BSTNode<>();
		BSTNode<Integer> c5 = new BSTNode<>();
		BSTNode<Integer> c6 = new BSTNode<>();
		BSTNode<Integer> c7 = new BSTNode<>();

		
		n1.setData(5);
		n2.setData(2);
		n3.setData(10);
		n4.setData(7);
		n5.setData(11);
		n6.setData(1);
		n7.setData(3);
		
		c1.setData(5);
		c2.setData(2);
		c3.setData(10);
		c4.setData(7);
		c5.setData(11);
		c6.setData(1);
		c7.setData(4);

		
		n1.setParent(new BSTNode<>());
		n1.setLeft(n2);
		n1.setRight(n3);
		
		c1.setParent(new BSTNode<>());
		c1.setLeft(c2);
		c1.setRight(c3);
		
		n2.setParent(n1);
		n2.setLeft(n6);
		n2.setRight(n7);
		
		c2.setParent(c1);
		c2.setLeft(c6);
		c2.setRight(c7);
		
		n3.setParent(n1);
		n3.setLeft(n4);
		n3.setRight(n5);
		
		c3.setParent(c1);
		c3.setLeft(c4);
		c3.setRight(c5);
		
		n4.setParent(n3);
		n4.setLeft(new BSTNode<>());
		n4.setRight(new BSTNode<>());
		
		c4.setParent(c3);
		c4.setLeft(new BSTNode<>());
		c4.setRight(new BSTNode<>());
		
		n5.setParent(n3);
		n5.setLeft(new BSTNode<>());
		n5.setRight(new BSTNode<>());
		
		c5.setParent(c3);
		c5.setLeft(new BSTNode<>());
		c5.setRight(new BSTNode<>());
		
		n6.setParent(n2);
		n6.setLeft(new BSTNode<>());
		n6.setRight(new BSTNode<>());
		
		c6.setParent(c2);
		c6.setLeft(new BSTNode<>());
		c6.setRight(new BSTNode<>());
		
		n7.setParent(n2);
		n7.setLeft(new BSTNode<>());
		n7.setRight(new BSTNode<>());
		
		c7.setParent(c2);
		c7.setLeft(new BSTNode<>());
		c7.setRight(new BSTNode<>());
		
		EqualsBST e = new EqualsBST();
		System.out.println(e.equals(n1, c1));
	}
}
