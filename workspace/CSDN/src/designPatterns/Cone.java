package designPatterns;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cone {
	private Cone() {

	}

	private static class ConeHolding {
		private static final Cone INSTANCE = new Cone();
	}

	public static Cone getInstance() {
		return ConeHolding.INSTANCE;
	}

	Map<Integer, Object> resource = new ConcurrentHashMap<>();
	Map<Integer, Object> datas = new ConcurrentHashMap<>();

	public void initData() {
		for (int i = 0; i < 100; i++) {
			resource.put(i, i);
		}
		for (int i = 0; i < 20; i++) {
			datas.put(i, i);
		}
	}

	public Map<Integer, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<Integer, Object> datas) {
		this.datas = datas;
	}

	public Map<Integer, Object> getResource() {
		return resource;
	}

	public void setResource(Map<Integer, Object> resource) {
		this.resource = resource;
	}

	
}
