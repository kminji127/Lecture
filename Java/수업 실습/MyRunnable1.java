
public class MyRunnable1 implements Runnable {
	int sum;
	
	@Override
	public void run() {
		sum = 0;
		for (int i=10; i>=0; i--) {
			sum += i;
			System.out.println("Kim" + i + " ");
			
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {	
			}
			
		}
		System.out.println("Kim-SUM" + sum + " ");
	}
	
}
