
public class PenUser3 {

	public static void main(String[] args) {
		System.out.println("Hello Pen!\n");
		
		Pen3 mypen1 = new Pen3(); // 기본 생성자
		mypen1.write();
		mypen1.write(10000); // price
		mypen1.write(1000, "Red"); // price, color
		System.out.println("");
		
		Pen3 mypen2 = new Pen3("IT공학과"); // vender 지정
		mypen2.write();
		mypen2.write(20000);
		mypen2.write(2000, "SMU2");
		System.out.println("");

		Pen3 mypen3 = new Pen3("IT공학과", "노란색", 30000); // vender, color, price 지정
		mypen3.write();
		mypen3.write(3000, "SMU3"); // price, vender
		mypen3.write(3000, "SMU3", "Yello"); // price, vender, color

	}

}
