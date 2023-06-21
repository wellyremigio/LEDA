package treinandoProva;

public class CocktailSort {
	
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			boolean trocou = true;
			while(trocou) {
				trocou = false;
				for(int i = leftIndex; i <= rightIndex; i++) {
					if(array[i]> array[i+1]) {
						swap(array, i, i+1);
						trocou = true;
					}
				}
				if(!trocou) {
					break;
				}
				
				trocou = false;
				rightIndex--;
				
				for(int i = rightIndex - 1; i >= leftIndex; i--) {
					if(array[i] > array[i+1]) {
						swap(array, i, i+1);
						trocou = true;
					}
				}
				leftIndex++;
			}
			
		}
	}
	
	private void swap(Integer[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
