package treinandoProva;

public class BinarySearchOrderNotKnow {
	
	public int search(int[] array, int left, int right, int k) {
		if(left < right && left >= 0 && right < array.length) {
			int meio = (left+right)/2;
			if(array[meio] == k) {
				return meio;
				
			}else if((array[left] < array[right] && k < array[meio]) || (array[left] > array[right] && k > array[meio])) {
				return search(array, left, meio-1, k);
				
			}else {
				return search(array, meio+1, right, k);
			}
		}
		return -1;
	}

}
