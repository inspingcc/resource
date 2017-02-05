package designPatterns.createPattern.factory;

public class SendQqFactory implements Provider {

	@Override
	public Sender produce() {
		return new QqSend();
	}

}
