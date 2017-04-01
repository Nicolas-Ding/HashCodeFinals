import java.io.IOException;
import java.util.ArrayList;


public class main {
	
	final int threshStep = 5;

	

	public static void main(String[] args) throws IOException {
		String fichier = "charleston_road";
		//String fichier = "lets_go_higher";
		//String fichier = "opera";
		//String fichier = "rue_de_londres";
		// TODO Auto-generated method stub
		Problem problem = new Problem();
		problem.read(fichier + ".in");
		
		while(true) {
			for (int r = 0; r < problem.rowNb; r++) {
				for (int c = 0; c < problem.colNb; c++) {
					Case current = problem.map.map[r][c];
					if (current instanceof Target || current instanceof Vide) {
						ArrayList<Case> visibles = MapUtils.connected(current, problem.radius, problem.map);
						current.targetVisibles = visibles;
					}
				}
			}
			int bestScore = 0;
			Case bestCase = null;
			for (int r = 0; r < problem.rowNb; r++) {
				for (int c = 0; c < problem.colNb; c++) {
					Case current = problem.map.map[r][c];
					if (bestScore < 1000 * current.targetVisibles.size()) {
						ArrayList<Case> trajectFromBackbone = MapUtils.getTrajectFromBackbone(current, problem.map);
						int score = (1000 * current.targetVisibles.size())
									- (problem.backbonePrice * trajectFromBackbone.size());
						if (score > bestScore) {
							bestScore = score;
							bestCase = current;
						}
					}
				}	
			}
			if (maxScore > problem.routerPrice) {
				
			}

			
		}
		
	}

}
