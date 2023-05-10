package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = getHead();
		while(!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T resposta = null;
		if(element != null && !isEmpty()) {
			SingleLinkedListNode<T> auxHead = getHead();
			while(!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				auxHead = auxHead.getNext();
			}
			resposta = auxHead.getData();
		}
		return resposta;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> auxHead = getHead();
			if(isEmpty()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, getHead());
				setHead(newHead);
				
			}else {
				while(!auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()) {
			if(getHead().getData().equals(element)) {
				setHead(getHead().getNext());
				
			}else {
				SingleLinkedListNode<T> auxHead = getHead();
				while(!auxHead.isNIL() && !auxHead.getData().equals(element)) {
					auxHead = auxHead.getNext();
				}
				if(!auxHead.isNIL()) {
					auxHead.setData(auxHead.getNext().getData());
					auxHead.setNext(auxHead.getNext().getNext());
				}
			}
			
		}
	}

	@Override
	public T[] toArray() {
		int size = size();
		T[] arrayDaLista = (T[]) new Comparable[size];
		SingleLinkedListNode<T> auxHead = getHead();
		int cont = 0;
		while(!auxHead.isNIL()) {
			arrayDaLista[cont] = auxHead.getData();
			auxHead = auxHead.getNext();
			cont++;
		}
		return arrayDaLista;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
