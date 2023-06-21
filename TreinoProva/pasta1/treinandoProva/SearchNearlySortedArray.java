package treinandoProva;

public class SearchNearlySortedArray {
	
	public int search(int[] array, int k) {
		int left = 0;
		int right = array.length-1;
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(array[meio] == k) {
				return meio;
			}
			if(array[meio] > 0 && array[meio-1] == k) {
				return meio - 1;
			}
			if(array[meio] < array.length-1 && array[meio+1] == k) {
				return meio + 1;
			}
			
			if(k < array[meio]) {
				right = meio - 2;
				
			}else {
				left = meio + 2;
			}
		}
		return -1;
	}

}
