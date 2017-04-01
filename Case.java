public class Case {
	public static final int NOT_BACKBONE = 0;
	public static final int INITIAL_BACKBONE = 1;
	public static final int ADDED_BACKBONE = 2;
	
	int x;
	int y;
	int backbone;
	boolean connected;
	
	
	// pour test, par exemple : if map[x][y] instanceOf Routeur
	
	public Case() {
		
	}
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
