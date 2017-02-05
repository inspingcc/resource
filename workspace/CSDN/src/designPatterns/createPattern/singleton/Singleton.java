package designPatterns.createPattern.singleton;
//1.懒汉-方法1
//具有lazy loading的效果.但却是线程不安全,可能会发现在两个线程重试进入"//1"处的判断,创建两个实例对象
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

//懒汉-方法2
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

//懒汉-方法3
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

//2.饿汉-方法1
//这种方式基于classloder机制避免了多线程的同步的问题，不过，instance在类装载时就实例化,显然没有达到lazy loading(延迟装载)的效果。
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

//饿汉-方法2
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



//3.双重校验锁   
//因为多线程同时到"instance==null"的概率是非常低,所以为了避免加锁所带来的性能问题,大神们久设计的下面的结构,即为:双重校验锁
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

//内部静态类
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

//枚举
//类Resource是我们要应用单例模式的资源
//class Resource{
//}
//
////SomeThing.INSTANCE.getInstance() 即可获得所要实例
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
//补充:在枚举中我们定义构造方法限制为私有，在我们访问枚举实例时会执行一次构造方法，同时每个枚举实例都是static final类型的，也就表明只能被实例化一次。在调用构造方法时，我们的单例被实例化。 
//也就是说，因为enum中的实例被保证只会被实例化一次，所以我们的INSTANCE也被保证实例化一次。 
//可以看到，枚举实现单例还是比较简单的














