package treinandoProva;

public class PeaksValleys {
	
	public void sortValley(int[] array, int leftIndex, int rightIndex) {
		mergeSort(array, leftIndex, rightIndex);
		for(int i = leftIndex+1; i <= rightIndex; i+= 2) {
			swap(array, i-1, i);
		}
	}
	
	public void mergeSort(int[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			
			int meio = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio+1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}
		
	}
	
	private void merge(int[] array, int leftIndex, int meio, int rightIndex) {
		int[] aux = new int[array.length];
		for(int k = leftIndex; k <= rightIndex; k++) {
			aux[k] = array[k];
		}
		
		int i = leftIndex;
		int j = meio+1;
		int k = leftIndex;
		
		while(i <= meio && j <= rightIndex) {
			if(aux[i] <= aux[j]) {
				array[k++] = aux[i++];
			}else {
				array[k++] = aux[j++];
			}
		}
		
		while(i <= meio) {
			array[k++] = aux[i++];
		}
		
		while(j <= rightIndex) {
			array[k++] = aux[j++];
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
