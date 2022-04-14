
public class RunnableTest {
	public RunnableTest() {
		Thread t1 = new Thread(new MyRunnable1(), "kim");
		Thread t2 = new Thread(new MyRunnable2(), "Min");
		Thread t3 = new Thread(new MyRunnable3(), "Ji");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
