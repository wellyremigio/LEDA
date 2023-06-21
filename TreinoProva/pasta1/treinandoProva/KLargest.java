package treinandoProva;

import java.util.Arrays;

public class KLargest <T extends Comparable<T>>{
	
	public T quickRecursivo(T[] array, int k, int left, int right) {
		if(left < right && left >= 0 && right < array.length) {
			int indexPivot = partition(array, left, right);
			
			
			if(array.length - k < indexPivot +1) {
				return quickRecursivo(array, k, left, right-1);
			}else if(array.length - k > indexPivot+1) {
				return quickRecursivo(array, k, indexPivot +1, right);
			}
			return array[array.length-k];
		}
		return array[k-1];
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int indexPivot = medianaDe3(array, leftIndex, rightIndex);
		swap(array, leftIndex, indexPivot);
		
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex+1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i, leftIndex);
		return i;
	}
	

	private int medianaDe3(T[] array, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		
		if(array[leftIndex].compareTo(array[rightIndex])> 0) {
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
	
	private void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
