package designPatterns.createPattern.factory;

public class Test {
	public static void main(String[] args) {
		// ��ͨ����ģʽ
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.produce("qq");
//		sender.send();

//		// �����������ģʽ
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.produceQQ();
//		sender.send();
        
//        // ��̬��������ģʽ
//        Sender sender = SendFactory.produceQQ();  
//        sender.send();
		
		Provider provider = new SendQqFactory();  
        Sender sender = provider.produce();  
        sender.send();  
		
	}
}
