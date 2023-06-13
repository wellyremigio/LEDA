package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int resposta = 0;
		if (!node.isEmpty()) {
			resposta = this.recursiveHeight((BSTNode<T>) node.getLeft()) - this.recursiveHeight((BSTNode<T>) node.getRight());
		}
		return resposta;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> novaRaiz = null;
		int balance = this.calculateBalance(node);
		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					novaRaiz = Util.rightRotation(node);
				} else {
					novaRaiz = Util.doubleRightRotation(node);
				}

			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					novaRaiz = Util.leftRotation(node);
				} else {
					novaRaiz = Util.doubleLeftRotation(node);
				}
			}
		}
		if (this.getRoot().equals(node) && novaRaiz != null) {
			this.root = novaRaiz;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
	
	public void insert(T element) {
		if (element != null) {
			this.recursiveInsert(element, getRoot());
		}
	}

	private void recursiveInsert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
		} else {
			if (element.compareTo(node.getData()) < 0) {
				recursiveInsert(element, (BSTNode<T>) node.getLeft());
			} else {
				recursiveInsert(element, (BSTNode<T>) node.getRight());
			}
			rebalance(node);
		}
	}
	
	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = this.search(element);

			if (!node.isEmpty()) {
				if (node.isLeaf()) { 
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
					rebalanceUp(node);
					
				} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) { 
					BSTNode<T> nodeFilho = node.getRight().isEmpty() ? (BSTNode<T>) node.getLeft() : (BSTNode<T>) node.getRight();
					if (this.root.equals(node)) {
						this.root = nodeFilho;
						this.root.setParent(null);
						
					} else {
						nodeFilho.setParent(node.getParent());
						if (node.getParent().getLeft().equals(node))
							node.getParent().setLeft(nodeFilho);
						
						else
							node.getParent().setRight(nodeFilho);
					}
					rebalanceUp(node);
				} else {
					T sucessor = this.sucessor(node.getData()).getData();
					this.remove(sucessor);
					node.setData(sucessor);
				}
			}
		}
	}
}
