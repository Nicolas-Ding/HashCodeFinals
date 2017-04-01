import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


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
		Case bestCase = null;
		int cout = 0;
		
		while(step < 2000) {
			if (step % 10 == 0)
				System.out.println(step);
			if (step==0) {
				for (int r = 0; r < problem.rowNb; r++) {
					for (int c = 0; c < problem.colNb; c++) {
						Case current = problem.map.map[r][c];
						if (current instanceof Target || current instanceof Vide) {
							ArrayList<Case> visibles = MapUtils.connected(current, problem.radius, problem.map);
							current.targetVisibles = visibles;
							//System.out.print(visibles.size() + " ");
							
						}
						/*else
							System.out.print("----");*/
					}
					//System.out.println();
				}
				//return;
			}
			else {
				for (int r = Math.max(0, bestCase.x - 2*problem.radius); r < Math.min(problem.rowNb, bestCase.x + 2*problem.radius); r++) {
					for (int c = Math.max(0, bestCase.y - 2*problem.radius); c < Math.min(problem.colNb,  bestCase.y + 2*problem.radius); c++) {
						Case current = problem.map.map[r][c];
						if (current instanceof Target || current instanceof Vide) {
							ArrayList<Case> visibles = MapUtils.connected(current, problem.radius, problem.map);
							current.targetVisibles = visibles;
							//System.out.print(visibles.size() + " ");
						}
						//else
							//System.out.print("----");
					}
				}
			}
			int bestScore = 0;
			bestCase = null;
			for (int r = 0; r < problem.rowNb; r++) {
				for (int c = 0; c < problem.colNb; c++) {
					Case current = problem.map.map[r][c];
					if (current instanceof Target || current instanceof Vide) {
						if (bestScore < 1000 * (current.targetVisibles.size() + (!current.connected && current instanceof Target ? 1 : 0))) {
							ArrayList<Case> trajectFromBackbone = MapUtils.getTrajectFromBackbone(current, problem.map);
							current.trajetFromBackbone = trajectFromBackbone;
							int score = (1000 * (current.targetVisibles.size()+ (!current.connected && current instanceof Target ? 1 : 0)))
										- (problem.backbonePrice * trajectFromBackbone.size());
							if (score > bestScore) {
								bestScore = score;
								bestCase = current;
							}
							
						}
					}
				}	
			}

			if (bestScore > problem.routerPrice && cout +  problem.backbonePrice * bestCase.trajetFromBackbone.size() + problem.routerPrice < problem.budget) {
				cout += problem.backbonePrice * bestCase.trajetFromBackbone.size() + problem.routerPrice;
				for(Case current : bestCase.targetVisibles) {
					current.connected = true;
				}
				int lastCorrectIndex = -1;
				for (int i = 0; i < bestCase.trajetFromBackbone.size() ; i++) {
					Case current = bestCase.trajetFromBackbone.get(i);
					if (
							problem.map.map[current.x][current.y].backbone == Case.ADDED_BACKBONE 
							|| problem.map.map[current.x][current.y].backbone == Case.INITIAL_BACKBONE )
						lastCorrectIndex = i;
				}
				for (int i = lastCorrectIndex + 1; i < bestCase.trajetFromBackbone.size() ; i++) {
					Case current = bestCase.trajetFromBackbone.get(i);
					problem.map.setBackbone(current.x, current.y);
				}
				problem.map.set(bestCase.x, bestCase.y, new Routeur(bestCase.x, bestCase.y, problem.radius));
				problem.map.routeurs.add(problem.map.map[bestCase.x][bestCase.y]);
			}
			else {
				break;
			}
			
			step++;
		}
		
		Problem.writer(problem.map, fichier + ".out");
	}

}
