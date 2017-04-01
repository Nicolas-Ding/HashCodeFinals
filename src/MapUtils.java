import java.util.ArrayList;

public class MapUtils {

	public static ArrayList<Case> connected(Case source, int R, Map map) {
		ArrayList<Case> res = new ArrayList<Case>();
		Integer[][] flag = new Integer[2*R+1][2*R+1]; 
		int x = source.x;
		int y = source.y;
		int i = map.map.length;
		int j = map.map[0].length;
		
		for (int k = R+1; k < 2*R+1 ;k++) {
			for (int l = R+1; l < 2*R+1 ; l++) {
				if (k-R+x >= i || l-R+y >=j || flag[k][l] == null) {
					flag[k][l] = null;
				}
				else {
					if (map.map[k-R+x][l-R+y] instanceof Mur) {
						flag[k][l] = null;
						for (int m = k; m < R+1; m++) {
							for (int n = l; l < R+1; n++) {
								if (flag[m][n] == null)
									break;
								else {
									flag[m][n] = null;
									
								}
							}
						}
					}
					else
						res.add(map.map[k-R+x][l-R+y]);
				}
			}
		}
		
		for (int k = R+1; k < 2*R+1 ;k++) {
			for (int l = R-1; l >=0 ; l--) {
				if (k-R+x >= i || l-R+y < 0 || flag[k][l] == null) {
					flag[k][l] = null;
				}
				else {
					if (map.map[k-R+x][l-R+y] instanceof Mur) {
						flag[k][l] = null;
						for (int m = k; m < R+1; m++) {
							for (int n = l; l < R+1; n++) {
								if (flag[m][n] == null)
									break;
								else {
									flag[m][n] = null;
									
								}
							}
						}
					}
					else
						res.add(map.map[k-R+x][l-R+y]);
				}
			}
		}
		
		return res;
	}
	
}
