package treinandoProva;


public class Reverse {
	
	public String reverse(List list) {
		String result = "";
		if(list.hasNext()) {
			int next = list.next();
			if(list.hasNext()) {
				result = reverse(list) + ", " + next;
			}else {
				result = "" + next;
			}
		}
		return result;
	}
	

}

class List {
    private int[] array;
    private int i;

    List(int[] array) {
        this.array = array;
        this.i = -1;
    }

    boolean hasNext() {
        return i != array.length - 1;
    }

    int next() {
        i++;
        return array[i];
    }
}
