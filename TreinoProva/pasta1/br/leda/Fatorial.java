package br.leda;

public class Fatorial {
	public static void main(String[] args) {
		//System.out.println(fatorial(3));
		//recursivaT1(0);
		//System.out.println("-----------------");
		//recursivaT2(0);
		int[] array = {2,7,1,4};
		//System.out.println(calcularSomaArray(array));
		System.out.println(progressaoAritmetica(2,3,9));
	}
	
	public static int progressaoAritmetica(int termoInicial, int razao, int n) {
		int termo = termoInicial;
		if(n == 1) {
			termo = termoInicial;
		}else {
			termo = progressaoAritmetica(termo, razao, n - 1) + razao;
		}
		
		return termo;
	}
	
	public static int calcularSomaArray(int[] array){
		return calcularSomaArray(array, 0);
	}
	
	private static int calcularSomaArray(int[] array, int indice) {
		int soma = 0;
		if(indice == array.length - 1) {
			soma = array[indice];
		}else {
			soma = array[indice] + calcularSomaArray(array, indice + 1);
		}
		return soma;
	}
	
	public static int fatorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return(n * fatorial(n-1));
		}
	}
	
	public static void recursivaT1(int num) {
		System.out.println(num);
		if( num < 4) {
			recursivaT1(num +1);
		}
	}
	
	public static void recursivaT2(int num) {
		if(num < 4) {
			recursivaT2(num +1);
		}
		System.out.println(num);
	}

}
