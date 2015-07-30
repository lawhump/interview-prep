public interface Trees {
	Node getHead();
	
	void insert(int v);
	Node find(int v);

	void levelOrderTraversal();
	void preOrderTraversal();
	void inOrderTraversal();
	void postOrderTraversal();
}