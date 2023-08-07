package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		
		return result;
	}
	
	public int calcularFatorial(int n) {
		int fatorial = 0;
		if(n == 0) {
			return 1;
		}else {
			fatorial = n * calcularFatorial(n - 1);
		}
		System.out.println(n + "! = " + fatorial);
		return fatorial;
	}

	public int calcularFibonacci(int n) {
		int seq = 1;
		if(n == 1 || n == 2) {
			
		}else {
			seq = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}
		return seq;
	}
	
	public int countNotNull(Object[] array) {
		return contadorNull(array, 0);
	}
	
	private int contadorNull(Object[] array, int indice) {
		int resp = 0;
		if(indice == array.length - 1) {
			if(array[indice] != null) {
				resp = 1;
			}
		}else {
			if(array[indice] != null) {
				resp = 1;
			}
			resp += contadorNull(array, indice + 1);
		}
		return resp;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if(expoente == 0) {
			return 1;
		} else {
			result = 2 * potenciaDe2(expoente -1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double termo = termoInicial;
		if(n == 1) {
			
		}else {
			termo = progressaoAritmetica(termo, razao, n-1) + razao;
		}
		return termo;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double termo = termoInicial;
		if(n == 1) {
			
		}else {
			termo = progressaoGeometrica(termo, razao, n - 1) * razao;
		}
		return termo;
	}
}
