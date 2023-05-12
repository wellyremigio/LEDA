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
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			newHead.next = head; /// newHead ----> head
			((DoubleLinkedListNode<T>) head).setPrevious(newHead); //newHead <---- head
		
			if(this.head.isNIL()) {
				this.last = newHead;
			}
			this.head = newHead;
		}
	}

	@Override
	public void removeFirst() {
		if(!head.isNIL()) {
			this.head = this.head.getNext();
			
			if(this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
				
			}else {
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
				//((DoubleLinkedListNode<T>) this.head).getPrevious().setNext(this.head);//Volta
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(!this.last.isNIL()) {
				this.last = this.last.getPrevious();
				
				if(this.last.isNIL()) {
					this.head = this.last;
					
				}else {
					this.last.setNext(new DoubleLinkedListNode<>()); //volta?
				}
			}
			
		}
	}
	
	
	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new DoubleLinkedListNode<T>());
				this.last.setNext(new DoubleLinkedListNode<T>());
				this.last.setPrevious(new DoubleLinkedListNode<T>());
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());
				
				
			}else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
				
				while(!aux.getNext().isNIL()) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				
				aux.getNext().setData(element);
				((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
				this.last = (DoubleLinkedListNode<T>) aux.getNext();
				aux.getNext().setNext(new DoubleLinkedListNode<T>());
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
