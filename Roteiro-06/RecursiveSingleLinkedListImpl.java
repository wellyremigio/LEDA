package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		int size = 0;
		while(!this.isEmpty()) {
			size = 1 + this.next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T resposta = null;
		if(element != null && !this.isEmpty()) {
			if(this.getData().equals(element)) {
				resposta = this.data;
				
			}else {
				this.next.search(element);
			}
		}
		return resposta;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.isEmpty()) {
				this.setData(element);
				this.next = new RecursiveSingleLinkedListImpl<>();
				
			}else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			if(this.getData().equals(element)) {
				this.setData(this.next.getData());
				this.setNext(this.next.getNext());
				
			}else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size()];
		toArrayAux(array, 0);
		return array;
	}
	
	private void toArrayAux(T[] array, int cont) {
		if(!this.isEmpty()) {
			array[cont] = this.getData();
			cont++;
			toArrayAux(array, cont);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}
