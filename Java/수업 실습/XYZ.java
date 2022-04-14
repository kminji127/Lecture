
public class XYZ {

	public static void main(String[] args) {
		
		// new 키워드를 통해 Heap 영역에 Z 인스턴스가 생성됨
		// z는 Z 인스턴스를 가리키는 참조변수로 Stack에 할당됨
		Z z = new Z();
		
		// Z의 test 메소드를 호출. 매개변수 15 전달
		z.test(15);

	}

}
