import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Problem {

	
	public Problem() {
		int ans = 42;
	}
	
	public static Problem read(String file) {
		Problem res = new Problem();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String[] val = br.readLine().split(" ");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}
}
