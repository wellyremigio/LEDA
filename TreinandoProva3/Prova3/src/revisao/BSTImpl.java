package revisao;

import java.util.ArrayList;

public class BSTImpl <T extends Comparable<T>>{
	
	protected BSTNode<T> root;
	
	public BSTImpl() {
		this.root = new BSTNode<>();
	}
	
	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	public boolean isEmpty() {
		return this.root.isEmpty();
	}
	
	public int height() {
		return recursiveHeight(getRoot());
	}
	
	private int recursiveHeight(BSTNode<T> node) {
		int altura = -1;
		if(!node.isEmpty()) {
			//Pega o máx entre left e right e soma 1
			altura = 1 + Math.max(recursiveHeight((BSTNode<T>) node.getLeft()), recursiveHeight((BSTNode<T>) node.getRight()));
		}
		return altura;
	}
	
	public BSTNode<T> search(T element){
		return recursiveSearch(element, getRoot());
	}
	
	private BSTNode<T> recursiveSearch(T element, BSTNode<T> node){
		BSTNode<T> aux = node;
		if(element != null && !node.isEmpty()) {
			
			//Se element < node, pesquisa na esquerda
			if(element.compareTo(node.getData()) < 0) {
				aux = recursiveSearch(element, (BSTNode<T>) node.getLeft());
			}
			//Se element > node, pesquisa na direita
			else if(element.compareTo(node.getData()) > 0) {
				aux = recursiveSearch(element, (BSTNode<T>) node.getRight());
			}
		}
		return aux;
	}
	
	public void insert(T element) {
		if(element != null && search(element).isEmpty()) {
			recursiveInsert(element, getRoot());
		}
	}
	
	private void recursiveInsert(T element, BSTNode<T> node) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			
		}else {
			if(element.compareTo(node.getData()) < 0) {
				recursiveInsert(element, (BSTNode<T>) node.getLeft());
				
			}else if(element.compareTo(node.getData()) > 0) {
				recursiveInsert(element, (BSTNode<T>) node.getRight());
			}
		}
	}
	
	public BSTNode<T> max(){
		BSTNode<T> max = null;
		if(!isEmpty()) {
			max = recursiveMax(getRoot());
		}
		return max;
	}
	
	private BSTNode<T> recursiveMax(BSTNode<T> node){
		BSTNode<T> aux = node;
		if(!node.getRight().isEmpty()) {
			aux = recursiveMax((BSTNode<T>) node.getRight());
		}
		return aux;
	}
	
	public BSTNode<T> min(){
		BSTNode<T> min = null;
		if(!isEmpty()) {
			min = recursiveMin(getRoot());
		}
		return min;
	}
	
	private BSTNode<T> recursiveMin(BSTNode<T> node){
		BSTNode<T> aux = node;
		if(!node.getLeft().isEmpty()) {
			aux = recursiveMin((BSTNode<T>) node.getLeft());
		}
		return aux;
	}
	
	public BSTNode<T> sucessor(T element){
		BSTNode<T> resposta = null;
		BSTNode<T> nodeElement = search(element);
		
		if(element != null && !nodeElement.isEmpty()) {
			
			if(!nodeElement.getRight().isEmpty()) {
				resposta = recursiveMin((BSTNode<T>) nodeElement.getRight());
				
			}else {
				BSTNode<T> parent = (BSTNode<T>) nodeElement.getParent();
				while(parent != null && nodeElement.equals(parent.getRight())) {
					nodeElement = parent;
					parent = (BSTNode<T>) nodeElement.getParent();
				}
				resposta = parent;
			}
		}
		return resposta;
	}
	
	public BSTNode<T> predecessor(T element){
		BSTNode<T> resposta = null;
		BSTNode<T> node = search(element);
		
		if(element != null && !node.isEmpty()) {
			
			if(!node.getLeft().isEmpty()) {
				resposta = recursiveMax((BSTNode<T>) node.getLeft());
				
			}else {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
				while(parent != null && node.equals(parent.getLeft())) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();
				}
				resposta = parent;
			}
		}
		return resposta;
	}
	
	
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		recursivePreOrder(list, getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}
	
	private void recursivePreOrder(ArrayList<T> list, BSTNode<T> node) {
		if(node != null && !node.isEmpty()) {
			list.add(node.getData());
			recursivePreOrder(list, (BSTNode<T>) node.getLeft());
			recursivePreOrder(list, (BSTNode<T>) node.getRight());
		}
	}
	
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		recursiveOrder(list, getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}
	
	public void recursiveOrder(ArrayList<T> list, BSTNode<T> node) {
		if(node != null && !node.isEmpty()) {
			recursiveOrder(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			recursiveOrder(list, (BSTNode<T>) node.getRight());
		}
	}
	
	
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		recursivePostOrder(list, getRoot());
		return (T[]) list.toArray(new Comparable[list.size()]);
	}
	
	private void recursivePostOrder(ArrayList<T> list, BSTNode<T> node) {
		if(node != null && !node.isEmpty()) {
			recursivePostOrder(list, (BSTNode<T>) node.getLeft());
			recursivePostOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
		}
	}
	
	public int size() {
		return recursiveSize(getRoot());
	}
	
	private int recursiveSize(BSTNode<T> node) {
		int size = 0;
		if(!node.isEmpty()) {
			size = 1 + recursiveSize((BSTNode<T>) node.getLeft()) + recursiveSize((BSTNode<T>) node.getRight());
		}
		return size;
	}
	
	
	
}
