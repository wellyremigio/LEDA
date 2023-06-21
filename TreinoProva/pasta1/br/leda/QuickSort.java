package br.leda;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] vetor = { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		System.out.println(Arrays.toString(vetor));
		quickSort(vetor, 0, vetor.length-1);
		System.out.println("--------------------");
		System.out.println(Arrays.toString(vetor));

		
	}
	
	public static void quickSort(Integer[] vetor, int esquerda, int direita) {
		if(esquerda < direita) {
			int pivot = particaoMeio(vetor, esquerda, direita);
			quickSort(vetor, esquerda, pivot-1);
			quickSort(vetor, pivot + 1, direita);
		}
	}
	
	//Escolhendo um pivot aleatório
	public static int particaoAle(Integer[] vetor, int left, int right) {
		int range = right - left + 1;
		int rand_pivot_index = (int) (Math.random() * range) + left;
		
		//Troca o valor aleatorio escolhido com a primeira posição
		int aux = vetor[left];
		vetor[left] = vetor[rand_pivot_index];
		vetor[rand_pivot_index] = aux;
		
		int pivot = vetor[left];
		int i = left;
		
		for(int j = left+1; j <= right; j++) {
			if(vetor[j] <= pivot) {
				i++;
				int temp = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = temp;
			}
		}
		int var = vetor[left];
		vetor[left] = vetor[i];
		vetor[i] = var;
		return i;
	}
	
	public static int calculaMediana(Integer[] vetor, int left, int right) {
		int meio = (left+right) / 2;
		Integer[] sorted = {vetor[left], vetor[meio], vetor[right]};
		Arrays.sort(sorted);
		
		if(sorted[1] == vetor[left]) {
			return left;
		}else if(sorted[1] == vetor[right]) {
			return right;
		}else {
			return meio;
		}
	}
	
	public static int particaoMeio(Integer[] vetor, int left, int right) {
		int indexPivot = calculaMediana(vetor, left, right);
		
		int aux = vetor[left];
		vetor[left] = vetor[indexPivot];
		vetor[indexPivot] = aux;
		
		int pivot = vetor[left];
		int i = left;
		
		
		for(int j = left+1; j <= right; j++) {
			if(vetor[j] <= pivot) {
				i++;
				aux = vetor[j];
				vetor[j] = vetor[i];
				vetor[i] = aux;
			}
		}
		aux = vetor[left];
		vetor[left] = vetor[i];
		vetor[i] = aux;
		return i;
	}
}
