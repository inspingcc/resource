package designPatterns.createPattern.singleton;
//1.����-����1
//����lazy loading��Ч��.��ȴ���̲߳���ȫ,���ܻᷢ���������߳����Խ���"//1"�����ж�,��������ʵ������
//public class Singleton {
//	private Singleton() {
//	}
//
//	private static Singleton instance = null;
//
//	public static Singleton getInstance() {
//		if (instance == null) {// 1
//			instance = new Singleton();
//		}
//		return instance;
//	}
//}

//����-����2
//public class Singleton {
//	private Singleton() {
//	}
//
//	private static Singleton instance = null;
//
//	public static synchronized Singleton getInstance() {
//		if (instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}
//}

//����-����3
//public class Singleton {
//	private Singleton() {
//	}
//
//	private static Singleton instance = null;
//
//	public static Singleton getInstance() {
//		synchronized (Singleton.class) {
//			if (instance == null) {
//				instance = new Singleton();
//			}
//			return instance;
//		}
//	}
//}

//2.����-����1
//���ַ�ʽ����classloder���Ʊ����˶��̵߳�ͬ�������⣬������instance����װ��ʱ��ʵ����,��Ȼû�дﵽlazy loading(�ӳ�װ��)��Ч����
//public class Singleton {
//	private Singleton() {
//	}
//
//	private static Singleton instance = new Singleton();
//
//	public static Singleton getInstance() {
//		return instance;
//	}
//}

//����-����2
//public class Singleton {
//	private Singleton() {
//	}
//
//	private static Singleton instance;
//	static {
//		instance = new Singleton();
//	}
//
//	public static Singleton getInstance() {
//		return instance;
//	}
//}



//3.˫��У����   
//��Ϊ���߳�ͬʱ��"instance==null"�ĸ����Ƿǳ���,����Ϊ�˱����������������������,�����Ǿ���Ƶ�����Ľṹ,��Ϊ:˫��У����
//public class Singleton {
//	private Singleton() {}
//	private static Singleton instance = null;
//	public static Singleton getInstance() {
//		if (instance == null) {
//			synchronized (Singleton.class) {
//				if (instance == null) {
//					instance = new Singleton();
//				}
//			}
//		}
//		return instance;
//	}
//}

//�ڲ���̬��
//public class Singleton {
//	private Singleton() {
//	}
//
//	private static class SingletonHolder {
//		private static final Singleton INSTANCE = new Singleton();
//	}
//
//	public static Singleton getInstance() {
//		return SingletonHolder.INSTANCE;
//	}
//}

//ö��
//��Resource������ҪӦ�õ���ģʽ����Դ
//class Resource{
//}
//
////SomeThing.INSTANCE.getInstance() ���ɻ����Ҫʵ��
//public enum ResourceInstance {
//    INSTANCE;
//    private Resource instance;
//    ResourceInstance() {
//        instance = new Resource();
//    }
//    public Resource getInstance() {
//        return instance;
//    }
//}
//����:��ö�������Ƕ��幹�췽������Ϊ˽�У������Ƿ���ö��ʵ��ʱ��ִ��һ�ι��췽����ͬʱÿ��ö��ʵ������static final���͵ģ�Ҳ�ͱ���ֻ�ܱ�ʵ����һ�Ρ��ڵ��ù��췽��ʱ�����ǵĵ�����ʵ������ 
//Ҳ����˵����Ϊenum�е�ʵ������ֻ֤�ᱻʵ����һ�Σ��������ǵ�INSTANCEҲ����֤ʵ����һ�Ρ� 
//���Կ�����ö��ʵ�ֵ������ǱȽϼ򵥵�














