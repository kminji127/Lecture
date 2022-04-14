
public class MultiDarray {

	public static void main(String[] args) {
		char stars[][]; // stars: 문자형 2차원 배열(?행 ?열)
		
		char sign[] = new char[3]; // sign: 문자형 1차원 배열 (크기 3)
		sign[0] = 'Y';
		sign[1] = 'Y';
		sign[2] = 'I';
		
		stars = new char[6][]; // stars: 문자형 2차원 배열(6행 ?열)
		for (int i=0; i<stars.length; i++) { // i: 0부터 5까지
			stars[i] = new char[i+1]; // chars[i] = 크기가 i+1인 새로운 배열을 가리키게 됨  ex) stars[2] = new char[3]
			for(int j=0; j<stars[i].length; j++) { // j: 0부터  i까지
				stars[i][j] = '*'; // ex) stars[2][0] = stars[2][1] = stars[2][2] = "*"
				System.out.print(stars[i][j]);
			}
			System.out.println();
		}
		
		System.out.print((char)sign[0]);
		System.out.print((char)sign[1]);
		System.out.println((char)sign[2]);
		
	}

}
