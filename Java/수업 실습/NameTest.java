
class SameNamePoint { 										  // class 정의
	int x, y;
}

class NameTest {
	
	public static SameNamePoint SameNamePoint(int x, int y) { // Method 정의
		SameNamePoint p = new SameNamePoint();
		p.x = x;
		p.y = y;
		return p;
	}

	public static void main(String[] args) {
		int sameNamePoint;									  // 변수 정의
		SameNamePoint pa[] = new SameNamePoint[2];			  // class 객체 생성
		for (sameNamePoint=0; sameNamePoint<2; sameNamePoint++) {
			pa[sameNamePoint] = new SameNamePoint();		  // 공간 내에 class 객체 생성
			pa[sameNamePoint].x = sameNamePoint;
			pa[sameNamePoint].y = sameNamePoint;
		}
		
		System.out.println(pa[0].x + "," + pa[0].y);
		System.out.println(pa[1].x + "," + pa[1].y);
		
		SameNamePoint p = SameNamePoint(3, 4);				  // Method 호출
		System.out.println(p.x + "," + p.y);

	}

}
