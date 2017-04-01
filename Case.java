


public class Case {
	final int MUR = -1;
	final int ROUTEUR = 2;
	final int VIDE = 0;
	final int TARGET = 1;
	
	final int NOT_BACKBONE = 0;
	final int INITIAL_BACKBONE = 1;
	final int ADDED_BACKBONE = 2;
	
	int x;
	int y;
	int backbone;
	boolean connected;
	
	public Case() {
		
	}
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
