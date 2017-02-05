package designPatterns.createPattern.factory;

public class WechatSend implements Sender {

	@Override
	public void send() {
		System.out.println("Wechat Send something...");
	}

}
