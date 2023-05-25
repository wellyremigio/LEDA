package treinandoProva;

public class InsertionVariations<T extends Comparable<T>> {
	
	
	//OK
	public DoubleLinkedListNode<T> insertSortedDoubleLinkedList(DoubleLinkedListNode<T> head, T element){
		DoubleLinkedListNode<T> result = null;
		if(element != null) {
			result = recursiveInsertion(head, element);
		}
		return result;
	}
	
	private DoubleLinkedListNode<T> recursiveInsertion(DoubleLinkedListNode<T> head, T element){
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.setData(element);
		
		if(head.isNIL()) {
			return newNode;
			
		}else if(head.getData().compareTo(element) > 0) {
			newNode.setNext(head);
			head.setPrevious(newNode);
			return newNode;
			
		}else {
			DoubleLinkedListNode<T> aux = recursiveInsertion((DoubleLinkedListNode<T>) head.getNext(), element);
			head.setNext(aux);
			aux.setPrevious(head);
			return head;
		}
	}
	
	//OK
	public SingleLinkedListNode<T> insertSortedSingle(SingleLinkedListNode<T> head, T element){
		SingleLinkedListNode<T> result = null;
		if(element != null) {
			result = recursiveSingle(head, element);
		}
		return result;
	}
	
	private SingleLinkedListNode<T> recursiveSingle(SingleLinkedListNode<T> head, T element){
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>();
		newNode.setData(element);
		
		if(head.isNIL()) {
			return newNode;
			
		}else if(head.getData().compareTo(element) > 0) {
			newNode.setNext(head);
			return newNode;
			
		}else {
			SingleLinkedListNode<T> aux = recursiveSingle(head.getNext(), element);
			head.setNext(aux);
			return head;
		}		
	}
	
	
	//OK
	public SingleLinkedListNode<T> insertAtPosition(SingleLinkedListNode<T> head, T element, int pos){
		
		if(element != null && pos >= 0) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>();
			newNode.setData(element);
			
			if(pos == 0) {
				newNode.setNext(head);
				head = newNode;
				
			}else {
				SingleLinkedListNode<T> aux = head;
				int cont = 0;
				
				while(cont < pos - 1 && !aux.isNIL()) {
					aux = aux.getNext();
					cont++;
				}
				
				if(!aux.isNIL()) {
					SingleLinkedListNode<T> temp = aux.getNext();
					aux.setNext(newNode);
					newNode.setNext(temp);
				}
			}
		}
		return head;
	}
	
	//OK
	public DoubleLinkedListNode<T> insertAtPositionDouble(DoubleLinkedListNode<T> head, T element, int pos){
		
		if(element != null && pos >= 0) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			newNode.setData(element);
			
			if(pos == 0) {
				newNode.setNext(head);
				head.setPrevious(newNode);
				newNode.setPrevious(new DoubleLinkedListNode<>());
				newNode.getPrevious().setNext(newNode);
				head = newNode;
				
			}else {
				DoubleLinkedListNode<T> aux = head;
				int cont = 0;
				
				while(cont < pos -1 && !aux.isNIL()) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
					cont++;
				}
				
				if(!aux.isNIL()) {
					DoubleLinkedListNode<T> tempNext = (DoubleLinkedListNode<T>) aux.getNext();
					//DoubleLinkedListNode<T> tempPrevious = aux.getPrevious();
					
					aux.setNext(newNode);
					newNode.setPrevious(aux);
					
					newNode.setNext(tempNext);
					((DoubleLinkedListNode<T>) newNode.getNext()).setPrevious(newNode);
				}
			}
		}
		return head;
	}
	
	//Ok
	public SingleLinkedListNode<T> removeAtPosition(SingleLinkedListNode<T> head, int pos){
		if(pos >= 0 && !head.isNIL()) {
			
			if(pos == 0) {
				head = head.getNext();
				
			}else {
				SingleLinkedListNode<T> aux = head;
				int cont = 0;
				
				while(cont < pos && !aux.isNIL()) {
					aux = aux.getNext();
					cont++;
				}
				
				if(!aux.isNIL()) {
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
		return head;
	}
	
	
	//Ok
	public DoubleLinkedListNode<T> removeAtPositionDouble(DoubleLinkedListNode<T> head, int pos){
		if(pos >= 0 && !head.isNIL()) {
			
			if(pos == 0) {
				head = (DoubleLinkedListNode<T>) head.getNext();
				head.setPrevious(new DoubleLinkedListNode<T>());
				head.getPrevious().setNext(head);
				
			}else {
				DoubleLinkedListNode<T> aux = head;
				int cont = 0;
				
				while(cont < pos - 1 && !aux.isNIL()) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
					cont++;
				}
				
				if(!aux.isNIL()) {
					aux.setNext(aux.getNext().getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
				}
			}
		}
		return head;
	}
	
	//OK
	public void appendReverseSingle(SingleLinkedListNode<T> head, T element){
		
		if(element != null) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>();
			newNode.setData(element);
			
			if(head.isNIL()) {
				head = newNode;
				
			}else {
				SingleLinkedListNode<T> aux = head;
				SingleLinkedListNode<T> prox = null;
				SingleLinkedListNode<T> prev = null;
				
				while(!aux.isNIL()) {
					
					prox = aux.next;
					aux.next = prev;
					prev = aux;
					aux = prox;
				}
				newNode.setNext(prev);
				head = newNode;
			}
			
			
		}
	}
	
	
	public void appendReverseDouble(DoubleLinkedListNode<T> head, T element) {
		if(element != null) {
			
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			newNode.setData(element);
			
			if(head.isNIL()) {
				head = newNode;
				
			}else {
				DoubleLinkedListNode<T> aux = head;
				DoubleLinkedListNode<T> prox = null;
				DoubleLinkedListNode<T> prev = null;
				
				while(!aux.isNIL()) {
					prox = (DoubleLinkedListNode<T>) aux.next;
					aux.next = prev;
					prev = aux;
					aux = prox;
				}
				newNode.setNext(prev);
				prev.setPrevious(newNode);
				head = newNode;
			}
		}
		
	}
}
