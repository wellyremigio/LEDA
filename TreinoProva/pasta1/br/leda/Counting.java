package br.leda;

import java.util.Arrays;

public class Counting {

	public static void main(String[] args) {
		Integer[] vetor = { 4, 9, 3, 4, 0, 5, 1, 4 };
		//Integer[] vetor = { 0, 0, 0, 0, 0, 0, 0, 0};
		//Integer[] vetor = { 5, 5, 5, 5, 5, 5, 5, 5};

		System.out.println(Arrays.toString(vetor));
		countingSort(vetor, 1, 6);
		//countingSort(vetor, 0, vetor.length - 1);

		System.out.println("--------------------");
		System.out.println(Arrays.toString(vetor));
	}
	
	private static void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		if(!(array == null || leftIndex > rightIndex || leftIndex < 0 || rightIndex > array.length)) {
			int[] C = new int[maior(array, leftIndex, rightIndex) + 1];
			
			//Frequencia
			for(int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]] += 1;
			}
			//Comulativa
			for(int i = 1; i < C.length; i++) {
				C[i] += C[i-1];
			}
			
			//Registrando elementos
			int[] B = new int[rightIndex - leftIndex + 1];
			for(int i = rightIndex; i >= leftIndex; i--) {

				B[C[array[i]]-1] = array[i];
				C[array[i]] -= 1;
			}
			
			//Colocando de volta no array
			int index = 0;
			for(int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[index];
				index++;
			}
		}
	}
	
	private static int maior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}
}
