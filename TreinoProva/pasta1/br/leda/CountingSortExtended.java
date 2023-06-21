package br.leda;

import java.util.Arrays;

public class CountingSortExtended {

	public static void main(String[] args) {
		Integer[] vetor = { 4, -9, 3, 4, 0, -5, 1, -4 };
		//Integer[] vetor = {109, 110, 102, 101, 106, 100, 108, 102};
		//Integer[] vetor = { 0, 0, 0, 0, 0, 0, 0, 0};
		//Integer[] vetor = { 5, 5, 5, 5, 5, 5, 5, 5};

		System.out.println(Arrays.toString(vetor));
		//countingSort(vetor, 1, 6);
		countingSortExtended(vetor, 0, vetor.length - 1);

		System.out.println("--------------------");
		System.out.println(Arrays.toString(vetor));
	}
	
	private static void countingSortExtended(Integer[] array, int leftIndex, int rightIndex) {
		int max = max(array, leftIndex, rightIndex);
		int min = min(array, leftIndex, rightIndex);
		int[] C = new int[max - min + 1];
		
		//Registrando a frequência
		for(int i = leftIndex; i <= rightIndex; i++) {
			//System.out.println(Arrays.toString(C));
			C[array[i]-min] += 1;
		}
		
		//Soma acomulativa
		for(int i = 1; i < C.length; i++) {
			C[i] += C[i-1];
		}
		
		//Registrando elementos
		int[] B = new int[rightIndex - leftIndex + 1];
		for(int i = rightIndex; i >= leftIndex; i--) {
			B[C[array[i] - min] - 1] = array[i];
			C[array[i] - min] -= 1;
		}
		
		//Colocando os valores de volta na lista
		int index = 0;
		for(int i = leftIndex; i <= rightIndex; i++) {
			array[i] = B[index];
			index++;
		}
	}
	
	private static int min(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	private static int max(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

}
