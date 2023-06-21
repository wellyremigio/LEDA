package br.leda;


public class Bidirecional {

	public static void main(String[] args) {
		Integer[] array = {9, 15, 1, 5, 4, 3, 2, 1, 20, 0};
		int leftIndex = 0;
		int rightIndex = array.length-1;
		
		boolean trocou = true;
		while(trocou) {
			trocou = false;
			for(int i = leftIndex; i <= rightIndex - 1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					int aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					trocou = true;
				}
			}
			
			for(int j = rightIndex - 1; j >= leftIndex; j--) {
				if(array[j].compareTo(array[j+1]) > 0) {
					int aux = array[j];
					array[j] = array[j+1];
					array[j+1] = aux;
					trocou = true;
				}
			}
		}
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
