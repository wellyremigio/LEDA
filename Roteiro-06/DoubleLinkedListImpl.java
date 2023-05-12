package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	
	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
			newHead.setData(element);
			newHead.setNext(this.getHead());
			newHead.setPrevious(new DoubleLinkedListNode<T>());
			((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);
			newHead.getPrevious().setNext(newHead);
			
			if(this.getHead().isNIL()) {
				last = newHead;
			}
			head = newHead;
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			if(!this.head.isNIL()) {
				this.head = this.head.getNext();
				
				if(this.head.isNIL()) {
					this.last = (DoubleLinkedListNode<T>) this.head;
					
				}else {
					((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty() && !this.last.isNIL()) {
			this.last = last.previous;
			
			if(this.last.isNIL()) {
				this.head = this.last;
				
			}else {
				last.next = new DoubleLinkedListNode<>();
			}
		}
	}
	
	@Override
	public T search(T element) {
		T resposta = null;
		if(element != null && !this.isEmpty()) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
			DoubleLinkedListNode<T> auxLast = this.last;
			
			while((!auxHead.equals(auxLast)) && (!auxHead.getNext().equals(auxLast)) && (!auxHead.getData().equals(element)) && (!auxLast.getData().equals(element))) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
				
			}
			
			if(auxHead.getData().equals(element)) {
				resposta = auxHead.getData();
			}
			
			if(auxLast.getData().equals(element)) {
				resposta = auxLast.getData();
			}
		}
		return resposta;
	}
	
	@Override
	public void insert(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			
			newLast.setPrevious(this.last); // last <----- newLast
			newLast.setNext(new DoubleLinkedListNode<>()); // newLast -----> NIL
			this.last.setNext(newLast); // last -----> newLast
			((DoubleLinkedListNode<T>) newLast.getNext()).setPrevious(newLast); //newLast <----- NIL
			
			if(this.getLast().isNIL()) {
				this.head = newLast;
			}
			this.last = newLast;
		}
	}
	
	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()) {
			if(this.head.getData().equals(element)) {
				removeFirst();
			}else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
				while(!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				
				if(!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}
