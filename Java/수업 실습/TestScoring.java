
public class TestScoring {

	public static void main(String[] args) {
		
		System.out.println("첫 번째 학생 채점");
		TestSum kim = new TestSum("김민지");
		
		try {
			kim.sum(86, 90); // normal
			kim.sum(-19, 82); // abnormal: NegativeException 예외 발생
		} catch (NegativeException ne) {
			ne.printStackTrace();
		} catch (ScoreOutOfBoundException sb) {
			sb.printStackTrace();
		}
		
		System.out.println("\n두 번째 학생 채점");
		TestSum lee = new TestSum("이눈송");
		
		try {
			lee.sum(88, 120); // abnormal: ScoreOutOfBoundException 발생
		} catch (NegativeException ne) {
			ne.printStackTrace();
		} catch (ScoreOutOfBoundException sb) {
			sb.printStackTrace();
		}
		
		System.out.println("**채점 끝**");

	}

}
