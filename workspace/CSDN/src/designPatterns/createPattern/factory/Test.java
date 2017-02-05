package designPatterns.createPattern.factory;

public class Test {
	public static void main(String[] args) {
		// 普通工厂模式
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.produce("qq");
//		sender.send();

//		// 多个工厂方法模式
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.produceQQ();
//		sender.send();
        
//        // 静态工厂方法模式
//        Sender sender = SendFactory.produceQQ();  
//        sender.send();
		
		Provider provider = new SendQqFactory();  
        Sender sender = provider.produce();  
        sender.send();  
		
	}
}
