package designPatterns.createPattern.factory;

public class SendWechatFactory implements Provider {

	@Override
	public Sender produce() {
		return new WechatSend();
	}

}
