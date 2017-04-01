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
		int step = 0;
		while(step < 20) {
			//System.out.println(step);
			for (int r = 0; r < problem.rowNb; r++) {
				for (int c = 0; c < problem.colNb; c++) {
					Case current = problem.map.map[r][c];
					if (current instanceof Target || current instanceof Vide) {
						ArrayList<Case> visibles = MapUtils.connected(current, problem.radius, problem.map);
						current.targetVisibles = visibles;
						//System.out.print(visibles.size() + " ");
					}
					//else
						//System.out.print("----");
				}
				//System.out.println();
			}
			int bestScore = 0;
			Case bestCase = null;
			for (int r = 0; r < problem.rowNb; r++) {
				for (int c = 0; c < problem.colNb; c++) {
					Case current = problem.map.map[r][c];
					if (current instanceof Target || current instanceof Vide) {
						if (bestScore < 1000 * (current.targetVisibles.size()+1)) {
							ArrayList<Case> trajectFromBackbone = MapUtils.getTrajectFromBackbone(current, problem.map);
							int score = (1000 * (current.targetVisibles.size()+1))
										- (problem.backbonePrice * trajectFromBackbone.size());
							if (score > bestScore) {
								bestScore = score;
								bestCase = current;
							}
							
						}
					}
				}	
			}
			if (bestScore > problem.routerPrice) {
				for(Case current : bestCase.targetVisibles) {
					current.connected = true;
				}
				for (Case current : bestCase.trajetFromBackbone) {
					problem.map.setBackbone(current.x, current.y);
					problem.map.backbones.add(current);
				}
				problem.map.set(bestCase.x, bestCase.y, new Routeur(bestCase.x, bestCase.y, problem.radius));
			}
			else {
				break;
			}
			
			step++;
		}
		
	}

}
