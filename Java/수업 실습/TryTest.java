
public class TryTest {

	public static void main(String[] args) {
		String msg[] = {"Kim", "Min", "Ji"};
		int n = msg.length; // n = 3

		for(int i=0; i<=n; i++) {
			try {
				System.out.println(msg[i]);
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("Oops, Sorry. There is an exception.");
			}
		}
		System.out.println("Everything is Done.");

	}

}
