import java.beans.PropertyDescriptor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HClient {
	class User{
		private int id;
		private String name;
		private int role;
		private Set<UserType> userTpye = new HashSet<UserType>();
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		public Set<UserType> getUserTpye() {
			return userTpye;
		}
		public void setUserTpye(Set<UserType> userTpye) {
			this.userTpye = userTpye;
		}
		
	}
	
	class UserType{
		private int id;
		private String name;
		private String rid;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRid() {
			return rid;
		}
		public void setRid(String rid) {
			this.rid = rid;
		}
		//重写超类的toString()
		public String toString() {
			return "{id:" + id + ",name:\"" + name + "\",rid:\"" + rid+"\"}";
		}
	}
	
	public void test() {
		try {
			UserType ob1 = new UserType();
			ob1.setId(1);
			ob1.setName("zhang1");
			ob1.setRid("2");
			UserType ob2 = new UserType();
			ob2.setId(2);
			ob2.setName("zhang2");
			ob2.setRid("2");
			UserType ob3 = new UserType();
			ob3.setId(3);
			ob3.setName("all1");
			ob3.setRid("1,2");
			UserType ob4 = new UserType();
			ob4.setId(3);
			ob4.setName("all2");
			ob4.setRid("1,2,3");
			Set<UserType> ut = new HashSet<UserType>();
			ut.add(ob1);
			ut.add(ob2);
			ut.add(ob3);
			ut.add(ob4);

			User obj = new User();
			obj.setId(24);
			obj.setName("章");
			obj.setRole(2);
			obj.setUserTpye(ut);
			Class clazz = obj.getClass();
			Field[] fields = obj.getClass().getDeclaredFields();// 获得属性
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				Method getMethod = pd.getReadMethod();// 获得get方法
				Object o = getMethod.invoke(obj);// 执行get方法返回一个Object
				System.out.println(o);
			}
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		new HClient().test();
	}

	public void socketServer() {
		while (true) {
			Socket socket;
			try {
				socket = new Socket("10.80.1.155", 9050);
				Scanner scanner = new Scanner(System.in);
				String p = scanner.nextLine();
				if (p.equals("bye")) {
					break;
				}
				DataOutputStream out;
				out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(p);
				DataInputStream in = new DataInputStream(socket.getInputStream());
				System.out.println("hserver:" + in.readUTF());
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
