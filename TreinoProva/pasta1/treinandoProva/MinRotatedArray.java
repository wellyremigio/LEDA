package treinandoProva;

public class MinRotatedArray {
	public int findMin(int[] array) {
		int left = 0;
		int right = array.length-1;
		
		
		if(array[left] < array[right]) {
			return array[left];
		}
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(meio > 0 && array[meio] < array[meio-1]) {
				return meio;
			}
			
			if(array[left] < array[meio]) {
				left = meio+1;
				
			}else {
				right = meio - 1;
			}
		}
		return -1;
	}

}
