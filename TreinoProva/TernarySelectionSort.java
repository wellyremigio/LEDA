package treinandoProva;

public class TernarySelectionSort <T extends Comparable<T>>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			T min = min(array, leftIndex, rightIndex);
			T max = max(array, leftIndex, rightIndex);
			
			int k = leftIndex;
			int l = rightIndex;
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				if(array[i].compareTo(min) == 0) {
					swap(array, i, k);
					k++;
				}
			}
			
			for(int i = k; i <= l; i++) {
				if(array[i].compareTo(max) == 0) {
					swap(array, i, l);
					l--;
				}
			}
		}
	}
	
	private T min(T[] array, int leftIndex, int rightIndex) {
		T min = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex ; i++) {
			if(array[i].compareTo(min) < 0) {
				min = array[i];
			}
		}
		return min;
	}
	
	private T max(T[] array, int leftIndex, int rightIndex) {
		T max = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}
		return max;
	}
	
	private void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
