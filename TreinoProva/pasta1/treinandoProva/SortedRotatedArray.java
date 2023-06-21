package treinandoProva;

public class SortedRotatedArray {
	
	public int search(int[] array, int k) {
		int left = 0; 
		int right = array.length-1;
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(array[meio] == k) {
				return meio;
			}
			
			if(array[left] <= array[meio]) { //left part is sorted
				if(k >= array[left] && k < array[meio]) {
					right = meio - 1;
					
				}else {
					left = meio + 1;
				}
				
			}else { // right part is sorted
				if(k > array[meio] && k <= array[right]) {
					left = meio + 1;
				
				}else {
					right = meio - 1;
				}
			}
		}
		return -1;
	}

}
