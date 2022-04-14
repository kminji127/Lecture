#include<stdio.h>
//#include<math.h>
//#include<stdlib.h>
//#include<time.h>
#include<ctype.h>
//#include<conio.h>
#include<string.h>
/*
#define SIZE 5
#define SEED_MONEY 1000000
#define STUDENTS 5
#define YEARS 3
#define PRODUCTS 5
*/

/*10.28
int main(void)
{
	//break문 예제
	int year = 0, money = SEED_MONEY;
	while (1)
	{
		year++;
		money += money * 0.30;
		if (money > 10 * SEED_MONEY)
			break;
	}
	printf("%d년 후 원금의 10배가 됩니다.\n\n", year);

	//break문 예제 2
	double v;
	while (1)
	{
		printf("실수값을 입력하세요: ");
		scanf_s("%lf", &v);
		if (v < 0.0)
			break;
		printf("%f의 제곱근은 %f입니다.\n\n", v, sqrt(v));
	}
	printf("\n");

	//continue문 예제 #2 - 소문자를 대문자로 변경
	char letter;
	printf("종료하려면 Q를 누르시오\n");
	while (1)
	{
		printf("소문자를 입력하시오: ");
		scanf_s("%c", &letter, sizeof(letter));
		if (letter == 'Q')
			break;
		if (letter<'a' || letter>'z')
			continue;
		letter -= 32;
		printf("변환된 대문자는 %c입니다.\n", letter, sizeof(letter));
	}
	printf("\n");

	//난수 발생
	srand(time(NULL));
	for (int i = 0; i < 10; i++)
		printf("%d\n", rand());
	printf("\n");

	//lab: 파이 구하기
	double divident, divisor, sum;
	int loop_count;
	divident = 4.0;
	divisor = 1.0;
	sum = 0.0;
	printf("반복횟수: ");
	scanf_s("%d", &loop_count);
	while (loop_count > 0)
	{
		sum += divident / divisor;
		divident = -1.0 * divident;
		divisor += 2.0;
		loop_count--;
	}
	printf("PI = %f", sum);
	
	return 0;
}
*/

/*10.30
void print_stars()
{
	for (int i = 0; i < 30; i++)
		printf("*");
	printf("\n");
}

int add(int a, int b) {
	int sum = 0;
	sum = a + b;
	return sum;
}

int factorial(int n)
{
	long result = 1;
	for (int i = 1; i <= n; i++)
		result *= i;
	return result;
}

int main(void)
{
	print_stars();
	printf("Hello World!\n");
	print_stars();
	printf("\n");

	//lab: 정수의 합을 계산하는 add() 함수
	int x, y, z;
	printf("두 수 입력: ");
	scanf_s("%d %d", &x, &y);
	z = add(x, y);
	printf("두 수의 합은 %d입니다.\n\n", z);

	//lab: 팩토리얼 계산 함수
	int n, result;
	printf("알고 싶은 팩토리얼의 값은? ");
	scanf_s("%d", &n);
	result = factorial(n);
	printf("%d!의 값은 %d입니다.\n\n", n, result);

	*/

/*11.5
int coin_toss(void);

void disp_car(int car_number, int distance);

int A;
int B;
int add()
{
	return A + B;
}

int main(void)
{
	//난수 - 로또 번호
	int a;
	srand((unsigned)time(NULL));
	for (a = 0; a < 6; a++)
		printf("%d ", 1 + rand() % 45);
	printf("\n\n");

	//lab: 동전 던지기 게임
	int toss;
	int heads = 0;
	int tails = 0;
	srand((unsigned)time(NULL));
	for (toss = 0; toss < 10000; toss++)
	{
		if (coin_toss() == 1)
			heads++;
		else
			tails++;
	}
	printf("동전의 앞면: %d\n", heads);
	printf("동전의 뒷면: %d\n\n", tails);

	//lab: 자동차 게임
	int i;
	int car1_dist = 0, car2_dist = 0;
	srand((unsigned)time(NULL));
	for (i = 0; i < 6; i++)
	{
		car1_dist = car1_dist + rand() % 100;
		car2_dist = car2_dist + rand() % 100;
		disp_car(1, car1_dist);
		disp_car(2, car2_dist);
		printf("------------------\n");
		getchar();
	}

	//lab: 나무 높이 측정
	double height, distance1, tree_height, degrees, radians;
	printf("나무와의 길이(단위: 미터): ");
	scanf_s("%lf", &distance1);
	printf("측정자의 키(단위: 미터): ");
	scanf_s("%lf", &height);
	printf("각도(단위: 도): ");
	scanf_s("%lf", &degrees);
	radians = degrees * (3.141592 / 180.0);
	tree_height = tan(radians) * distance1 + height;
	printf("나무의 높이(단위: 미터): %lf\n\n", tree_height);
	
	//전역 변수의 초기값과 생존 기간
	int answer;
	A = 5;
	B = 7;
	answer = add();
	printf("%d + %d = %d\n\n", A, B, answer);
	return 0;
}

int coin_toss(void)
{
	int a = rand() % 2;
	if (a == 0)
		return 0;
	else
		return 1;
}

void disp_car(int car_number, int distance)
{
	int i;
	printf("CAR #%d", car_number);
	for (i = 0; i < distance / 10; i++) {
		printf("*");
	}
	printf("\n");
}
*/

/*11.7
void save(int amount)
{
	static long balance = 0;
	if (amount >= 0)
		printf("%d\t\t", amount);
	else
		printf("\t%d\t", -amount);
	balance = balance + amount;
	printf("%d\n", balance);
}

int main(void)
{
	//lab: 은행 계좌 구현하기
	int amount;
	printf("=======================\n");
	printf("입금\t출금\t잔고\n");
	printf("=======================\n");
	while (1)
	{
		printf("금액을 입력하시오: ");
		scanf_s("%d", &amount);
		save(amount);
		if (amount == 0)
			break;
	}
	printf("=======================\n");
	
	return 0;
	*/

/*11.11
int get_average(int scores[], int n);

int sum(int grade[][PRODUCTS]);

int main(void)
{
	//배열 선언
	int a;
	int sc[5];
	sc[0] = 10;
	sc[1] = 20;
	sc[2] = 30;
	sc[3] = 40;
	sc[4] = 50;
	for (a = 0; a < 5; a++)
		printf("sc[%d]=%d\n", a, sc[a]);
	printf("\n");

	//배열 선언 예제 - 성적 입력
	int score[STUDENTS];
	int i, sum1, average;
	sum1 = 0;
	for (i = 0; i < STUDENTS; i++)
	{
		printf("학생들의 성적을 입력하십시오: ");
		scanf_s("%d", &score[i]);
	}
	for (i = 0; i < STUDENTS; i++)
	{
		sum1 += score[i];
		printf("%d  ", score[i]);
	}
	printf("\n");
	average = sum1 / STUDENTS;
	printf("총점 = %d\n", sum1);
	printf("성적 평균 = %d\n\n", average);

	//배열과 함수
	int scores[STUDENTS] = { 5,6,7,8,9 };
	int avg;
	avg = get_average(scores, STUDENTS);
	printf("평균 = %d\n\n", avg);

	//2차원 배열을 함수로 전달하기
	int sales[YEARS][PRODUCTS] = { {1,2,3},{4,5,6},{7,8,9} };
	int total_sale;
	total_sale = sum(sales);
	printf("총매출 = %d\n\n", total_sale);

	return 0;
}

int get_average(int scores[], int n)
{
	int i;
	int sum = 0;
	for (i = 0; i < n; i++)
		sum += scores[i];
	return sum / n;
}

int sum(int grade[][PRODUCTS])
{
	int y, p;
	int total = 0;
	for (y = 0; y < YEARS; y++)
		for (p = 0; p < PRODUCTS; p++)
			total += grade[y][p];
	return total;
}
*/

/*11.14
int main(void)
{
	int freq[SIZE] = { 0 };
	int i1;
	for (i1 = 0; i1 < 10000; i1++)
		++freq[rand() % 6];
	printf("==========================\n");
	printf("  면		빈도\n");
	printf("==========================\n");
	for (i1 = 0; i1 < SIZE; i1++)
		printf(" %3d		%3d \n", i1, freq[i1]);

	
	return 0;
}
*/

/*11.18
int main(void)
{
	//선택정렬
	int lis[SIZE] = { 3,2,9,7,1,4,8,0,6,5 };
	int a, j, temp, least;
	for (a = 0; a < SIZE - 1; a++)
	{
		least = a;
		for (j = a + 1; j < SIZE; j++)
			if (lis[j] < lis[least])
				least = j;
		temp = lis[a];
		lis[a] = lis[least];
		lis[least] = temp;
	}
	for (a = 0; a < SIZE; a++)
		printf("%d", lis[a]);
	printf("\n");

	//순차탐색
	int key, i, cnt;
	int list[SIZE] = { 1,2,3,4,5,6,7,8,9 };
	printf("탐색할 값을 입력하시오: ");
	scanf_s("%d", &key);
	for (i = 0; i < SIZE; i++)
		if (list[i] == key) {
			//cnt++;
			printf("탐색 성공 인덱스 = %d\n", i);
			//indexi[cnt - 1] = i;
			break;
		}
	printf("탐색 종료\n\n");
	//for (int j=0;j<cnt;j++)
		//printf("탐색 성공 인덱스 = %d\n\n", list[indexi[j]]);
	
	//이진 탐색


	return 0;
}
*/

/*11.20

int main(void)
{
	//포인터 선언
	int i = 10;
	double f = 12.3;
	int* pi = NULL;
	double* pf = NULL;
	pi = &i;
	pf = &f;
	printf("%u %u\n", pi, &i);
	printf("%u %u\n\n", pf, &f);

	//포인터 예제 #1
	int i = 3000;
	int* p = NULL;
	p = &i;
	printf("i = %d\n", i);
	printf("&i = %u\n", &i);
	printf("p = %u\n", p);
	printf("*p = %d\n\n", *p);

	//포인터 사용 시 주의점
	double a;
	double* pd;
	pd = &a;
	*pd = 36.5;
	printf("a = %lf\n", a);
	printf("&a = %u\n", &a);
	printf("pd = %u\n", pd);
	printf("*pd = %lf\n\n", *pd);

	//포인터 증가 연산
	char* pc;
	int* pi;
	double* pd;

	pc = (char*)10000;
	pi = (int*)10000;
	pd = (double*)10000;
	printf("증가 전: pc = %d, pi = %d, pd=%d\n", pc, pi, pd);

	pc++;
	pi++;
	pd++;
	printf("증가 후: pc = %d, pi = %d, pd = %d\n", pc, pi, pd);
	printf("pc + 2 = %d, pi + 2 = %d, pd + 2 = %d\n\n", pc + 2, pi + 2, pd + 2);

	//swap()함수 #2
	int a = 100, b = 200;
	printf("a = %d b = %d\n", a, b);
	swap(&a, &b);
	printf("a = %d b = %d\n\n", a, b);

	//포인터와 배열

	return 0;
}

int swap(int* px, int* py)
{
	int tmp;
	tmp = *px;
	*px = *py;
	*py = tmp;
}
*/

/*11.25
void print_image(int image[][SIZE])
{
	int r, c;
	for (r = 0; r < SIZE; c++) 
	{
		for (c = 0; c < SIZE; c++)
		{
			printf("%03d", image[r][c]);
		}
		printf("\n");
	}
	printf("\n");
}

void brighten_image(int **image)
{
	int r, c;
	//int* p;
	//p = &image[0][0];
	for (r = 0; r < SIZE; r++)
	{
		for (c = 0; c < SIZE; c++)
		{
			image[r][c] += 10;
			//*p += 10;
			//p++
		}
	}
}

int main(void)
{
	int image[5][5] =
	{
		{10,20,30,40,50},
		{10,20,30,40,50},
		{10,20,30,40,50},
		{10,20,30,40,50},
		{10,20,30,40,50}
	};

	print_image(image);
	brighten_image(image);
	print_image(image);
	
	return 0;
}
*/

/*11.27
int main(void)
{
	//포인터 사용법 정리 (2)
	int i = 3000;
	int* p = NULL;
	p = &i;

	printf("i = %d\n", i);
	printf("&i = %u\n\n", &i);

	printf("p = %u\n", p);
	printf("*p = %d\n\n", *p);
	
	//포인터 사용법 정리 (5)
	int a[] = { 15,24,39 };
	printf("a = %u\n", a);
	printf("a + 1 = %u\n", a + 1);
	printf("*a = %d\n", *a);
	printf("*(a + 1) = %d\n\n", *(a + 1));

	//문자열 예제 #1
	int b;
	char str[4];
	str[0] = 'a';
	str[1] = 'b';
	str[2] = 'c';
	str[3] = '\0';

	b = 0;
	while (str[b] != '\0') {
		printf("%c", str[b]);
		b++;
	}
	printf("\n");
	printf("%s\n", str);
	printf(str);
	printf("\n\n");

	//문자열 예제 #3 - 문자열 복사
	char src[] = "The worst things to eat before you sleep";
	char dst[100];
	int c;

	printf("원본 문자열 = %s\n", src);
	for (c = 0; src[c] != '\0'; c++)
		dst[c] = src[c];
	dst[c] = '\0';
	printf("복사된 문자열 = %s\n\n", dst);

	//문자열 상수
	const char* q = "HelloWorld";
	printf("%s\n", q);

	q = "Welcome to C World!";
	printf("%s\n", q);

	q = "Goodbye";
	printf("%c\n", q[3]);
	
	getchar(), putchar()
	int ch;
	while ((ch = getchar()) != EOF)
		putchar(ch);
		

	//gets_s(), puts()
	char name[100];
	char address[100];
	printf("이름: ");
	gets_s(name, 100);
	printf("거주지: ");
	gets_s(address, 100);
	puts(name);
	puts(address);

	//문자 처리 라이브러리 함수
	int d;
	while ((d = getchar()) != EOF)
	{
		if (islower(d))
			d = toupper(d);
		putchar(d);
	}

	return 0;
}
*/

int count_word(char* s);

char s3[] = "Man is immortal, because he has a soul";
char seps[] = " ,\t\n";
char* token, * context;

int main(void)
{
	//12장 33 - lab: 단어 세기
	int wc = count_word("the c book...");
	printf("단어의 개수: %d\n\n", wc);

	/*12장 40 - 문자열 연결
	char dst[12] = "Hello";
	char src[6] = "World";
	strcat_s(dst, src);
	printf("%s\n\n", dst);*/

	/*12장 44 - 문자열 비교
	char s1[80];
	char s2[80];
	int result;

	printf("첫번째 단어: ");
	scanf_s("%s", s1);
	printf("두번째 단어: ");
	scanf_s("%s", s2);

	result = strcmp(s1, s2);
	if (result < 0)
		printf("%s가 %s보다 앞에 있습니다.\n", s1, s2);
	else if (result == 0)
		printf("%s와 %s는 같습니다.\n", s1, s2);
	else
		printf("%s가 %s보다 뒤에 있습니다.\n", s1, s2);

	*/

	/*12장 49 - 문자열 검색
	char s[] = "A joy that's shared is a joy made double";
	char sub[] = "dream";
	char* p;
	int loc;
	p = strstr(s, sub);
	loc = (int)(p - s);
	if (p != NULL)
		printf("첫번째 %s이/가 %d에서 발견되었음\n\n", sub, loc);
	else
		printf("%s이/가 발견되지 않았음.\n\n", sub);
	*/
	
	//12장 51 - 문자열 토큰 분리
	token = strtok_s(s3, seps, &context);
	while (token != NULL)
	{
		printf("토큰: %s\n", token);
		token = strtok_s(NULL, seps, &context);
	}

	printf("\n");

	/*12장 55 - 문자열 수치 변환
	char love[] = "100";
	int value;

	sscanf_s(love, "%d", &value);
	printf("%d\n", value);
	value++;
	sprintf_s(love, "%d", value);
	printf("%s\n", love);
	*/

	//12장 65 - 2차원 배열로 입력
	int i;
	char fruits[3][20];
	for (i = 0; i < 3; i++)
	{
		printf("과일 이름을 입력하시오: ");
		scanf_s("%s", fruits[i]);
	}
	for (i = 0; i < 3; i++)
		printf("%d번째 과일: %s\n\n", i, fruits[i]);

	return 0;
}

int count_word(char* s)
{
	int i;
	int wc = 0;
	int waiting = 1;

	for (i = 0; s[i] != NULL; ++i)
	{
		if (isalpha(s[i]))
		{
			if (waiting)
			{
				wc++;
				waiting = 0;
			}
		}
		else
			waiting = 1;
	}

	return wc;
}