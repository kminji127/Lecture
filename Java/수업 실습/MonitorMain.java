
public class MonitorMain {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		Producer p1 = new Producer(m);
		Consumer c1 = new Consumer(m);
		p1.start();
		c1.start();
	}

}
