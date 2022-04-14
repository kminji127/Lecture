import java.io.*;
import java.text.DecimalFormat;

public class ConsoleWriter extends PrintWriter {
	public ConsoleWriter(OutputStream out) {
		super(out, true);
	}
	
	public ConsoleWriter(Writer out) {
		super(out, true);
	}
	
	public void printWon(long value) {
		String format = "W#,###";
		DecimalFormat df = new DecimalFormat(format);
		print(df.format(value));
	}
	
	public void printlnWon(long value) {
		printWon(value);
		println();
	}
	
	public void printDollar(float value) {
		String format = "$#,###.00";
		DecimalFormat df = new DecimalFormat(format);
		print(df.format(value));
	}
	
	public void printlnDollar(float value) {
		printDollar(value);
		println();
	}
	
	public void print(double value, int digit) {
		String format = "#.";
		for(int i=0; i<digit; i++) {
			format += "#";
		}
		DecimalFormat df = new DecimalFormat(format);
		print(df.format(value));
		flush();
	}
	
	public void println(double value, int digit) {
		print(value, digit);
		println();
	}
	
}
