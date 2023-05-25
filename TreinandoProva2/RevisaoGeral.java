package treinandoProva;

public class RevisaoGeral<T extends Comparable<T>> {
	
	//Inserir um elemento numa lista ordenada de forma que ela permaneça ordenada
	//Single
	
	public SingleLinkedListNode<T> insertSortedSingle(SingleLinkedListNode<T> head, T element){
		SingleLinkedListNode<T> result = null;
		if(element != null) {
			result = recursive(head, element);
		}
		return result;
	}
	
	private SingleLinkedListNode<T> recursive(SingleLinkedListNode<T> head, T element) {
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>();
		newNode.setData(element);
		
		if(head.isNIL()) {
			head.setData(element);
			return head;
			
		}else if(head.getData().compareTo(element) > 0) {
			newNode.setNext(head);
			return newNode;
			
		}else {
			SingleLinkedListNode<T> aux = recursive(head.getNext(), element);
			head.setNext(aux);
			return head;
		}
	}
	
	
	//Inserir um elemento numa lista ordenada de forma que ela permaneça ordenada
	//Double
	public DoubleLinkedListNode<T> insertSortedDouble(DoubleLinkedListNode<T> head, T element){
		DoubleLinkedListNode<T> result = null;
		if(element != null) {
			result = recursiveDouble(head, element);
		}
		return result;
	}
	
	private DoubleLinkedListNode<T> recursiveDouble(DoubleLinkedListNode<T> head, T element){
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.setData(element);
		
		if(head.isNIL()) {
			head = newNode;
			head.setData(element);
			return newNode;
			
		}else if(head.getData().compareTo(element) > 0) {
			newNode.setNext(head);
			head.setPrevious(newNode);
			return newNode;
			
		}else {
			DoubleLinkedListNode<T> aux = recursiveDouble((DoubleLinkedListNode<T>) head.getNext(), element);
			head.setNext(aux);
			aux.setPrevious(head);
			return head;
		}
	}
	
	
	//Achar o elemento do meio na single
	public SingleLinkedListNode<T> middleSingle(SingleLinkedListNode<T> head){
		SingleLinkedListNode<T> slow = head;
		SingleLinkedListNode<T> fast = head;
		
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}
	
	
	//Achar o elemento do meio na double
	public DoubleLinkedListNode<T> middleDouble(DoubleLinkedListNode<T> head){
		DoubleLinkedListNode<T> slow = head;
		DoubleLinkedListNode<T> fast = head;
		
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = (DoubleLinkedListNode<T>) slow.getNext();
			fast = (DoubleLinkedListNode<T>) fast.getNext().getNext();
		}
		return slow;
	}
	
	//Verificar se tem ciclo na single
	public boolean hasCycle(SingleLinkedListNode<T> head) {
		boolean temCiclo = false;
		if(!head.isNIL()) {
			SingleLinkedListNode<T> fast = head;
			SingleLinkedListNode<T> slow = head;
			temCiclo = recursiveCycle(slow, fast);
		}
		return temCiclo;
	}
	
	private boolean recursiveCycle(SingleLinkedListNode<T> slow, SingleLinkedListNode<T> fast) {
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(fast == slow) {
				return true;
			}
			return recursiveCycle(slow, fast);
		}
		return false;
	}
	
	
	//Verificar se tem ciclo na double
	public boolean hasCycleDouble(DoubleLinkedListNode<T> head) {
		boolean temCiclo = false;
		if(!head.isNIL()) {
			DoubleLinkedListNode<T> fast = head;
			DoubleLinkedListNode<T> slow = head;
			
			temCiclo = recursiveDouble(slow, fast);
		}
		return temCiclo;
	}
	
	private boolean recursiveDouble(DoubleLinkedListNode<T> slow, DoubleLinkedListNode<T> fast) {
		
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = (DoubleLinkedListNode<T>) slow.getNext();
			fast = (DoubleLinkedListNode<T>) fast.getNext().getNext();
			
			if(slow == fast) {
				return true;
			}
			return recursiveDouble(slow, fast);
		}
		return false;
	}
	
	//Reverter a single
	public SingleLinkedListNode<T> reverseSingle(SingleLinkedListNode<T> head){
		if(head.isNIL()) {
			return head;
		}
		
		SingleLinkedListNode<T> aux = head;
		SingleLinkedListNode<T> prox = null;
		SingleLinkedListNode<T> previous = null;
		
		while(!aux.isNIL()) {
			prox = aux.getNext();
			aux.next = previous;
			previous = aux;
			aux = prox;
		}
		return previous;
	}
	
	//Reverter a double
	public DoubleLinkedListNode<T> reverterDouble(DoubleLinkedListNode<T> head){
		if(head.isNIL()) {
			return head;
		}
		
		DoubleLinkedListNode<T> aux = head;
		DoubleLinkedListNode<T> prox = null;
		DoubleLinkedListNode<T> prev = null;
		
		while(!aux.isNIL()) {
			prox = (DoubleLinkedListNode<T>) aux.next;
			aux.next = prev;
			prev = aux;
			aux = prox;
		}
		return prev;
	}
	
	
	//Reverter e inserir na single
	public void appendReverseSingle(SingleLinkedListNode<T> head, T element) {
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
	
	//Reverter e inserir na double
	public void appendReverseDouble(DoubleLinkedListNode<T> head, T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
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
			}
		}
	}
	
	
	public void removerDupSingle(SingleLinkedListNode<T> head, T element) {
		if(!head.isNIL() && element != null) {
			SingleLinkedListNode<T> aux = head;
			boolean achou = false;
			
			while(!aux.isNIL()) {
				if(!achou && aux.getData().equals(element)) {
					achou = true;
					aux = aux.getNext();
					
				}else if(achou && aux.getData().equals(element)) {
					
					if(aux.getNext().isNIL()) {
						aux.setData(null);
						aux.setNext(null);
						
					}else {
						aux.setData(aux.getNext().getData());
						aux.setNext(aux.getNext().getNext());
					}
					
				}else {
					aux = aux.getNext();
				}
			}
		}
	}
	
	public void removerDupDouble(DoubleLinkedListNode<T> head, T element) {
		if(!head.isNIL() && element != null) {
			
			DoubleLinkedListNode<T> aux = head;
			boolean achou = false;
			
			while(!aux.isNIL()) {
				
				if(!achou && aux.getData().equals(element)) {
					achou = true;
					aux = (DoubleLinkedListNode<T>) aux.getNext();
					
				}else if(achou && aux.getData().equals(element)) {
					
					if(aux.getNext().isNIL()) {
						aux.setData(null);
						aux.setNext(null);
						
					}else {
						aux.setNext(aux.getNext().getNext());
						((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
					}
					
				}else {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
			}
		}
	}
	
	
	
	public void removerDupSorted(SingleLinkedListNode<T> head) {
		if(!head.isNIL() && !head.getNext().isNIL()) {
			
			SingleLinkedListNode<T> aux = head;
			while(!aux.isNIL() && !aux.getNext().isNIL()) {
				
				if(aux.getData().equals(aux.getNext().getData())) {
					aux.setNext(aux.getNext().getNext());
					
				}else {
					aux = aux.getNext();
				}
			}
		}
	}
	
	
	//Tamanho em um ciclo
	public int tamanhoCiclo(SingleLinkedListNode<T> head) {
		int tamanho = 0;
		
		if(head.isNIL()) {
			tamanho = 0;
			
		}else if(head == head.getNext()) {
			tamanho = 1;
			
		}else {
			SingleLinkedListNode<T> aux = head;
			while(!aux.getNext().equals(head)) {
				tamanho++;
				aux = aux.getNext();
			}
			tamanho++;
		}
		return tamanho;
	}
	
	//Trocar dois valores
	public void swap(SingleLinkedListNode<T> head, T element1, T element2) {
		if(element1 != null && element2 != null) {
			
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> node1 = null;
			SingleLinkedListNode<T> node2 = null;
			
			while(!aux.isNIL()) {
				
				if(aux.getData().equals(element1)) {
					node1 = aux;
				}
				
				if(aux.getData().equals(element2)) {
					node2 = aux;
				}
				aux = aux.getNext();
			}
			
			if(node1 != null && node2 != null) {
				T temp = node1.getData();
				node1.setData(node2.getData());
				node2.setData(temp);
			}
		}
	}
	
	
	//Merge de uma single
	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> head1,  SingleLinkedListNode<T> head2){
		if(head1.isNIL()) {
			return head2;
		}
		
		else if(head2.isNIL()) {
			return head1;
		}
		
		 SingleLinkedListNode<T> aux;
		 
		 if(head1.getData().compareTo(head2.getData()) <= 0) {
			 aux = head1;
			 aux.next = merge(head1.next, head2);
			 
		 }else {
			 aux = head2;
			 aux.next = merge(head1, head2.next);
		 }
		 
		 return aux;
	}
	
	//TO DO Palindromo
	
}
