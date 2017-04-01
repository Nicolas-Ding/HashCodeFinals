import java.util.ArrayList;

public class Map {
	int rowNb;
	int colNb;
	
	int nbRouteur;
	
	ArrayList<Case> backbones;
	Case[][] map;
	
	public Map(int rowNb, int colNb) {
		this.rowNb = rowNb;
		this.colNb = colNb;
		this.map = new Case[rowNb][];
		for (int i = 0; i < rowNb; i++) {
			map[i] = new Case[colNb];
		}
	}
	
	public void setBackbone(int x, int y) {
		Case current = map[x][y];
		if (current != null)
		{
			if (current.backbone == Case.INITIAL_BACKBONE) {
				System.err.println("Error : Attempting to change initial backbone");
				return;
			}
			if (current.backbone == Case.ADDED_BACKBONE) {
				System.err.println("Error : Attempting to put backbone to existing value");
				return;
			}
		}
		current.backbone = Case.ADDED_BACKBONE;
		backbones.add(current);
	}
	
	public void removeBackbone(int x, int y) {
		Case current = map[x][y];
		if (current.backbone == Case.INITIAL_BACKBONE) {
			System.err.println("Error : Attempting to remove initial backbone");
			return;
		}
		if (current.backbone == Case.NOT_BACKBONE) {
			System.err.println("Error : Attempting to remove backbone in nonexisting backbone");
			return;
		}
		current.backbone = Case.NOT_BACKBONE;
		backbones.remove(current);
	}
	
	public void remove(int x, int y) {
		Case oldCase = map[x][y];
		if (oldCase instanceof Routeur) {
			nbRouteur--;
		}
		if (oldCase.backbone == Case.ADDED_BACKBONE) {
			this.removeBackbone(x, y);
		}
		map[x][y] = null;
	}
	
	public void set(int x, int y, Case newCase) {
		Case oldCase = map[x][y];
		if (oldCase != null)
		{
			newCase.connected = oldCase.connected;
			if (oldCase.backbone == Case.ADDED_BACKBONE) {
				newCase.backbone = Case.ADDED_BACKBONE;
			}
		}
		map[x][y] = newCase;
		if (newCase.backbone == Case.ADDED_BACKBONE) {
			this.setBackbone(x, y);
		}
		if (newCase instanceof Routeur) {
			nbRouteur++;
		}
	}
	
	
}
