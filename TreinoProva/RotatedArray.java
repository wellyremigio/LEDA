package treinandoProva;

public class RotatedArray {
	
	public int search(Integer[] array, int x, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[meio].compareTo(x) == 0) {
				return meio;
			}if(array[leftIndex].compareTo(array[meio]) < 0) { // parte esquerda está ordenada
				if(array[leftIndex].compareTo(x) <= 0 && array[meio].compareTo(x) > 0) {
					return search(array, x, leftIndex, meio-1); //Procura na esquerda
				}else {
					return search(array, x, meio+1, rightIndex); //Procura na direita
				}
			}else if(array[leftIndex].compareTo(array[meio]) > 0){ //parte direita está ordenada
				if(array[meio].compareTo(x) < 0 && array[rightIndex].compareTo(x) >= 0) {
					return search(array, x, meio+1, rightIndex); //Procura na direita
				}else {
					return search(array, x, leftIndex, meio-1); //procura na esquerda
				}
			}else if(array[leftIndex].compareTo(array[meio]) == 0) {
				if(array[meio].compareTo(array[rightIndex]) != 0) {
					return search(array, x, meio+1, rightIndex); //procura na direita
				}else {
					int result = search(array, x, leftIndex, meio-1);
					if(result == -1) {
						return search(array, x, meio+1, rightIndex);
					}else {
						return result;
					}
				}
			}
		}
		return -1;
	}
}
