
public class PenUser2 {

	public static void main(String[] args) {
		
		System.out.println("Hello Pen!");
		
		// 4개의 객체가 각각 다른 속성
		Pen2 mypen1 = new Pen2();
		mypen1.write();
		mypen1.erase();
		
		Pen2 mypen2 = new Pen2(2021);
		mypen2.write();
		
		Pen2 mypen3 = new Pen2("IT공학전공");
		mypen3.write();
		
		Pen2 mypen4 = new Pen2("SMU", "Green", 1000);
		mypen4.write();
	}

}
