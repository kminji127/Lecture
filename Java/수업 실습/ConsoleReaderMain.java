
public class ConsoleReaderMain {

	public static void main(String[] args) {
		int ivalue;
		double dvalue;
		char cvalue;
		String svalue;
		
		try {
			ConsoleReader in = new ConsoleReader(System.in);
			
			System.out.print("정수를 입력해주세요: ");
			ivalue = in.readInt();
			System.out.println("value = " + ivalue);

			System.out.print("\n실수를 입력해주세요: ");
			dvalue = in.readDouble();
			System.out.println("value = " + dvalue);

			System.out.print("\n문자를 입력해주세요: ");
			cvalue = in.readChar();
			System.out.println("value = " + cvalue);
			
			System.out.print("\n문자열를 입력해주세요: ");
			svalue = in.readString();
			System.out.println("value = " + svalue);
			
		} catch (Exception e) {
			System.out.println("타입에 맞지 않은 입력입니다.");
		}
	}

}
