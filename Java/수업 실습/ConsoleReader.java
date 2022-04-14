import java.io.*;

public class ConsoleReader extends BufferedReader {

	public ConsoleReader(Reader in) throws IOException {
		super(in);
	}
	
	public ConsoleReader(InputStream in) throws IOException {
		super(new InputStreamReader(in));
	}
	
	public int readInt() throws IOException {
		return Integer.parseInt(readLine().trim());
	}
	
	public String readString() throws IOException {
		return readLine().trim();
	}
	
	public char readChar() throws IOException {
		String line = readLine().trim();
		return line.charAt(0);
	}
	
	public double readDouble() throws IOException {
		@SuppressWarnings("deprecation")
		Double d = new Double(readLine().trim());
		return d.doubleValue();
	}

}
