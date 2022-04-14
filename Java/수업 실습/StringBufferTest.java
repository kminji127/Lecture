import java.util.Date;
public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer(); // buf라는 이름의 Class Instance Object
		
		buf.append("Hello "); // Object-Oriented: buf라는 객체의 function
		buf.append("Kim Minji -- ");
		
		System.out.println(buf.toString()); // buf라는 메소드를 합쳐서 문자형으로 전환하고 출력
		
		Date date = new Date();
		buf.append(date);
		System.out.println(buf.toString());

	}

}
