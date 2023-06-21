package treinandoProva;

public class SearchInBitonicArray {
	
	public int search(int[] array, int target) {
		if(array.length > 0 && array != null) {
			int valorMax = findMaxElement(array);
			int targetIndex = buscaBinaria(array, target, 0, valorMax);
			if(targetIndex != -1) {
				return targetIndex;
			}
			return buscaBinaria(array, target, valorMax+1, array.length-1);
		}
		return -1;
	}
	
	private int buscaBinaria(int[] array, int target, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[meio] == target) {
				return meio;
			}else if((array[leftIndex] < array[rightIndex] && array[meio] > target) || array[leftIndex] > array[rightIndex] && array[meio] < target) {
				return buscaBinaria(array, target, leftIndex, meio-1);
			}else {
				return buscaBinaria(array, target, meio+1, rightIndex);
			}
		}return -1;
	}

	private int findMaxElement(int[] array) {
		int inicio = 0;
		int fim = array.length-1;
		
		while(inicio <= fim) {
			int meio = (inicio + fim) / 2;
			
			if((meio == 0 || array[meio] > array[meio-1]) && (meio == array.length-1 || array[meio] > array[meio+1])) {
				return meio;
			}else if(array[meio] < array[meio-1]) {
				fim = meio -1;
			}else {
				inicio = meio + 1;
			}
		}
		return -1;
	}
}
