package designPatterns.createPattern.factory;

public class SendFactory {
//
//	//普通工厂模式
//	public Sender produce(String sendType) {
//		if ("qq".equals(sendType)) {
//			return new QqSend();
//		} else if ("wechat".equals(sendType)) {
//			return new WechatSend();
//		} else {
//			System.out.println("类型不正确!");
//			return null;
//		}
//	}
//	
//	//多个工厂方法模式 ,是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
//	public Sender produceQQ(){  
//        return new QqSend();  
//    }  
//      
//    public Sender produceWechat(){  
//        return new WechatSend();  
//    }  
	
	//静态工厂方法模式 将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
	public static Sender produceQQ() {
		return new QqSend();
	}

	public static Sender produceWechat() {
		return new WechatSend();
	}
	
	
}
