package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return (this.bst.isEmpty() || this.isBST(this.bst.getRoot()));
	}

	private boolean isBST (BTNode<T> node){
		boolean resposta = true;

	    if (!node.isEmpty()) {
            if (this.verificacaoEsq(node) && this.verificacaoDir(node)) {
            	resposta = this.isBST(node.getLeft()) && this.isBST(node.getRight());
            	
			}else{
				resposta = false;
			}

		}return resposta;
	}
	
	private boolean verificacaoEsq (BTNode<T> node) {
        return this.verificacaoEsqRecursivo(node.getLeft(), node);
    }

    private boolean verificacaoEsqRecursivo (BTNode<T> node, BTNode<T> root) {
        boolean resposta = true;

        if (!node.isEmpty()){
            if (node.getData().compareTo(root.getData()) < 0){
            	resposta = this.verificacaoEsqRecursivo(node.getLeft(), root) && this.verificacaoEsqRecursivo(node.getRight(), root);
            	
			}else{
				resposta = false;

			}
		}
		return resposta;
	}
    
    private boolean verificacaoDir (BTNode<T> node) {
        return this.verificacaoDirRecursivo(node.getRight(), node);
    }

    private boolean verificacaoDirRecursivo (BTNode<T> node, BTNode<T> root) {
        boolean resposta = true;

        if (!node.isEmpty()) {
            if (node.getData().compareTo(root.getData()) > 0) {
            	resposta = this.verificacaoDirRecursivo(node.getLeft(), root) && this.verificacaoDirRecursivo(node.getRight(), root);
            	
			}else{
				resposta = false;

			}
		}return resposta;
    }
}
