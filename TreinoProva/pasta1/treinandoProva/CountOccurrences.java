package treinandoProva;

public class CountOccurrences {
	
	public int searchFirstPos(int[] array, int k) {
		int left = 0;
		int right = array.length-1;
		int firstPos = -1;
		
		while(left <= right) {
			int meio = (left+right) / 2;
			
			if(array[meio] == k) {
				firstPos = meio;
				right = meio - 1;
				
			}else if(array[meio] > k) {
				right = meio - 1;
				
			}else {
				left = meio + 1;
			}
		}
		return firstPos;
	}
	
	public int searchLastPos(int[] array, int k) {
		int left = 0;
		int right = array.length-1;
		int lastPos = -1;
		
		while(left <= right) {
			int meio = (left + right ) /2;
			
			if(array[meio] == k) {
				lastPos = meio;
				left = meio + 1;
				
			}else if(array[meio] > k) {
				right = meio - 1;
				
			}else {
				left = meio + 1;
			}
		}
		return lastPos;
	}
	
	public int cont(int[] array, int k) {
		int first = searchFirstPos(array, k);
		int last = searchLastPos(array, k);
		
		if(first != -1 && last != -1) {
			return last - first + 1;
		}
		return k;
	}

}
