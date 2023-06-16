package revisao;

import java.util.Set;

public class ConsecutiveParent {
	
	/*public Set<Pair> findConsecutive(){
		TreeSet<Pair> set = new TreeSet<>();
		BSTNode root = this.getRoot();
		search(set, root);
	}
	
	private void search(Set<Pair> set, BSTNode root) {
		if(!root.isEmpty()) {
			if(!root.getLeft().isEmpty() && (root.getData() - root.getLeft().getData()) == 1) {
				set.add(new Pair(root.getData(), root.getLeft().getData()));
			}
			if(!root.getRight().isEmpty() && (root.getData() - root.getRight().getData()) == 1) {
				set.add(new Pair(root.getData(), root.getRight().getData()));
			}
			search(set, root.getLeft());
			search(set, root.getRight());
		}
	}
	*/

}
