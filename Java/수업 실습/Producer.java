
public class Producer extends Thread {
	private Monitor monitor;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int sleepTime = 200;
	
	public Producer(Monitor s) {
		monitor = s;
	}
	
	public void run() {
		char c;
		for(int i=0; i<20; i++) {
			c = alphabet.charAt((int)(Math.random() * 25));
			monitor.add(c);
			System.out.println("ADD --> " + c);
			try {
				sleep((int)(Math.random() * sleepTime));
				sleepTime = (int)(Math.random() * 1000);
			} catch (InterruptedException e) { }
		}
	}
}
