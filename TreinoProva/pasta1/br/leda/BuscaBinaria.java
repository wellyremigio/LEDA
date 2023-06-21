package br.leda;

public class BuscaBinaria {

	public static void main(String[] args) {
		int[] array = {4, 15, 25, 30, 38, 84, 96};
		System.out.println(buscaBinaria(array, 4, 0, array.length-1));
	}
	
	public static int buscaBinaria(int[] array, int x, int left, int right) {
		int result = -1;
		if(left <= right && left >= 0 && right <= array.length) {
			int meio = (left + right) / 2;
			if(x == array[meio]) {
				return meio;
			}else if(x < array[meio]) {
				result = buscaBinaria(array, x, left, meio - 1);
			}else {
				result = buscaBinaria(array, x, meio + 1, right);
			}
		}
		return result;
	}
}
