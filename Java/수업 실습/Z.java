
public class Z extends Y {

	int i = 30;
	String msg = "I am an Z.";
	
	// 오버라이딩
	void print() {
		System.out.println(msg);
	}
	
	// 오버라이딩
	void play() {
		System.out.println("Play..." + msg);
	}
	
	void doZ() {
		System.out.println("do something in Z.");
	}
	
	void test(int i) {
		Z z = new Z();  // new 키워드를 통해 Heap 영역에 Z 인스턴스가 생성됨
					    // z는 Z 인스턴스를 가리키는 참조변수로 Stack에 할당됨
					    // 자식 클래스의 인스턴스가 생성될 때 부모 클래스(Y, X)의 인스턴스도 함께 생성
		
		Y y = z;	    // 부모(Y) 타입의 참조변수 y에 z 대입
					    // Z 인스턴스의 주소를 참조하지만 Y 클래스에 접근
		
		X x = z;	    // 부모(X) 타입의 참조변수 x에 z 대입
					    // Z 인스턴스의 주소를 참조하지만 X 클래스에 접근
		
		z.print();		// Z 클래스의 print() 메소드 실행
		y.print();		// Z 클래스가 부모 클래스(Y)의 print() 메소드를 오버라이딩
		super.print();  // 부모 클래스(Y)에 접근하여 print() 메소드 실행
		play();			// Z 클래스의 play() 메소드 실행
		super.play();	// 부모 클래스(Y)에 접근
						// Y 클래스에서는 부모 클래스(X)의 play() 메소드 실행
//		y.doZ();
//		super.super.print();
		
		System.out.println("\ni = " + i);					// test()의 매개변수 15
		System.out.println("this.i = " + this.i);			// Z 클래스의 변수 i=30
		System.out.println("super.i = " + super.i);			// 부모 클래스(Y)의 변수 i=20
		System.out.println("y.i = " + y.i);					// Y 클래스의 변수 i=20
		System.out.println("x.i = " + x.i);					// X 클래스의 변수 i=10
		System.out.println("((Y)this).i = " + ((Y)this).i); // Y 클래스로 형변환하여 i=20
		System.out.println("((X)this).i = " + ((X)this).i); // X 클래스로 형변환하여 i=20
//		super.super.i = 10;

	}
}
