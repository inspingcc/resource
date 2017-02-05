
public class SingleInstance {
	//第一种 线程不安全
	private SingleInstance() {}

	private static SingleInstance singleInstance = null;

	public synchronized SingleInstance getSingleInstance() {
		if (singleInstance == null) {
			synchronized(SingleInstance.class){
				singleInstance = new SingleInstance();
			}
		}
		return singleInstance;
	}
	
	
}
