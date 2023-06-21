package br.leda;

public class JaQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Escolhendo o pivot de maneira aleatória
	public static int particao(int[] vetor, int left, int right) {
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
		int var = vetor[i];
		vetor[i] = pivot;
		pivot = var;
		return i;
	}
}
