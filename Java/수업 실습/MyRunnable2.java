
public class MyRunnable2 implements Runnable {
	int sum;
	
	@Override
	public void run() {
		sum = 0;
		for (int i=10; i>=0; i--) {
			sum += i;
			System.out.println("Min" + i + " ");
			
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {	
			}
			
		}
		System.out.println("Min-SUM" + sum + " ");
	}
	
}
