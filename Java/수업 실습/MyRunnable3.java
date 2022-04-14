
public class MyRunnable3 implements Runnable {
	int sum;
	
	@Override
	public void run() {
		sum = 0;
		for (int i=10; i>=0; i--) {
			sum += i;
			System.out.println("Ji" + i + " ");
			
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {	
			}
			
		}
		System.out.println("Ji-SUM" + sum + " ");
	}
	
}
