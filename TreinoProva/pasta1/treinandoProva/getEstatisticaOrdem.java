package treinandoProva;

public class getEstatisticaOrdem {
	
	public int getOrdem(int[]array, int k) {
		if(array != null && array.length > 0 && k > 0 && k <= array.length) {
			int elemento = -1;
			for(int i = 0; i < k; i++) {
				elemento = selectSort(array, 0, array.length-1);
			}
			return array[elemento];
		}
		return -1;
	
	}
	
	public int selectSort(int[] array, int left, int right) {
		int pivot =  array[left];
		int menor = left;
		
		for(int j = left+1; j <= right; j++) {
			if(array[j] <= menor) {
				menor = j;
			}
		}
		return menor;
	}

}
