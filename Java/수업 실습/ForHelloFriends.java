
public class ForHelloFriends {

	public static void main(String[] args) {
		System.out.print("Hello ");
		for(String name : args) {
			System.out.print(name);
			System.out.print(" ");
		}
		System.out.println();
	}

}
