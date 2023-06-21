package treinandoProva;

public class InsertionSort<T extends Comparable<T>>{
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex; i <= rightIndex; i++) {
			T chave = array[i];
			int j = i-1;
			
			while(j>= 0 && array[j].compareTo(chave) > 0) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = chave;
		}
		
	}
		
}
