package br.leda;

public class raizQuadrada {

	public static void main(String[] args) {
		System.out.println(raiz(25, 0.4));
	}

	private static double raiz(double x, double erro) {
		double left = 0;
		double right = x;
		double raiz = 0.0;
		
		while(Math.abs(x - raiz*raiz) < erro) {
			double meio = (left + right) / 2;
			
			if(meio * meio == raiz) {
				raiz = meio;
				break;
			}else if(meio  * meio < raiz) {
				left = meio + 1;
				raiz= meio;
			}else {
				right = meio - 1;
				raiz = meio;
			}
		}
		return (float) raiz;
	}
}
