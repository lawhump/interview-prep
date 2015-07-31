public class AVLNode extends Node {
	private int balanceFactor;

	public AVLNode() {
		super();
		balanceFactor = 0;
	}

	public AVLNode(int v) {
		super(v);
		balanceFactor = 0;
	}

	public AVLNode(Node n) {
		super(n);
		balanceFactor = 0;
	}

	public AVLNode(AVLNode avln) {
		this.val = avln.val;
		this.left = avln.val;
		this.right = avln.val;
		this.balanceFactor = avln.balanceFactor;
	}

	public int getBalanceFactor() {
		return this.balanceFactor;
	}

	public int setBalanceFactor(int bf) {
		this.balanceFactor = bf;
	}
}