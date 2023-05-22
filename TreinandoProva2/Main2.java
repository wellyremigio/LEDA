package treinandoProva;

public class Main2 {

	public static void main(String[] args) {
		//LISTA 1
		SingleLinkedListNode<Integer> n1 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n2 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n3 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n4 = new SingleLinkedListNode<>();

		//LISTA 2
		SingleLinkedListNode<Integer> n5 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n6 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n7 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> n8 = new SingleLinkedListNode<>();

		//SET LISTA 1
		n1.setData(1);
		n1.setNext(n2);
		
		n2.setData(3);
		n2.setNext(n3);

		n3.setData(5);
		n3.setNext(n4);
		
		
		//SET LISTA2 
		n5.setData(2);
		n5.setNext(n6);
		
		n6.setData(4);
		n6.setNext(n7);

		n7.setData(6);
		n7.setNext(n8);
		
		
		//Insert<Integer> in = new Insert<>();
		//System.out.println(in.compare(n2, n6));
		//in.merge(n1, n5);
		
		
		LeetCode<Integer> le = new LeetCode<>();
		System.out.println(le.intersecao(n1, n5));
		
		//while(!n1.isNIL()) {
			//System.out.println(n1.getData());
			//n1 = n1.getNext();
//		}
		
	}

}
