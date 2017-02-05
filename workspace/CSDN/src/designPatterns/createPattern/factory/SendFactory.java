package designPatterns.createPattern.factory;

public class SendFactory {
//
//	//��ͨ����ģʽ
//	public Sender produce(String sendType) {
//		if ("qq".equals(sendType)) {
//			return new QqSend();
//		} else if ("wechat".equals(sendType)) {
//			return new WechatSend();
//		} else {
//			System.out.println("���Ͳ���ȷ!");
//			return null;
//		}
//	}
//	
//	//�����������ģʽ ,�Ƕ���ͨ��������ģʽ�ĸĽ�������ͨ��������ģʽ�У�������ݵ��ַ�������������ȷ�������󣬶������������ģʽ���ṩ��������������ֱ𴴽�����
//	public Sender produceQQ(){  
//        return new QqSend();  
//    }  
//      
//    public Sender produceWechat(){  
//        return new WechatSend();  
//    }  
	
	//��̬��������ģʽ ������Ķ����������ģʽ��ķ�����Ϊ��̬�ģ�����Ҫ����ʵ����ֱ�ӵ��ü��ɡ�
	public static Sender produceQQ() {
		return new QqSend();
	}

	public static Sender produceWechat() {
		return new WechatSend();
	}
	
	
}
