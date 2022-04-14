import java.io.*;

public class ConsoleCopy {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("usage: java ConsoleCopy <filename>");
			System.exit(1);
		}
		
		try {
			Copier cp = new Copier(System.in, new FileOutputStream(args[0]));
			cp.copy();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
