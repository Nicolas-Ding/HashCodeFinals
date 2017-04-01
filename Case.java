import java.util.ArrayList;

public class Case {
	public static final int NOT_BACKBONE = 0;
	public static final int INITIAL_BACKBONE = 1;
	public static final int ADDED_BACKBONE = 2;
	
	int x;
	int y;
	int backbone;
	int R;
	boolean connected;
	ArrayList<Case> trajetFromBackbone;
	int distanceFromBackbone;
	ArrayList<Case> targetVisibles;
	
	
	// pour test, par exemple : if map[x][y] instanceOf Routeur
	
	public Case(int R) {
		this.R = R;
		targetVisibles = new ArrayList<>();
	}
	
	public Case(int x, int y, int R) {
		this.x = x;
		this.y = y;
		this.R = R;
	}
}
