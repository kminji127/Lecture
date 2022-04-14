
public class ConsoleWriteMain {

	public static void main(String[] args) {
		try {
			ConsoleWriter out = new ConsoleWriter(System.out);
			double d = 123.45678;
			int money = 1234567;
			
			out.println(d);
			out.println(d, 2);
			out.printlnWon(money);
			out.printlnDollar(money);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
