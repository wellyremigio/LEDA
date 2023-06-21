package treinandoProva;

public class Ceil {
	
	public Integer ceil(Integer[] array, Integer x) {
		if(array.length > 0 && array != null && x != null) {
			quickSort(array, 0, array.length-1);
			return ceilRecursivo(array, x, null, 0, array.length-1);
		}
		return null;
	}
	
	private Integer ceilRecursivo(Integer[] array, Integer x, Integer ceil, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[meio].compareTo(x) == 0) {
				return array[meio];
			}else if(array[meio].compareTo(x) > 0) {
				return ceilRecursivo(array, x, array[meio], leftIndex, meio-1);
			}else {
				return ceilRecursivo(array, x, ceil, meio+1, rightIndex);
			}
		}
		return ceil;
	}
	
	
	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot-1);
			quickSort(array, pivot+1, rightIndex);
		}
	}
	
	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int indexPivot = medianaDe3(array, leftIndex, rightIndex);
		swap(array, leftIndex, indexPivot);
		int pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex+1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, j, i);
			}
		}
		swap(array, i, leftIndex);
		return i;
	}
	
	private int medianaDe3(Integer[] array, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex)/2;
		
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			swap(array, leftIndex, rightIndex);
		}
		if(array[leftIndex].compareTo(array[meio]) > 0) {
			swap(array, leftIndex, meio);
		}
		if(array[meio].compareTo(array[rightIndex]) > 0) {
			swap(array, meio, rightIndex);
		}
		return meio;
	}
	
	private void swap(Integer[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
