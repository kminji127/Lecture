
public class HomeWork1 {

	public static void main(String[] args) {
		char[][] stars = new char[5][]; 	 // stars: 문자형 2차원 배열(5행 ?열)
		
		for (int i=0; i<stars.length; i++) { // i: 0 -> 1 -> 2 -> 3 -> 4
			stars[i] = new char[9]; 		 // chars[i] = 크기가 9인 새로운 배열을 가리키게 됨  ex) stars[2] = new char[3]
			
			for(int j=0; j<4-i; j++) { 		 // j: 0~3 -> 0~2 -> 0~1 -> 0
				stars[i][j] = ' ';
				System.out.print(stars[i][j]);
			}
			
			for(int k=0; k<i*2+1; k++) { 	 // k: 0~1 -> 0~3 -> 0~5 -> 0~7 -> 0~9
				stars[i][k] = '*';
				System.out.print(stars[i][k]);
			}
			
			System.out.println();
		}
	}

}
