package br.leda;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] vetor = { 4, 9, 3, 4, 0, 5, 1, 4 };
		System.out.println(Arrays.toString(vetor));
		mergeSort(vetor, 0, vetor.length-1);
		System.out.println("--------------------");
		System.out.println(Arrays.toString(vetor));
	}
	
	public static void mergeSort(Integer[] vetor, int inicio, int fim) {
		if(inicio >= fim) {
			return;
		}else {
			int meio = (inicio + fim)/2;
			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio+1, fim);
			merge(vetor, inicio, meio, fim);
		}
	}
	
	
	private static void merge(Integer[] vetor, int inicio, int meio, int fim) {
		Integer[] vetorAux = new Integer[vetor.length];
		for(int i = inicio; i <= fim; i++) {
			vetorAux[i] = vetor[i];
		}
		
		int i = inicio;
		int j = meio+1;
		int k = inicio;
		
		while(i <= meio && j <= fim) {
			if(vetorAux[i] <= vetorAux[j]) {
				vetor[k++] = vetorAux[i++];
			}else {
				vetor[k++] = vetorAux[j++];
			}
		}
		//Caso a parte direita acabe antes, fazemos o append da parte esquerda.
		while(i <= meio) {
			vetor[k++] = vetorAux[i++];
		}
		
		//Caso a parte da esquerda acabe antes, fazemos o append da parte direita.
		while(j <= fim) {
			vetor[k++] = vetorAux[j++];
		}
	}
}
