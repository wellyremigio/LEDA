package treinandoProva;

public class MergeSort <T extends Comparable<T>>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		mergeSort(array, leftIndex,rightIndex);
	}
	
	private void mergeSort(T[] array, int leftIndex, int rightIndex){
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int meio = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}
		
	}
	
	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] arrayAux = (T[]) new Comparable[array.length];
		for(int i = leftIndex; i <= rightIndex; i++) {
			arrayAux[i] = array[i];
		}
		
		int i = leftIndex;
		int j = meio+1; 
		int k = leftIndex;
		
		while(i <= meio && j <= rightIndex) {
			if(array[i].compareTo(array[j])<0 || array[i].compareTo(array[j]) == 0) {
				array[k++] = array[i++];
			}else {
				array[k++] = array[j++];
			}
		}
		
		while(i <= meio) {
			array[k++] = array[i++];
		}
		
		while(j <= rightIndex) {
			array[k++] = array[j++];
		}
	}

}

