
public class Pen3 {

	String vender;
	String color;
	int price;
	
	// 기본 생성자
	public Pen3() {
		
	}
	
	// 생성자 오버로딩
	public Pen3(String name) {
		vender = name;
	}
	
	// 생성자 오버로딩
	public Pen3(int value) {
		price = value;
	}
	
	public Pen3(String name, String col, int pp) {
		vender = name;
		color = col;
		price = pp;
	}
	
	// 메소드 오버로딩
	public void write() {
		System.out.println("Pen: write()");
		System.out.print("Pen Vender: " + vender);
		System.out.print(", Pen Color: " + color);
		System.out.println(", Pen Price: " + price);
	}

	public void write(int xx) {
		System.out.println("Pen: write(int xx)");
		System.out.print("Pen Vender: " + vender);
		System.out.print(", Pen Color: " + color);
		System.out.println(", Pen Price: " + xx);
	}
	
	void write(int xx, String yy) {
		System.out.println("Pen: write(int xx, String yy)");
		System.out.print("Pen Vender: " + yy);
		System.out.print(", Pen Color: " + color);
		System.out.println(", Pen Price: " + xx);
	}
	
	void write(int xx, String yy, String zz) {
		System.out.println("Pen: write(int xx, String yy, String zz)");
		System.out.print("Pen Vender: " + yy);
		System.out.print(", Pen Color: " + zz);
		System.out.println(", Pen Price: " + xx);
	}
	
	void erase() {
		System.out.println("Pen: erase()");
	}
	
}
