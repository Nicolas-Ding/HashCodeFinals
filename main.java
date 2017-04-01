import java.io.IOException;


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
		System.out.println(problem.toString());

	}

}
