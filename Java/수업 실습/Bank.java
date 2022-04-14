
public class Bank {

	public static void main(String[] args) {
		Account kim = new Account("김민지");
		kim.deposit(20);
//		kim.deposit(-100); // MalformedData 예외 발생
		
		try {
			kim.withdraw(15); // 정상
			kim.withdraw(-50); // BalanceOutOfBoundsException 예외 발생
		} catch (BalanceOutOfBoundsException be) {
			be.printStackTrace();
		} catch (MalformedData me) {
			me.printStackTrace();
		}
		
		kim.check();
		
//		kim.withdraw(1); // BalanceOutOfBoundsException 예외 발생 
		try {
			kim.withdraw(10); // BalanceOutOfBoundsException 예외 발생
		} catch (BalanceOutOfBoundsException be) {
			be.printStackTrace();
		}
		
		System.out.println("normal termination");

	}

}
