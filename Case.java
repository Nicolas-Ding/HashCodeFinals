public class Case {
	public static final int MUR = -1;
	public static final int ROUTEUR = 2;
	public static final int VIDE = 0;
	public static final int TARGET = 1;
	
	public static final int NOT_BACKBONE = 0;
	public static final int INITIAL_BACKBONE = 1;
	public static final int ADDED_BACKBONE = 2;
	
	int x;
	int y;
	int type;
	int backbone;
	boolean connected;
	
	public Case() {
		
	}
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
