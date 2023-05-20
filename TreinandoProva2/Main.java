package treinandoProva;

public class Main {
	public static void main(String [] args) {
		CircularSingleImpl<Integer> lista = new CircularSingleImpl<>();
		lista.insertFirst(1);
		lista.insertLast(2);
		lista.insertLast(10);
		lista.insertFirst(-5);

		//System.out.println(lista.removeFirst()); // 1
		//System.out.println(lista.removeLast()); // 3

		System.out.println(lista.size()); //4
		//Integer[] array =  lista.toArray();
		
		System.out.println("---------------");
		
		//for(int i = 0; i < array.length; i++) {
		//	System.out.println(array[i]);
		//}
		//System.out.println(lista.isEmpty());
		System.out.println(lista.hasCycle());
		System.out.println(lista.hasCycleRecursive());

		
	}


}
