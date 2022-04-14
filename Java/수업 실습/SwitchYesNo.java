import java.io.*;

public class SwitchYesNo {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		while(true) {
			try {
				// 오류가 발생할 것으로 예상되는 부분
				char c = (char)System.in.read();
				switch(c) {
					case 'y': System.out.println("yes"); break;
					case 'Y': System.out.println("Yes"); break;
					case 'n': break;
					case 'N': System.out.println("No"); break;
					default : System.out.println("Wrong Character"); break;
				}
			}
			catch(IOException e) { // 예외 처리
				System.out.println("Read Error"); // 예외에 대한 정보 출력
			}
			
		}

	}

}
