package br.leda;

import java.util.Arrays;

public class OddEven {

	public static void main(String[] args) {
		Integer[] vetor = {9, 15, 1, 5, 4, 3, 2, 1, 20, 0};
		System.out.println("Antes: "+Arrays.toString(vetor));
		
		//Odd-even
		boolean trocou = true;
		while(trocou) {
			trocou = false;
			for(int i = 1; i < vetor.length-1; i+= 2) {
				if(vetor[i] > vetor[i+1]) {
					int aux = vetor[i];
					vetor[i] = vetor[i+1];
					vetor[i+1] = aux;
					trocou = true;
				}
			}
			for(int i = 0; i < vetor.length-1; i+= 2) {
				if(vetor[i] > vetor[i+1]) {
					int aux = vetor[i];
					vetor[i] = vetor[i+1];
					vetor[i+1] = aux;
					trocou = true;
				}
			}
		}
		System.out.println("Depois: "+Arrays.toString(vetor));

	}

}
