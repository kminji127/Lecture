
public class ThreadTest {
	MyThread t1, t2;
	
	public ThreadTest() {
		t1 = new MyThread("Kim");
		t2 = new MyThread("Minji");
		t1.start();
		t2.start();
	}

}
