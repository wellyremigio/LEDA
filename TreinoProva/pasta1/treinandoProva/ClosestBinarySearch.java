package treinandoProva;

public class ClosestBinarySearch {
	
	public int closest(int[] array, int k) {
		int n = array.length-1;
		
		if(array[0] > k) {
			return array[0];
		}
		if(array[n] < k) {
			return array[n];
		}
		
		int left = 0;
		int right = n;
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(array[meio] == k) {
				return array[meio];
				
			}else if(array[meio] > k) {
				right = meio - 1;
				
			}else {
				left = meio + 1;
			}
	
		}
		
		if((array[left] - k) < (k - array[right])){
			return array[left];
		}return array[right];
	}

}
