package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}

	
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
			newHead.setData(element);
			newHead.setPrevious(new DoubleLinkedListNode<>());
			newHead.setNext(this.getHead()); 
			((DoubleLinkedListNode<T>) head).setPrevious(newHead);
			newHead.getPrevious().setNext(newHead);
			
			if(this.head.isNIL()) {
				this.setLast(newHead);;
			}
			this.setHead(newHead);
		}
	}

	
	@Override
	public void removeFirst() {
		if(!this.isEmpty() && !this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());
			
			if(this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
				
			}else {
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) this.getHead()).getPrevious().setNext(this.getHead());
			}
		}
	}

	
	@Override
	public void removeLast() {
		if(!this.isEmpty() && !this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());
			
			if(this.getLast().isNIL()) {
				this.setHead(this.getLast());
				
			}else {
				this.getLast().setNext(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) this.getLast().getNext()).setPrevious(this.getLast());
			}
		}
	}
	
	
	@Override
	public void insert(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast()); // last <----- newLast
			newLast.setNext(new DoubleLinkedListNode<>()); // newLast -----> NIL
			this.last.setNext(newLast); // last -----> newLast
			((DoubleLinkedListNode<T>) newLast.getNext()).setPrevious(newLast); //newLast <----- NIL
			
			if(this.getLast().isNIL()) {
				this.setHead(newLast);
			}
			this.setLast(newLast);
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
	public void remove(T element) {
		if(element != null && !this.isEmpty()) {
			if(this.getHead().getData().equals(element)) {
				removeFirst();
				
			}else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
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