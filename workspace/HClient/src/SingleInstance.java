
public class SingleInstance {
	//��һ�� �̲߳���ȫ
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
