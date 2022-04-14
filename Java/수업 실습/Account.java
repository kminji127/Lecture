
public class Account {
	private long balance;
	private String name;
	
	public Account(String name) {
		this.name = name;
	}
	
	public void deposit(int amount) throws MalformedData {
		if(amount <= 0) {
			throw new MalformedData();
		}
		balance = balance + amount;
	}
	
	public void withdraw(int amount) throws BalanceOutOfBoundsException, MalformedData {
		if(amount <= 0) {
			throw new MalformedData();
		}
		if(balance < amount) {
			throw new BalanceOutOfBoundsException();
		}
		balance = balance - amount;	
	}
	
	public void check() {
		System.out.println(name + " : " + balance);
	}
	

}
