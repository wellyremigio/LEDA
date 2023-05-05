package problems;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, possivelmente com mais de uma ocorrencia,
 * usar busca binária para encontrar as posicoes da primeira e ultima ocorrencias de x em  A.

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].

 * Restricoes: 
 * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Retornar um array com dois elementos [primeiraPosicao,ultimaPosicao], onde primeiraPosicao
 *   tem o valor do indice da primeira ocorrencia de x em A, e ultimaPosicao tem o valor do indice 
 *   da ultima ocorrencia de x em A
 * - Note que se x nao esta em A entao o retorno deve ser [-1,-1]
 *
 */
public class StartEndPositionImpl implements StartEndPosition{


	@Override
	public int[] startEndPosition(Integer[] array, Integer x){
		if(array != null && array.length > 0 && x != null) {
			int firstPos = firstPosition(array, x);
			int lastPos = lastPosition(array, x);
			int[] firstLastPosition = {firstPos, lastPos}; 
			return firstLastPosition;
		}
		return null;
	}
	
	private int firstPosition(Integer[] array, Integer x) {
		int left = 0;
		int right = array.length-1;
		int firstPosition = -1;
		
		if(array[left].compareTo(x)==0) {
			return 0;
		}
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(array[meio].compareTo(x) == 0) { 
				firstPosition = meio;
				right = meio - 1;
				
			}else if(array[meio].compareTo(x) < 0) {
				left = meio + 1;
				
			}else {
				right = meio - 1;
			}
		}
		return firstPosition;
	}
	
	private int lastPosition(Integer[] array, Integer x) {
		int left = 0;
		int right = array.length-1;
		int lastPosition = -1;
		
		if(array[right].compareTo(x) == 0) {
			return right;
		}
		
		while(left <= right) {
			int meio = (left + right) / 2;
			
			if(array[meio].compareTo(x) == 0) {
				lastPosition = meio;
				left = meio +1;
				
			}else if(array[meio].compareTo(x) > 0) {
				right = meio -1;
				
			}else {
				left = meio + 1;
			}
		}
		return lastPosition;
	}
}
