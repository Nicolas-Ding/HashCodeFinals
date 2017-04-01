import java.util.ArrayList;
import java.util.Arrays;

public class MapUtils {
	
	public static void AddToRes(ArrayList<Case> res, Map map, int x, int y) {
		if (map.map[x][y] instanceof Target && map.map[x][y].connected == false)
			res.add(map.map[x][y]);
	}

	public static ArrayList<Case> connected(Case source, int R, Map map) {
        ArrayList<Case> res = new ArrayList<>();
        Integer[][] flag = new Integer[2*R+1][]; 
        for (int i = 0; i < 2*R + 1; i++) {
        	flag[i] = new Integer[2*R+1];
        	Arrays.fill(flag[i], 0);
        }
        int x = source.x;
        int y = source.y;
        int i = map.map.length;
        int j = map.map[0].length;
        
        for (int k = R+1; k < 2*R+1; k++) {
        	  if (k-R+x >= i || flag[k][R] == null) {
                  flag[k][R] = null;
              } 
        	  else {
                  if (map.map[k-R+x][y] instanceof Mur) {
                      flag[k][R] = null;
                      for (int m = k; m < 2*R+1; m++) {
                    	  for (int n = 0; n < 2*R+1; n++) {
                    		  flag[m][n] = null;
                    	  }
                      }
                      break;
                  }
                  else
                	  AddToRes(res, map, k-R+x,y);
              }
        }
        
        for (int k = R-1; k >= 0; k--) {
      	  if (k-R+x < 0 || flag[k][R] == null) {
                flag[k][R] = null;
            } 
      	  else {
                if (map.map[k-R+x][y] instanceof Mur) {
                    flag[k][R] = null;
                    for (int m = k; m >= 0; m--) {
                  	  for (int n = 0; n < 2*R+1; n++) {
                  		  flag[m][n] = null;
                  	  }
                    }
                    break;
                }
                else
                	AddToRes(res, map, k-R+x,y);
            }
        }
        
        for (int l = R+1; l < 2*R+1; l++) {
      	  if (l-R+y >= j || flag[R][l] == null) {
                flag[R][l] = null;
            } 
      	  else {
                if (map.map[x][l-R+y] instanceof Mur) {
                    flag[R][l] = null;
                    for (int n = l; n < 2*R+1; n++) {
                  	  for (int m = 0; m < 2*R+1; m++) {
                  		  flag[m][n] = null;
                  	  }
                    }
                    break;
                }
                else
                	AddToRes(res, map, x,l-R+y);
            }
        }
        
        for (int l = R-1; l >= 0; l--) {
        	  if (l-R+y < 0 || flag[R][l] == null) {
                  flag[R][l] = null;
              } 
        	  else {
                  if (map.map[x][l-R+y] instanceof Mur) {
                      flag[R][l] = null;
                      for (int n = l; n >= 0; n--) {
                    	  for (int m = 0; m < 2*R+1; m++) {
                    		  flag[m][n] = null;
                    	  }
                      }
                      break;
                  }
                  else
                	  AddToRes(res, map, x,l-R+y);
              }
        }
        
        //en bas à droite
        for (int k = R+1; k < 2*R+1 ;k++) {
            for (int l = R+1; l < 2*R+1 ; l++) {
                if (k-R+x >= i || l-R+y >=j || flag[k][l] == null) {
                    flag[k][l] = null;
                }
                else {
                    if (map.map[k-R+x][l-R+y] instanceof Mur) {
                        flag[k][l] = null;
                        for (int m = k; m < 2*R+1; m++) {
                            for (int n = l; n < 2*R+1; n++) {
                                if (flag[m][n] == null)
                                    break;
                                else {
                                    flag[m][n] = null;
                                }
                            }
                        }
                    }
                    else
                    	AddToRes(res, map, k-R+x,l-R+y);
                }
            }
        }
        
        //En bas à gauche
        for (int k = R+1; k < 2*R+1 ;k++) {
            for (int l = R-1; l >= 0 ; l--) {
                if (k-R+x >= i || l-R+y < 0 || flag[k][l] == null) {
                    flag[k][l] = null;
                }
                else {
                    if (map.map[k-R+x][l-R+y] instanceof Mur) {
                        flag[k][l] = null;
                        for (int m = k; m < 2*R+1; m++) {
                            for (int n = l; n >= 0; n--) {
                                if (flag[m][n] == null)
                                    break;
                                else {
                                    flag[m][n] = null;
                                    
                                }
                            }
                        }
                    }
                    else
                    	AddToRes(res, map, k-R+x,l-R+y);
                }
            }
        }
        
        //en haut à gauche
        for (int k = R-1; k >= 0 ;k--) {
            for (int l = R-1; l >=0 ; l--) {
                if (k-R+x < 0 || l-R+y < 0 || flag[k][l] == null) {
                    flag[k][l] = null;
                }
                else {
                    if (map.map[k-R+x][l-R+y] instanceof Mur) {
                        flag[k][l] = null;
                        for (int m = k; m >=0; m--) {
                            for (int n = l; n >=0; n--) {
                                if (flag[m][n] == null)
                                    break;
                                else {
                                    flag[m][n] = null;
                                    
                                }
                            }
                        }
                    }
                    else
                    	AddToRes(res, map, k-R+x,l-R+y);
                }
            }
        }
        
        //en haut à droite
        for (int k = R-1; k >= 0 ;k--) {
            for (int l = R+1; l < 2*R+1 ; l++) {
                if (k-R+x < 0 || l-R+y >=j || flag[k][l] == null) {
                    flag[k][l] = null;
                }
                else {
                    if (map.map[k-R+x][l-R+y] instanceof Mur) {
                        flag[k][l] = null;
                        for (int m = k; m >=0 ; m--) {
                            for (int n = l; n < 2*R+1; n++) {
                                if (flag[m][n] == null)
                                    break;
                                else {
                                    flag[m][n] = null;
                                    
                                }
                            }
                        }
                    }
                    else
                    	AddToRes(res, map, k-R+x,l-R+y);
                }
            }
        }
        return res;
    }
	
	static public ArrayList<Case> getTrajectFromBackbone(Case source, Map map){
        ArrayList<Case> res = new ArrayList<Case>();
        int minDist = Math.max(map.rowNb, map.colNb);
        Case caseTemp = null;
        for (Case c : map.routeurs) {
            int tempDist = Math.max(Math.abs(source.x-c.x), Math.abs(source.y-c.y));
            if (tempDist < minDist) {
                caseTemp = c;
                minDist = tempDist;
            }
        }
        int signX = (int) Math.signum(source.x-caseTemp.x);
        int signY = (int) Math.signum(source.y-caseTemp.y);
        for (int i = 1; i <= Math.min(Math.abs(source.x-caseTemp.x), Math.abs(source.y-caseTemp.y)); i++) {
            res.add(map.map[caseTemp.x+i*signX][caseTemp.y+i*signY]);
        }
        if (Math.abs(source.x-caseTemp.x) > Math.abs(source.y-caseTemp.y)) {
            for (int i = 1; i <= Math.abs(source.x-caseTemp.x) - Math.abs(source.y-caseTemp.y);i++) {
                res.add(map.map[caseTemp.x+(i+Math.abs(source.y-caseTemp.y))*signX][source.y]);
            }
        }
        else {
            for (int i = 1; i <= Math.abs(source.y-caseTemp.y) - Math.abs(source.x-caseTemp.x);i++) {
                res.add(map.map[source.x][caseTemp.y+(i+Math.abs(source.x-caseTemp.x))*signY]);
            }
        }
        return res;
    }
}
