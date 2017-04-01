import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Problem {
	int rowNb;
	int colNb;
	int radius;
	int backbonePrice;
	int routerPrice;
	int budget;
	Map map;
	
	public Problem() {

	}
	
	public Problem read(String file) {
		Problem res = new Problem();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			//First Line
			String[] data = br.readLine().split(" ");
			this.rowNb = Integer.parseInt(data[0]);
			this.colNb = Integer.parseInt(data[1]);
			this.radius = Integer.parseInt(data[2]);
			map = new Map(rowNb, colNb);
			
			//Second line
			data = br.readLine().split(" ");
			this.backbonePrice = Integer.parseInt(data[0]);
			this.routerPrice = Integer.parseInt(data[1]);
			this.budget = Integer.parseInt(data[2]);
			
			//Third line
			data = br.readLine().split(" ");
			int startX = Integer.parseInt(data[0]);
			int startY = Integer.parseInt(data[1]);
			
			for (int r = 0; r < rowNb; r++) {
				String line = br.readLine();
				for (int c = 0; c < colNb; c++) {
					if (line.charAt(c) == '#') {
						map.set(r,c,new Mur(r,c,this.radius));
					}
					if (line.charAt(c) == '.') {
						map.set(r,c,new Target(r,c,this.radius));
					}
					if (line.charAt(c) == '-') {
						map.set(r,c,new Vide(r,c,this.radius));
					}
				}
			}
			
			//set connected
			map.map[startX][startY].backbone = Case.INITIAL_BACKBONE; 

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}
	
	public String toString() {
		String ans = "";
		for (int r = 0; r < map.rowNb; r++) {
			for (int c = 0; c < map.colNb; c++) {
				if (map.map[r][c] instanceof Mur)
					ans += "m"; 
				if (map.map[r][c] instanceof Vide)
					ans += "-";
				if (map.map[r][c] instanceof Target)
					ans += ".";
				if (map.map[r][c] instanceof Routeur)
					ans += "r";
			}
			ans += "\n";
		}
		return ans;
	}
}
