package treinandoProva;

public class CeilBinarySearch {
	
	public int ceil(int[] array, int k) {
		int left = 0;
		int right = array.length-1;
		
		int ceil = -1;
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(array[meio] == k) {
				return array[meio];
				
			}else if(array[meio] > k) {
				ceil = array[meio];
				right = meio-1;
				
			}else {
				left = meio + 1;
			}
		}
		return ceil;
	}

}
