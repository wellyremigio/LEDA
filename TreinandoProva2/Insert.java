package treinandoProva;

public class Insert<T extends Comparable<T>> {
	
	//APENAS SINGLE LINKED LIST
	
	public void insertLast(SingleLinkedListNode<T> head, T data) {
		if(data != null) {
			if(head == null) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>();
				newHead.setData(data);
				newHead.setNext(head);
				head = newHead;
				
			}else {
				SingleLinkedListNode<T> aux = head;
				while(!aux.isNIL()) {
					aux =  aux.getNext();
				}
				aux.setData(data);
				aux.setNext(new SingleLinkedListNode<>());
			}
		}
	}
	
	
	//Head sendo node e inserir na posição 0
	public SingleLinkedListNode<T> insertNodeAtPosition(SingleLinkedListNode<T> head, T data, int pos) {
		
		if(data != null && pos >= 0) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>();
			newNode.setData(data);
			
			if(pos == 0) {
				newNode.setNext(head);
				head = newNode;
				
			}else {
				SingleLinkedListNode<T> aux = head;
				int cont = 0;
				while(cont < pos -1 && !aux.isNIL()) {
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
	
	
	//I think is ok
	public SingleLinkedListNode<T> removePos(SingleLinkedListNode<T> head, int pos){
		if(!head.isNIL() && pos >= 0) {
			int cont = 0;
			SingleLinkedListNode<T> aux = head;
			while(cont < pos && !aux.isNIL()) {
				aux = aux.getNext();
				cont++;
			}
			
			if(!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
		return head;
	}
	
	
	//I think is ok
	public SingleLinkedListNode<T> Reverse(SingleLinkedListNode<T> head){
		if(head.isNIL() || head.next.isNIL()) {
			return head;
		}
		SingleLinkedListNode<T> newHead = Reverse(head.getNext());
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	

	//I think is ok
	public boolean compare(SingleLinkedListNode<T> head1, SingleLinkedListNode<T> head2) {
		if(head1.isNIL() && head2.isNIL()) {
			return true;
		}
		
		if(head1.isNIL() || head2.isNIL()) {
			return false;
		}
		
		if(head1.getData().equals(head2.getData())) {
			return compare(head1.next, head2.next);
		}
		return false;
	}
	
	
	//Ok
	//Remove passando um valor
	public void removerDuplicatas(SingleLinkedListNode<T> head, T element) {
		if(element != null && !head.isNIL()) {
			SingleLinkedListNode<T> aux = head;
			
			boolean achou = false;
			while(!aux.isNIL()) {
				
				if(!achou && aux.getData().equals(element)) {
					achou = true;
					aux = aux.getNext();
					
				}else if(achou && aux.getData().equals(element)){
					
					if(aux.getNext().isNIL()) { //Se for o último
						aux.setData(null);
						aux.setNext(null);
						
					}else {
						aux.setData(aux.getNext().getData());
						aux.setNext(aux.getNext().next);
					}
					
				}else {
					aux = aux.getNext();
				}
			}
		}
	}
	
	
	//Ok
	//Remove os valores numa lista ordenada
	public SingleLinkedListNode<T> removerDuplicatasSorted(SingleLinkedListNode<T> head) {
		
		if(head.isNIL() || head.getNext().isNIL()) {
			return head;
		}
		
		SingleLinkedListNode<T> aux = head;
		while(!aux.isNIL() && !aux.getNext().isNIL()) {
			
			if(aux.getData().equals(aux.getNext().getData())) {
				aux.setNext(aux.getNext().getNext());
				
			}else{
				aux = aux.getNext();
			}
		}
		return head;
	}
	
	
	//Remove os valores numa lista desordenada
	//NÃO ESTÁ CERTA
	public SingleLinkedListNode<T> removerDuplicatasUnsorted(SingleLinkedListNode<T> head){
		
		SingleLinkedListNode<T> dup1 = head; //rastrear os elementos cujas duplicatas estão sendo checadas
		SingleLinkedListNode<T> dup2 = null; //rastrear o no que estando sendo verificado
		
		while(dup1 != null && dup1.next != null) {
			dup2 = dup1;
			
			while(dup2.next != null) {
				
				if(dup1.getData().equals(dup2.getNext().getData())) {
					dup2.setNext(dup2.getNext().getNext());
				}
				dup2 = dup2.getNext();
			}
		}
		dup1 = dup1.getNext();
		return head;
	}
	
	
	//Quando manda valor maior que o tamanho da lista dá ruim;
	public SingleLinkedListNode<T> getNodefromTail(SingleLinkedListNode<T> head, int k){
		if(k >= 0) {
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> runner = head;
			
			for(int i = 0; i < k; i++) {
				runner = runner.getNext();
			}
			
			while(!runner.getNext().isNIL()) {
				aux = aux.getNext();
				runner = runner.getNext();
			}
			return aux;
		}
		return null;
	}
	
	
	//Ok
	public boolean hasCycle(SingleLinkedListNode<T> head) {
		SingleLinkedListNode<T> slowPointer = head;
		SingleLinkedListNode<T> fastPointer = head;
		
		return recursiveHasCycle(slowPointer, fastPointer);
	}
	
	private boolean recursiveHasCycle(SingleLinkedListNode<T> slowPointer, SingleLinkedListNode<T> fastPointer) {
		while(!fastPointer.isNIL() && !fastPointer.getNext().isNIL()){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			
			if(slowPointer == fastPointer) {
				return true;
			}
			return recursiveHasCycle(slowPointer, fastPointer);
		}
		return false;
	}
	
	//OK
	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> head1, SingleLinkedListNode<T>head2){
		if(!head1.isNIL() && !head2.isNIL()) {
			if(head1.getData().compareTo(head2.getData()) < 0) {
				head1.next = merge(head1.next, head2);
				return head1;
			}else {
				head2.next = merge(head1, head2.next);
				return head2;
			}
		}
		if(head1.isNIL()) {
			return head2;
		}
		return head1;
	}

}

