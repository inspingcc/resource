package designPatterns.createPattern.copy;

import java.io.Serializable;

public class Profession implements Serializable {
	private static final long serialVersionUID = 9051L;
	String position;

	public Profession() {
	}

	public Profession(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
