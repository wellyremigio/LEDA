package br.leda;

import java.util.Arrays;

public class QuickSelection {

	public static void main(String[] args) {
		int[] array = {25, 38, 15, 96, 4, 30, 84};
		
	}
	
	
	public static int quickSelection(int[] array, int left, int right, int k) {
		int posicaoPivot = partition(array,left, right);
		if(k == posicaoPivot) {
			return array[posicaoPivot];
		}else if(k < posicaoPivot) {
			return quickSelection(array, left, posicaoPivot, k);
		}else {
			return quickSelection(array, posicaoPivot+1, right, k);
		}
	}
	
	public static int partition(int[] array, int left, int right) {
		int indexPivot = mediana(array, left, right);
		
		int aux = array[left];
		array[left] = array[indexPivot];
		array[indexPivot] = aux;
		
		int pivot = array[left];
		int i = left;
		
		for(int j =  left + 1; j <= right; j++) {
			if(array[j] <= pivot) {
				i++;
				aux = array[j];
				array[j] = array[i];
				array[i] = aux;
			}
		}
		aux = array[i];
		array[i] = array[left];
		array[left] = aux;
		return i;
	}
	
	public static int mediana(int[] array, int left, int right) {
		int meio = (left + right) / 2;
		int[] arrayAux = {array[left], array[meio], array[right]};
		Arrays.sort(arrayAux);
		
		if(arrayAux[1] == array[left]) {
			return left;
		}else if(arrayAux[1] == array[meio]) {
			return meio;
		}else {
			return right;
		}
	}
}
