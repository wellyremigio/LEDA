package br.leda;

public class InsertionRecursiva {

	public static void main(String[] args) {
		Integer[] vetor = {9, 15, 1, 5, 4, 3, 2, 1, 20, 0};
		//{ 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
			
		insertionRecursiva(vetor, vetor.length);
		for(int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
	}
	
	public static void insertionRecursiva(Integer[] array, int n) {
		if(n <= 1) {
			return;
		}
		insertionRecursiva(array, n-1);
		int chave = array[n-1];
		int j = n - 2;
		while(j >= 0 && array[j] > chave) {
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = chave;
	}

}
