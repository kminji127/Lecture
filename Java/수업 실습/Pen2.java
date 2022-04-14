
public class Pen2 {
	
	// 필드 선언: 타입 필드명
	String vender;
	String color;
	int price;
	
	// 기본 생성자
	public Pen2() {
		
	}
	
	// 생성자 오버로딩
	public Pen2(String name) {
		vender = name;
	}
	
	// 생성자 오버로딩
	public Pen2(int value) {
		this.price = value;
	}
	
	public Pen2(String name, String col, int pp) {
		vender = name;
		color = col;
		price = pp;
	}
	
	// 메소드
	public void write() {
		System.out.println("Pen: write()");
		System.out.println("Pen Vender: " + vender);
		System.out.println("Pen Color: " + color);
		System.out.println("Pen Price: " + price);
	}

	public void erase() {
		System.out.println("Pen: erase()");
	}
}
