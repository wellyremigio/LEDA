package treinandoProva;

public class LeetCode<T> {
	//Soluções do leetCode
	
	//OK
	public SingleLinkedListNode<T> intersecao(SingleLinkedListNode<T> head1, SingleLinkedListNode<T>head2){
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
	public SingleLinkedListNode<T> findMiddleElement(SingleLinkedListNode<T> head){
		SingleLinkedListNode<T> slowPointer = head;
		SingleLinkedListNode<T> fastPointer = head;
		
		while(!fastPointer.isNIL() && !fastPointer.getNext().isNIL()) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		return slowPointer;
	}
	
	
	//NOT DONE
	public boolean palindromo(SingleLinkedListNode<T> head) {
		if(head==null || head.next==null) {
			return true;
	        
		}
		
		SingleLinkedListNode<T> prevSlowNode = null;
		SingleLinkedListNode<T> slowNode = head;
		SingleLinkedListNode<T> fastNode = head;
		while(fastNode!=null && fastNode.next !=null){
			fastNode = fastNode.next.next;                                      //Move fast pointer
			SingleLinkedListNode<T> nextSlowNode = slowNode.next;                              //Store next node in a variable
			slowNode.next = prevSlowNode;                                       //Point current node to prev node
			prevSlowNode = slowNode;                                            //Move prev node to next (curr) node
			slowNode = nextSlowNode;                                            //Move curr node to next node
		}
	        
	  
	        
        SingleLinkedListNode<T> firstHalfPointer = prevSlowNode;                               //Point to prevSlowNode, like like 4 in
                                                                                //[2,4,5,7] or [2,4,5,7,8]
        SingleLinkedListNode<T> secondHalfPointer = null;
        if(fastNode==null){                                                     //List is of even length, like [2,4,5,7]
            secondHalfPointer = slowNode;                                       //Point to slowNode, like 5 in [2,4,5,7]
        }
        else if(fastNode.next==null){                                           //List is of odd length, like [2,4,5,7,8]
            secondHalfPointer = slowNode.next;                                  //Point to slowNode.next, like 7 in [2,4,5,7,8]
        }

	        //  Compare the two halves
	        
        while(firstHalfPointer!=null && secondHalfPointer!=null){
            if(firstHalfPointer.getData() != secondHalfPointer.getData()){
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }
        
        return true;
    }
}
