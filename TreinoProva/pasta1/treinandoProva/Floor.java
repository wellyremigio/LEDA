package treinandoProva;

import java.util.Arrays;

public class Floor {
	
	public Integer floor(Integer[] array, Integer x) {
		if(array.length > 0 && array != null && x != null) {
			quickSort(array, 0, array.length-1);
			return floorRecursivo(array, x, null, 0, array.length-1);
		}
		return null;
	}
	
	private Integer floorRecursivo(Integer[] array, Integer x, Integer floor, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[meio].compareTo(x) == 0) {
				return array[meio];
			}else if(array[meio].compareTo(x) > 0) {
				return floorRecursivo(array, x, floor, leftIndex, meio-1);
			}else
				return floorRecursivo(array, x, array[meio], meio+1, rightIndex);
		}
		return floor;
	}



	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length) {
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
				swap(array, i, j);
			}
		}
		swap(array, i, leftIndex);
		return i;
	}
	
	private int medianaDe3(Integer[] array, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		Integer[] sorted = {array[leftIndex], array[meio], array[rightIndex]};
		Arrays.sort(sorted);
		
		if(sorted[1].compareTo(array[leftIndex]) == 0) {
			return leftIndex;
		}else if(sorted[1].compareTo(array[meio]) == 0) {
			return meio;
		}else {
			return rightIndex;
		}
	}
	
	private void swap(Integer[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
