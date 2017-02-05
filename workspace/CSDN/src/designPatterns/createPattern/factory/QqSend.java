package designPatterns.createPattern.factory;

public class QqSend implements Sender {

	@Override
	public void send() {
		System.out.println("QQ Send something...");
	}

}
