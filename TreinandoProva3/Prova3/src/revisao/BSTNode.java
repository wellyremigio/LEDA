package revisao;

public class BSTNode <T>{
	protected T data;
	protected BSTNode<T> parent;
	protected BSTNode<T> left;
	protected BSTNode<T> right;

	public BSTNode(T data) {
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode() {
		this.data = null;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	public boolean isEmpty() {
		return this.data == null;
	}
	
	public boolean isLeaf() {
		return !this.isEmpty() && this.left.isEmpty() && this.right.isEmpty();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNode<T> getParent() {
		return parent;
	}

	public void setParent(BSTNode<T> parent) {
		this.parent = parent;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}
