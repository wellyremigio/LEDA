package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return recursiveHeight(root, -1);
	}
	
	
	private int recursiveHeight(BSTNode<T> node, int height) {
		if(!node.isEmpty()) {
			int rightHeight = recursiveHeight((BSTNode<T>) node.getRight(), height + 1);
			int leftHeight = recursiveHeight((BSTNode<T>) node.getLeft(), height + 1);
			
			height = Math.max(rightHeight, leftHeight);
		}
		return height;
	}

	
	@Override
	public BSTNode<T> search(T element) {
		return recursiveSearch(element, root);
	}
	
	private BSTNode<T> recursiveSearch(T element, BSTNode<T> node){
		BSTNode<T> aux = node;
		if(element != null && !node.isEmpty()) {
			if(element.compareTo(node.getData()) < 0) {
				aux = recursiveSearch(element, (BSTNode<T>) node.getLeft());
				
			}else if(element.compareTo(node.getData()) > 0) {
				aux = recursiveSearch(element, (BSTNode<T>) node.getRight());
				
			}
		}
		return aux;
	}

	@Override
	public void insert(T element) {
		recursiveInsert(element, root);
	}
	
	private void recursiveInsert(T element, BSTNode<T> node) {
		if(!node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			
		}else {
			if(node.getData().compareTo(element) < 0) {
				recursiveInsert(element, (BSTNode<T>) node.getLeft());
				
			}else if(element.compareTo(node.getData()) > 0) {
				recursiveInsert(element, (BSTNode<T>) node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> resposta = null;
		if(!isEmpty()) {
			resposta = recursiveMax(root);
		}
		return resposta;
	}
	
	private BSTNode<T> recursiveMax(BSTNode<T> node) {
		BSTNode<T> aux = node;
		if(!node.getRight().isEmpty()) {
			aux = recursiveMax((BSTNode<T>) node.getRight());
		}
		return aux;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> resposta = null;
		if(!isEmpty()) {
			resposta = recursiveMin(root);
		}
		return resposta;
	}
	
	private BSTNode<T> recursiveMin(BSTNode<T> node){
		BSTNode<T> aux = node;
		if(!node.getLeft().isEmpty()) {
			aux = recursiveMin((BSTNode<T>) node.getLeft());
		}
		return aux;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> resposta = null;
		BSTNode<T> nodeElement = search(element);
		
		if(element != null && !nodeElement.isEmpty()) {
			
			if(!nodeElement.getRight().isEmpty()) {
				resposta = recursiveMin((BSTNode<T>) nodeElement.getRight());
				
			}else {
				BSTNode<T> parent = (BSTNode<T>) nodeElement.getParent();
				
				while(!parent.isEmpty() && nodeElement.equals(parent.getRight())) {
					nodeElement = parent;
					parent = (BSTNode<T>) nodeElement.getParent();
				}
				resposta = parent;
			}
		}
		return resposta;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> resposta = null;
		BSTNode<T> nodeElement = search(element);
		
		if(element != null && !nodeElement.isEmpty()) {
			
			if(!nodeElement.getLeft().isEmpty()) {
				resposta = recursiveMax((BSTNode<T>) nodeElement.getLeft());
				
			}else {
				BSTNode<T> parent = (BSTNode<T>) nodeElement.getParent();
				
				while(!parent.isEmpty() && nodeElement.equals(parent.getLeft())) {
					nodeElement = parent;
					parent = (BSTNode<T>) nodeElement.getParent();
				}
				resposta = parent;
			}
		}
		return resposta;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
		
	}
	
	private void remove(BSTNode<T> node) {
		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				node.setData(null);
				
			}else if(hasOneChild(node)) { 
				if(node.getParent() != null) {
					if(node.getParent().getData().compareTo(node.getData()) > 0) {
						if(!node.getLeft().isEmpty()) {
							
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
							
						}else {
							
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}else {
						if(!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
					
				}else {
					if(node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					}else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}
				
			}else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}
	}
	
	private boolean hasOneChild(BSTNode<T> node) {
		boolean resposta = false;
		if((node.getLeft().isEmpty() && !node.getRight().isEmpty()) || (!node.getLeft().isEmpty() && node.getRight().isEmpty())) {
			resposta = true;
		}
		return resposta;
		
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}
