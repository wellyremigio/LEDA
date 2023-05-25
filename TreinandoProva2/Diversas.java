package treinandoProva;

public class Diversas<T extends Comparable<T>> {
	
	public boolean compare(SingleLinkedListNode<T> head1, SingleLinkedListNode<T>head2) {
		if(head1.isNIL() && head2.isNIL()) {
			return true;
		}
		
		if(head1.isNIL() || head2.isNIL()) {
			return false;
		}
		
		if(head1.getData().equals(head2.getData())) {
			return compare(head1.getNext(), head2.getNext());
		}
		return false;
	}
	
	//Ok
	public boolean hasCycleSingle(SingleLinkedListNode<T> head) {
		boolean temCiclo = false;
		if(!head.isNIL()) {
			SingleLinkedListNode<T> slowPointer = head;
			SingleLinkedListNode<T> fastPointer = head;
			temCiclo = recursiveCiclosS(slowPointer, fastPointer);
		}
		return temCiclo;
	}
	
	private boolean recursiveCiclosS(SingleLinkedListNode<T> slow, SingleLinkedListNode<T> fast) {
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(fast == slow) {
				return true;
			}
			return recursiveCiclosS(slow, fast);
		}
		return false;
	}
	
	public boolean temCicloInte(SingleLinkedListNode<T> head) {
		SingleLinkedListNode<T> slow = head;
		SingleLinkedListNode<T> fast = head;
		
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	//OK
	public void removerDupSingle(SingleLinkedListNode<T> head, T element) {
		if(element != null && !head.isNIL()) {
			
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
	
	//OK
	public void removerDupDouble(DoubleLinkedListNode<T> head, T element) {
		if(element != null && !head.isNIL()) {
			
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
						aux.setData(aux.getNext().getData());
						aux.setNext(aux.getNext().getNext());
						((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
					}
					
				}else {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
			}
		}
	}
	
	
	//OK
	public SingleLinkedListNode<T> intersecaoSingle(SingleLinkedListNode<T> head1, SingleLinkedListNode<T> head2){
		
		while(!head1.isNIL()) {
			
			SingleLinkedListNode<T> aux = head2;
			while(!aux.isNIL()) {
				if(aux.getData().equals(head1.getData())) {
					return head1;
				}
				aux = aux.getNext();
			}
			head1 = head1.getNext();
		}
		return null;
	}
	
	
	//OK
	public SingleLinkedListNode<T> findMiddle(SingleLinkedListNode<T> head){
		SingleLinkedListNode<T> fast = head;
		SingleLinkedListNode<T> slow = head;
		
		while(!fast.isNIL() && !fast.getNext().isNIL()) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}
	
	public SingleLinkedListNode<T> reverterSingle(SingleLinkedListNode<T> head) {
		if(head.isNIL()) {
			return head;
		}
		
		SingleLinkedListNode<T> aux = head;
		SingleLinkedListNode<T> prox = null;
		SingleLinkedListNode<T> previous = null;
		
		while(!aux.isNIL()) {
			prox = aux.next;
			aux.next = previous;
			previous = aux;
			aux = prox;
		}
		return previous;
	}
	
	public DoubleLinkedListNode<T> reverterDouble(DoubleLinkedListNode<T> head) {
		if(head.isNIL()) {
			return head;
		}
		
		DoubleLinkedListNode<T> aux = head;
		DoubleLinkedListNode<T> prox = null;
		DoubleLinkedListNode<T> previous = null;
		
		while(!aux.isNIL()) {
			prox = (DoubleLinkedListNode<T>) aux.next;
			aux.next = previous;
			previous = aux;
			aux = prox;
		}
		return previous;
	}
	
	
	
	//Ok
	public boolean ehPalindromoDouble(DoubleLinkedListNode<T> left) {
		if(left.isNIL()) {
			return true;
		}
		
		DoubleLinkedListNode<T> right = left;
		
		while(!right.next.isNIL()) {
			right = (DoubleLinkedListNode<T>) right.getNext();
		}
		
		while(left != right) {
			if(left.getData() != right.getData()) {
				return false;
			}
			left = (DoubleLinkedListNode<T>) left.getNext();
			right = right.getPrevious();
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
