package treinandoProva;

public class FindNextLetter {
	
	private int findNext(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;
		
		char next = letters[left];
		
		while(left <= right) {
			int meio = (left + right) / 2;
			if(target < letters[meio]) {
				next = letters[meio];
				right = meio - 1;
				
			}else {
				left = meio + 1;
			}
		}
		return next;
	}

}
