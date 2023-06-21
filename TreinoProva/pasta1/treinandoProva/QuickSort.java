package treinandoProva;

public class QuickSort <T extends Comparable<T>>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(!(leftIndex > rightIndex || leftIndex < 0 || rightIndex > array.length || array == null)) {
			int pivot = partition(array,leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}
	
	public int partition(T[] array, int leftIndex, int rightIndex) {
		int indexPivot = calcularPivot(array, leftIndex, rightIndex);
		swap(array, leftIndex, indexPivot);
		
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex+1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) < 0 || array[j].compareTo(pivot) == 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i, leftIndex);
		return i;
		
	}
	
	public int calcularPivot(T[] array, int leftIndex, int rightIndex) {
		int range = (rightIndex - leftIndex) + 1;
		return (int) (Math.random()*range) + leftIndex;
	}
	
	public void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
