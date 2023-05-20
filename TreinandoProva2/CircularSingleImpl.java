package treinandoProva;

public class CircularSingleImpl<T> {
	
	protected CircularLinkedListNode<T> head;
	int cont;
	
	public CircularSingleImpl() {
		this.head = new CircularLinkedListNode<T>();
		cont = 0;
	}
	
	//Ok
	public boolean isEmpty() {
		return this.head.isNIL();
	}
	
	//Ok
	public void insertFirst(T element) {
		if(element != null) {
			CircularLinkedListNode<T> newHead = new CircularLinkedListNode<>(element);
			if(head.isNIL()) {
				head = newHead;
				head.next = head;    
				
			}else {
				CircularLinkedListNode<T> auxHead = head;
				while(auxHead.next != head) {
					auxHead = auxHead.next;
				}
				
				newHead.next = head;
				auxHead.next = newHead;
				head = newHead;
			}
			cont++;
		}
	}
	
	//Ok
	public void insertLast(T element) {
		if(element != null) {
			CircularLinkedListNode<T> newNode = new CircularLinkedListNode<>(element);
			if(head.isNIL()) {
				head = newNode;
				newNode.next = head;
				
			}else {
				CircularLinkedListNode<T> aux = head;
				while(aux.next != head) {
					aux = aux.next;
				}
				
				aux.next = newNode;
				newNode.next = head;
			}
			cont++;
		}
	}
	
	//tratar
	/*public void insertAtPosition(T element, int pos) {
		if (pos < 1 || pos > size() + 1) {
		    System.out.println("Invalid position!");
		    return;
		  }
		
		if(element != null) {
			if(pos == 1) {
				insertFirst(element);
				
			} else if(pos == size()+1) {
				insertLast(element);
				
			}else {
				CircularLinkedListNode<T> newNode = new CircularLinkedListNode<>(element);
				CircularLinkedListNode<T> aux = head;
				for(int i = 1; i < pos-1; i++) {
					aux = aux.next;
					
				}
				newNode.next = aux.next;
				aux.next = newNode;
			}
		}
	}
	*/
	
	//OK
	public int size() {
		return this.cont;
	}
	
	//Ok
	public T removeFirst() {
		T resposta = null;
		if(!isEmpty()) {
			CircularLinkedListNode<T> aux = head;
			while(aux.next != head) {
				aux = aux.next;
			}
			resposta = head.data;
			aux.next = head.next;
			head = head.next;
			cont--;
		}
		return resposta;
	}
	
	//Ok
	public T removeLast() {
		T resposta = null;
		if(!isEmpty()) {
			CircularLinkedListNode<T> aux = head;
			while(aux.next.next != head) {
				aux = aux.next;
			}
			resposta = aux.next.data;
			aux.next = aux.next.next;
			cont--;
		}
		return resposta;
	}
	
	//Ok
	public Integer[] toArray() {
		Integer[] arrayDaLista = (Integer[]) new Integer[size()];
		if(!this.isEmpty()) {
			CircularLinkedListNode<T> auxHead = head;
			int i = 0;
			while(i < this.cont) {
				arrayDaLista[i] = (Integer) auxHead.getData();
				auxHead = auxHead.getNext();
				i++;
			}
		}
		return (Integer[]) arrayDaLista;
	}
	
	public boolean hasCycle() {
		CircularLinkedListNode<T> slowPointer = head;
		CircularLinkedListNode<T> fastPointer = head;
		
		while(!fastPointer.isNIL() && !fastPointer.next.isNIL()) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if(slowPointer == fastPointer) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasCycleRecursive() {
		CircularLinkedListNode<T> slowPointer = head;
		CircularLinkedListNode<T> fastPointer = head;
		
		return recursive(slowPointer, fastPointer);
	}
	
	private boolean recursive(CircularLinkedListNode<T> slowPointer, CircularLinkedListNode<T> fastPointer) {
		if(!fastPointer.isNIL() && !fastPointer.next.isNIL()) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if(slowPointer == fastPointer) {
				return true;
			}
			return recursive(slowPointer, fastPointer);
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
