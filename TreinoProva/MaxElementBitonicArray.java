package treinandoProva;

public class MaxElementBitonicArray {
	
	
	public int findMaxElement(int[] array) {
		int inicio = 0;
		int n = array.length;
		int fim = n - 1;


		while(inicio <= fim) {
			int meio = (inicio + fim) / 2;
			
			if((meio == 0 || array[meio] > array[meio-1]) && (meio == n-1 || array[meio] > array[meio+1])){
				return array[meio];
				
			}else if(array[meio] < array[meio-1]) {
				fim = meio - 1;
				
			}else {
				inicio = meio + 1;
			}
		}
		return -1;
	}
}

