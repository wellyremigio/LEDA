package treinandoProva;

public class RecursiveSelection <T extends Comparable<T>>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int posMenor = leftIndex;
			for(int i = leftIndex; i <= rightIndex; i++) {
				if(array[i].compareTo(array[posMenor]) < 0) {
					posMenor = i;
				}
			}
			swap(array, leftIndex, posMenor);
			sort(array, leftIndex +1, rightIndex);
		}
	}
	
	
	
	

	private void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}


