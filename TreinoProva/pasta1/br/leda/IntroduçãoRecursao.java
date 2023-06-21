package br.leda;

import java.util.Scanner;

public class IntroduçãoRecursao {
	/*
	 * Nesse caso ele vai imprimir de forma decrescente.
	 * Porém como não tem critério de parada vai dar um StackOverFlow.
	 */
	public static void printSeqRecursiva(int k) {
		System.out.println(k);
		printSeqRecursiva(k - 1) ;
	}
	
	public static int fatorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return(n * fatorial(n-1));
		}
	}
	
	public static void printSeqFinito(int k) {
		if(k >= 0) {
			System.out.println(k);
			printSeqFinito(k - 1);
		}
	}
	
	public static void printSeqFinita2(int k) {
		if(k >= 0) {
			printSeqFinita2(k - 1);
			System.out.println(k);
		}
	}
	
	public static void imprimeSeq(int k) {
		printSeqRecIndireta(k);
	}
	
	public static void printSeqRecIndireta(int k) {
		if(k >= 0) {
			System.out.println(k);
			printSeqRecIndireta(k - 1);
			System.out.println("Fim da chamada em k = " + k);
		}
	}
	
	public static int calc(int[] array) {
		return calcZeros(array, 0);
	}
	
	public static int calcZeros(int[] array, int indice) {
		int zeros = 0;
		if(indice == array.length - 1) {
			if(array[indice] == 0) {
				zeros = 1;
			}
		}else {
			if(array[indice] == 0) {
				zeros = 1;
			}
			zeros += calcZeros(array,indice + 1);
		}
		return zeros;
	}
	
		//calcular o valor minimo de um array de forma recursiva
		public static int minimumRecursive(int[] array){
			int minimo = 0;
			if(array.length > 0) {
				minimo = minimumRecursive(array, 0);
			}
			return minimo;
		}
			
		private static int minimumRecursive(int[] array, int posicao) {
			int minimo = array[posicao];
			if(posicao == array.length -1) {
				if(array[posicao] < minimo) {
					minimo = array[posicao];
				}
			}
			else {
				int proxMin = minimumRecursive(array, posicao + 1);
				if(proxMin < minimo) {
					minimo = proxMin;
				}
			}
			return minimo;
		}
		
		public static int somaRecursiva(int k) {
			int soma = 0;
			if(k == 0) {
				
			}else {
				soma = k + somaRecursiva(k - 1);
			}
			return soma;
		}
		
		public static boolean isPalindrome(String palavra) {
			boolean ehPali = true;
			if(palavra.equals("") || palavra.length() == 1) {
				//não faz nada
			}else {
				ehPali = palavra.charAt(0) == palavra.charAt(palavra.length() - 1);
				if(ehPali) {
					ehPali = isPalindrome(palavra.substring(1, palavra.length()- 1));
				}
			}
			return ehPali;
		}
		
		//Wrong 
		public static String reverso(String palavra) {
			if(palavra == null || palavra.equals("")) {
				return palavra;
			}else {
				return reverso(palavra.substring(0) + palavra.charAt(0));
			}
		}
		
		public static int mod(int val, int div) {
			if(val < div) {
				return val;
			}else {
				return mod(val - div, div);
			}
		}
		
		public static String revStr(String palavra) {
			if(palavra == null) {
				return palavra;
			}
			return tailReverse(palavra, "");
		}
		
		public static String tailReverse(String palavra, String res) {
			if(palavra.equals("")) {
				return res;
			}else {
				return tailReverse(palavra.substring(1), palavra.charAt(0)+ res);
			}
		}
		
		public static boolean buscaLinear(int[] array, int x, int indice) {
			boolean resp = false;
			if(indice < array.length) {
				if(array[indice] == x) {
					resp = true;
				}else {
					resp = buscaLinear(array, x, indice +1);
				}
			}
			return resp;
		}
		
		public static boolean buscaLinear(int[] array, int x) {
			return buscaLinear(array, x, 0);
		}
		
	
	
	
	public static void main(String[] args) {
		//printSeqFinito(4);
		System.out.println("--------------");	
		//printSeqFinita2(4);
		//imprimeSeq(4);
		//Scanner leitor = new Scanner(System.in);
		//int[] num = {5,2,7,1,9,-1,0};
		//System.out.println(minimumRecursive(num));
		//System.out.println(mod(5, 3));
		//System.out.println(reverso("ovo"));
		System.out.println(revStr("bola"));
	}

}
