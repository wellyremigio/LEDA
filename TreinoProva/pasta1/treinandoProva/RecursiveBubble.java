package treinandoProva;

public class RecursiveBubble <T extends Comparable<T>>{
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			for(int i = leftIndex; i < rightIndex; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					swap(array, i, i+1);
				}
			}
			sort(array, leftIndex, rightIndex-1);
		}
	}
	
	private void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}


}
