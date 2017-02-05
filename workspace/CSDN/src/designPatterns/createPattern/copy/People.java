package designPatterns.createPattern.copy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Cloneable, Serializable {
	private static final long serialVersionUID = 9050L;

	private String name;
	private int age;
	private Profession profession = new Profession();

	public People(String name, int age, Profession profession) {
		this.name = name;
		this.age = age;
		this.profession = profession;
	}

	public Object clone() {
		People people = null;
		try {
			people = (People) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return people;
	}

	public Object deepClone() throws IOException, ClassNotFoundException {
		// ������д������
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// �����������
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	// ����չʾ����ֶ���Ϣ
	public void printPeopleInfo() {
		System.out.println("name:" + name + "\tage:" + age + "\tprofession:" + profession.getPosition());
	}

	public Profession getProfession() {
		return profession;
	}

}
