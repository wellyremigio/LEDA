package treinandoProva;

public class BidirecionalBubble <T extends Comparable<T>>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			boolean trocou = true;
			while(trocou) {
				trocou = false;
				for(int i = leftIndex; i < rightIndex-1; i++) {
					if(array[i].compareTo(array[i+1]) > 0) {
						swap(array, i, i+1);
						trocou = true;
					}
				}
				for(int i = rightIndex-1; i >= leftIndex; i--) {
					if(array[i].compareTo(array[i+1]) > 0) {
						swap(array, i, i+1);
						trocou = true;
					}
				}
			}
		}
	}
	
	private void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
