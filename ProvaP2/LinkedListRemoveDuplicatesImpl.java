package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
	
    public void removeDuplicates(SingleLinkedListNode<T> node){
       if(!node.isNIL() && !node.getNext().isNIL()) {
    	   
    	   SingleLinkedListNode<T> aux1 = node;
    	   
    	   while(!aux1.isNIL() && !aux1.getNext().isNIL()) {
    		   SingleLinkedListNode<T> aux2 = aux1.getNext();
    		   
    		   while(!aux2.isNIL()) {
    			   if(aux1.getData().equals(aux2.getData())) {
    				   
    				   if(aux2.getNext().isNIL()) {
    					   aux2.setData(null);
    					   aux2.setNext(null);
    				   }else {
    					   aux2.setData(aux2.getNext().getData());
        				   aux2.setNext(aux2.getNext().getNext());
    				   }
    				   
    			   }else {
    				   aux2 = aux2.getNext();
    			   }
    		   }
    		   aux1 = aux1.getNext();
    	   }
       }
    }
}
