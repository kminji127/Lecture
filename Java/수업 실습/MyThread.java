
public class MyThread extends Thread {
	String name;
	
	public MyThread(String s) {
		name = s;
	}
	
	public void run() {
		int sum = 0;
		for(int i=10; i>=0; i--) {
			System.out.println(name + i + " ");
			sum += i;
			
			try {
				sleep(1000);
			} catch(Exception ex) {	
			}	
		}
		System.out.println(name + sum + " ");
			
	}

}
