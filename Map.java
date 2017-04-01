import java.util.ArrayList;

public class Map {
	int rowNb;
	int colNb;
	Case[][] map;
	
	public Map(int rowNb, int colNb) {
		this.rowNb = rowNb;
		this.colNb = colNb;
		this.map = new Case[rowNb][];
		for (int i = 0; i < rowNb; i++) {
			map[i] = new Case[colNb];
		}
	}
	
	
}
