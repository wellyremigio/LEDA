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
		if(this.isEmpty()) {
			return 0;
		}
		return 1 + this.getNext().size();
	}
	

	@Override
	public T search(T element) {
		T resposta = null;
		if(element != null && !this.isEmpty()) {
			if(this.getData().equals(element)) {
				resposta = this.getData();
				
			}else {
				resposta = this.getNext().search(element);
			}
		}
		return resposta;
	}

	
	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<>());
				
			}else {
				this.getNext().insert(element);
			}
		}
	}

	
	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			if(this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				
			}else {
				this.getNext().remove(element);
			}
		}
	}
	

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		this.toArray(array, 0);
		return array;
	}
	
	private void toArray(T[] array, int cont) {
		if(!this.isEmpty()) {
			array[cont] = this.getData();
			this.getNext().toArray(array, cont+1);
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
