
public class WhileHelloFriends {

	public static void main(String[] args) {
		System.out.print("Hello ");
		
		int i = 0;
		while(i < args.length) {
			System.out.print(args[i]);
			System.out.print(" ");
			i++;
		}
		System.out.println();
	}

}
