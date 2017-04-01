public class MapUtils {

	public boolean connected(Case source, Case target, int R, Map map) {
		if (Math.abs(source.x-target.x) <= R && Math.abs(source.y-target.y) <= R) {
			for (int i = Math.min(source.x, target.x); i <= Math.max(source.x, target.x); i++) {
				for (int j = Math.min(source.y, target.y); j <= Math.max(source.y, target.y); j++) {
					if (map.map.get(i).get(j).type == Case.MUR)
						return false;
				}
			}
		}
		return true;
	}
	
	
}
