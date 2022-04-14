
public class ForHelloNames {

	public static void main(String[] args) {
		int i;
		
		System.out.print("Hello ");
		for(i=0; i<args.length; i++) {
			System.out.print(args[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

}
