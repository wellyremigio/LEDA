package treinandoProva;

public class CircularLinkedListNode<T> {
	T data;
	CircularLinkedListNode<T> next;
	
	public CircularLinkedListNode(T data) {
		this.data = data;
	}
	
	public CircularLinkedListNode() {
	}

	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public CircularLinkedListNode<T> getNext(){
		return this.next;
	}
	
	public void setNext(CircularLinkedListNode<T> next) {
		this.next = next;
	}
	
	public boolean isNIL() {
		return this.data == null;
	}
}
