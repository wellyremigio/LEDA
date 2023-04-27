package treinandoProva;

public class BitonicPointBinarySearchImpl <T extends Comparable<T>> implements BitonicPointBinarySearch<T>{

	@Override
	public T bitonicPoint(T[] array) {
		if(array.length <= 0 || array == null) {
			return null;
		}
		return bitonicPointRecursivo(array, 0, array.length-1);
	}
	
	private T bitonicPointRecursivo(T[] array, int leftIndex, int rightIndex){
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int inicio = leftIndex;
			int fim = rightIndex;
			
			while(inicio <= fim) {
				int meio = (inicio + fim) / 2;
				
				if((meio == 0 || array[meio].compareTo(array[meio-1]) > 0) && (meio == array.length-1 || array[meio].compareTo(array[meio+1]) > 0)) {
					return array[meio];
					
				}else if(array[meio].compareTo(array[meio-1]) < 0) {
					fim = meio - 1;
					
				}else {
					inicio = meio + 1;
				}
			}
		}
		
		return null;
	
		
	}
		
}

