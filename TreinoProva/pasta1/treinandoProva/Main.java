package treinandoProva;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//PeaksValleys p = new PeaksValleys();
		//
		///p.sortValley(vetor, 0, vetor.length-1);
		//Arrays.sort(vetor);
		//System.out.println(Arrays.toString(vetor));
		//MaxElementBitonicArray m = new MaxElementBitonicArray();
		//SearchInBitonicArray s = new SearchInBitonicArray();
		Integer[] vetor = {32, 28, 17, 9, 3};
		BinarySearchOrderNotKnow b = new BinarySearchOrderNotKnow();
		KLargest<Integer> k = new KLargest<>();
		System.out.println(k.quickRecursivo(vetor, 3, 0, vetor.length-1));
		
		
	}
}
