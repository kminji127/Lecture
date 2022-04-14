
public class ScoreOutOfBoundException extends Exception {
	public ScoreOutOfBoundException() {
		super("시험 점수가 100점을 초과했습니다.");
	}
}
