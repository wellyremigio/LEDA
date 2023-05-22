package treinandoProva;

public class Main {
	public static void main(String [] args) {
		//LinkedList<Integer> lista = new LinkedList<>();
		//lista.add(1);
		//lista.add(3);
		
		Insert<Integer> in = new Insert<>();
		
		SingleLinkedListNode<Integer> n1 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n2 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n3 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n4 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n0 = new SingleLinkedListNode<>();
		
		//SingleLinkedListNode<Integer> n = new SingleLinkedListNode<>();
		//n.setData(null);
		//SingleLinkedListNode<Integer> newNode = in.insertNodeAtPosition(n, 5, 0);
		//System.out.println(newNode.getData());
		//n0.setData(0);
		
		n1.setData(1);
		n1.setNext(n2);
		
		n2.setData(2);
		n2.setNext(n3);

		n3.setData(3);
		n3.setNext(n4);
		
		//in.Reverse(n1);
		/*while(!n3.isNIL()) {
			System.out.println(n3.getData());
			n3 = n3.getNext();
		}
		*/
		
		
		//in.removePos(n1, 0); // Expected: 2 3
		//in.removePos(n1, 1); // Expected: 1 3 
		//in.removePos(n1, 2); // Expected: 1 2 
		//in.removePos(n1, 10); // Expected:1 2 3 
		//in.removePos(n1, -1); // Expected: 1 2 3
		
	
	
		//Inserindo no final - OK
		in.insertNodeAtPosition(n1, 10, 3);
		
		//Inserindo no começo - OK
		in.insertNodeAtPosition(n1, 4, 0);
		
		System.out.println(n1.getData());
		System.out.println("--------");
		
		//Inserindo numa posicao acima - OK
		//in.insertNodeAtPosition(n1, 4, 5);
		
		//Inserindo numa posicao abaixo - OK
		//in.insertNodeAtPosition(n1, 10, -1);

		//Inserindo numa posicao do meio - OK
		//in.insertNodeAtPosition(n1, 7, 1);
		
		//Inserindo na head null - Not Ok
		//in.insertNodeAtPosition(null, 10, 3);
		
		//Inserindo na head null - OK
		//in.insertNodeAtPosition(n1, null, 1);
		
		while(!n1.isNIL()) {
			System.out.println(n1.getData());
			n1 = n1.getNext();
		}
		
		System.out.println("--");
		//System.out.println(n1.toString());
		
		
	}
	


}
