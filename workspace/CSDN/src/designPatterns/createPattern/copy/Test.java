package designPatterns.createPattern.copy;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		People a = new People("ins", 24, new Profession("programmer"));
//		People b = (People) a.deepClone();
//		//��ӡ���
//		a.printPeopleInfo();
//		b.printPeopleInfo();
//		//��ְλ�޸�
//		a.getProfession().setPosition("manager");
//		//��ӡ���
//		a.printPeopleInfo();
//		b.printPeopleInfo();
//		
		
		int temp = 300;
		
		Integer i = new Integer(temp);
		Integer j = new Integer(temp);
		System.out.println("new:" + (i.equals(j)));
		
		i = temp;
		j = temp;
		System.out.println("=:" + (i.equals(j)));
		
		i = Integer.valueOf(temp);
		j = Integer.valueOf(temp);
		System.out.println("valueOf:" + (i.equals(j)));
		
		
		}

}
