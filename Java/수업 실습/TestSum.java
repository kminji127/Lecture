
public class TestSum {
	
	private String name; // 학생 이름
	private int a;		 // a 과목 점수
	private int b;		 // b 과목 점수
	private int sum;	 // 합계 점수
	
	public TestSum(String name) {
		this.name = name;
	}
	
	public void sum(int x, int y) throws NegativeException, ScoreOutOfBoundException {
		if(x < 0 || y < 0) { // 둘 중 한 과목이라도 음수일 때
			throw new NegativeException();
		}
		if(x > 100 || y > 100) { // 둘 중 한 과목이라도 100점을 초과했을 때
			throw new ScoreOutOfBoundException();
		}
		sum = x + y;
		System.out.println(name + " 학생의 시험 점수 합계: " + sum + "점");
	}

}
