import java.util.HashMap;
import java.util.Iterator;

public class Map {
	private HashMap<Integer, Region> map;

	Map() {
		map = new HashMap<Integer, Region>();
		map.put(1, new Region("Region1", true));
		map.put(2, new Region("Region2", false));
		map.put(3, new Region("Region3", false));

	}

	public String toString() {
		String s = new String();
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			s += map.get(key);
			s += " ";
		}
		return s;
	}

	public void putTokenOn(int nRegion, TokenGroup tokensToPut) {
		getRegion(nRegion).setOccupants(tokensToPut);
		// Region regionAimed = getRegion(nRegion);
		// regionAimed.setOccupants(tokensToPut);
	}

	public HashMap<Integer, Region> getRegions() {
		return map;
	}

	public Region getRegion(int nRegion) {
		if (nRegion <= 0 || nRegion > map.size())
			return null;
		return map.get(nRegion);
	}

	public void setOwner(Player player, int nRegion) {
		map.get(nRegion).setOwner(player);
		//Region regionAimed = map.get(nRegion);
		//regionAimed.setOwner(player);
	}

	public int getNRegions() {
		return map.size();
	}
}
