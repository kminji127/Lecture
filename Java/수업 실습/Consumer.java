
public class Consumer extends Thread {
	private Monitor monitor;
	private int sleepTime = 500;
	
	public Consumer(Monitor s) {
		monitor = s;
	}
	
	public void run() {
		char c;
		for(int i=0; i<20; i++) {
			c = monitor.use();
			System.out.println("REMOVE <-- " + c);
			try {
				sleep((int)(Math.random() * sleepTime));
				sleepTime = (int)(Math.random() * 1000);
			} catch(InterruptedException e) { }
		}
	}

}
