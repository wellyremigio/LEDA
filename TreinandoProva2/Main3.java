package treinandoProva;

public class Main3 {
	public static void main(String[] args) {
		//LISTA 1
		SingleLinkedListNode<Integer> n1 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n2 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n3 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n4 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n5 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n6 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n7 = new SingleLinkedListNode<>();
		
		//SET LISTA 1
		n1.setData(1);
		n1.setNext(n2);
		
		n2.setData(2);
		n2.setNext(n3);

		n3.setData(3);
		n3.setNext(n4);
		
		n4.setData(3);
		n4.setNext(n5);
		
		n5.setData(2);
		n5.setNext(n6);
		
		n6.setData(2);
		n6.setNext(n7);
		
		//Insert
		Insert<Integer> in = new Insert<>();
		//System.out.println(in.hasCycle(n1));
		//in.hasCycle(n1);
		//in.removerDuplicatasSorted(n1);
		//in.removerDuplicatasUnsorted(n1);
		//System.out.println(in.getNodefromTail(n1, 7)); //3
	
		
		while(!n1.isNIL()) {
			System.out.println(n1.getData());
			n1 = n1.getNext();
		}
		
		
		
		
		//USANDO O LEETCODE
		LeetCode<Integer> le = new LeetCode<>();
		//System.out.println(le.findMiddleElement(n1));
		System.out.println(le.palindromo(n1));
	
	}
}
