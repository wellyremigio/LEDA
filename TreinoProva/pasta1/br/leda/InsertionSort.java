package br.leda;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		Integer[] vetor = { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		System.out.println(Arrays.toString(vetor));
		insertion(vetor);
		System.out.println(Arrays.toString(vetor));

	
	}
	
	public static void insertion(Integer[] vetor) {
		sort(vetor, 0, vetor.length - 1);
	}
	
	
	
	private static void sort(Integer[] array, int left, int right) {
		int i = left + 1;
		
		while(i <= right) {
			int j = i;
			while(j > left && array[j] < array[j-1]) {
				int aux = array[j];
				array[j] = array[j-1];
				array[j-1] = aux;
				j--;
			}
			i++;
		}
	}
	/*private static void sort(Integer[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex+1; i < rightIndex; i++) {
			int chave = array[i];
			int j = i - 1;
			while(j > 0 && array[j].compareTo(chave) > 0) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = chave;
		}
	}
	*/

}
