/* 9.23

#include<stdio.h>
#define TAX_RATE 0.2
int main(void)
{
	//자료형의 크기 구하기//
	int x;
	printf("변수 x의 크기: %d\n", sizeof(x));
	printf("char형의 크기: %d\n", sizeof(char));
	printf("int형의 크기: %d\n", sizeof(int));
	printf("short형의 크기: %d\n", sizeof(short));
	printf("long형의 크기: %d\n", sizeof(long));
	printf("long long형의 크기: %d\n", sizeof(long long));
	printf("float형의 크기: %d\n", sizeof(float));
	printf("double형의 크기: %d\n", sizeof(double));
	

	//정수형 자료형의 크기 계신//
	short year = 0;
	int sale = 0;
	long total_sale = 0;
	long long large_value;

	year = 10;
	sale = 200000000;
	total_sale = year * sale;

	printf("total_sale = %d\n", total_sale);

	//정수 상수 프로그램//
	int a = 10;
	int b = 010;
	int c = 0x10;

	printf("a = %d\n", a);
	printf("y = %d\n", b);
	printf("z = %d\n", c);


	//기호 상수//
	const int MONTHS = 12;
	int m_salary, y_salary;

	printf("월급을 입력하시오:");
	scanf_s("%d", &m_salary);
	y_salary = MONTHS * m_salary;
	printf("연봉은 %d 입니다\n", y_salary);
	printf("세금은 %f 입니다\n", y_salary * TAX_RATE);

	//부동 소수점 자료형의 크기 계산//
	float d = 1.234567890123456789;
	double e = 1.234567890123456789;

	printf("float의 크기 = %d\n", sizeof(float));
	printf("double의 크기 = %d\n", sizeof(double));

	printf("d = %30.25f\n", d);
	printf("e = %30.25f\n", e);


	return 0;
}
*/

/* 9.25
#include<stdio.h>
int main(void)
{
	//문자 변수와 문자 상수//
	char code1 = 'A';
	char code2 = 65;

	printf("code1 = %c\n", code1);
	printf("code2 = %c\n", code2);


	//제어 문자//
	char beep = 7;
	printf("%c", beep);

	char beep2 = '\a';
	printf("%c", beep2);
	
	//아이디와 패스워드//
	int id, pass;
	printf("아이디와 패스워드를 4개의 숫자로 입력하세요:\n");
	printf("id: ____\b\b\b\b");
	scanf_s("%d", &id);
	printf("pass:____\b\b\b\b");
	scanf_s("%d", &pass);
	printf("\a입력된 아이디는 \"%04d\"이고 패스워드는 \"%04d\"입니다.\n", id, pass);


	//sum_error - sum의 초기값 지정!//
	int x, y, z, sum;
	sum = 0;
	printf("3개의 정수를 입력하세요 (x y z): ");
	scanf_s("%d %d %d", &x, &y, &z);
	sum += x;
	sum += y;
	sum += z;
	printf("3개 정수의 합은 %d\n",sum);


	//mini project: 태양빛 도달 시간//
	double S, v, t;  //float보다 메모리 범위 넓은 double로 썼음//
	v = 300000;
	S = 149600000;
	t = S / v;
	printf("빛의 속도는 %6fkm/s\n", v);
	printf("태양과 지구와의 거리는 %6fkm\n",S);
	printf("도달 시간은 %f초\n", t);

	//도전문제//
	double time = t / 60;
	int t_min = (int)time;
	float t_sec = (time - t_min) * 60;
	//double형을 정수형으로 변환: (min)변수//

	printf(" = %d분 %d초", t_min, (int)t_sec);
	return 0;
}
*/

/*9.30
#include<stdio.h>
#define	SEC_PER_MINUTE 60
int main()
{
	//실수 사칙 연산//
	double x, y;
	printf("두 개의 실수를 입력하시오: ");
	scanf_s("%lf %lf", &x, &y);

	double add = x + y;
	double sub = x - y;
	double mul = x * y;
	double div = x / y;

	printf("%lf + %lf = %lf\n", x, y, add);
	printf("%lf - %lf = %lf\n", x, y, sub);
	printf("%lf * %lf = %lf\n", x, y, mul);
	printf("%lf / %lf = %lf\n\n", x, y, div);

	//나머지 연산자//
	int t, min, sec;
	printf("초를 입력하시오: ");
	scanf_s("%d", &t);
	min = t / SEC_PER_MINUTE;
	sec = t % SEC_PER_MINUTE;
	printf("%d초는 %d분 %d초입니다.\n\n", t, min, sec);

	//증감 연산자//
	int a = 10, b = 10;
	printf("a = %d\n", a);
	printf("++a의 값 = %d\n", ++a);
	printf("a = %d\n", a);
	printf("b = %d\n", b);
	printf("b--의 값 = %d\n", b--);
	printf("b = %d\n\n", b);

	//lab: 거스름돈 계산//
	int price, user, change, c5000, c1000, c500, c100;
	printf("물건 값을 입력하시오: ");
	scanf_s("%d", &price);
	printf("사용자가 낸 돈: ");
	scanf_s("%d", &user);

	change = user - price;
	c5000 = change / 5000;
	change = change % 5000;
	c1000 = change / 1000;
	change = change % 1000;
	c500 = change / 500;
	change = change % 500;
	c100 = change / 100;
	change = change % 100;
	printf("오천원권: %d장\n", c5000);
	printf("천원권: %d장\n", c1000);
	printf("오백원 동전: %d개\n", c500);
	printf("백원 동전: %d개\n\n", c100);
	return 0;
}
*/

/*10.2
#include<stdio.h>

int main(void)
{
	//test 1번//
	int a;
	float b;
	printf("평수를 적어주세요:");
	scanf_s("%d", &a);
	b = a * 3.3;
	printf("%d평 = %f m2\n", a, b);

	//test 2번//
	double c = 3.32e-3;
	double d = 9.76e-4;
	printf("%lf + %lf = %lf\n\n", c, d, c + d);
	
	//대입 연산자//
	int x, y;
	x = 1;
	printf("수식 x+1의 값은 %d\n", x + 1);
	printf("수식 y=x+1의 값은 %d\n", y = x + 1);
	printf("수식 y=10+(x=2+7)의 값은 %d\n", y = 10 + (x = 2 + 7));
	printf("수식 y=x=3의 값은 %d\n\n", y = x = 3);
	
	//복합 대입 연산자 프로그램//
	int e = 10, f = 10, g = 33;
	e += 1;
	f *= 2;
	g %= 10 + 20;
	printf("e=%d f=%d g=%d\n\n", e, f, g);

	//관계 연산자//
	int resulT = (3 >= 2) + 5;
	printf("(3>=2)+5=%d\n\n", resulT);

	//논리 연산자//
	int h, i;
	printf("두 개의 정수를 입력하시오:");
	scanf_s("%d %d", &h, &i);
	printf("%d && %d = %d\n", h, i, h && i);
	printf("%d || %d = %d\n", h, i, h || i);
	printf("!%d = %d\n\n", h, !h);

	//★Lab: 윤년 - 조건식이 이해가 안 되므로 찾아보기!!//
	int year, result;
	printf("연도를 입력하세요: ");
	scanf_s("%d", &year);
	result = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	printf("result = %d\n\n", result);

	//조건 연산자//
	int j, k;
	printf("첫 번째 수 = ");
	scanf_s("%d", &j);
	printf("두 번째 수 = ");
	scanf_s("%d", &k);
	printf("큰 수 = %d\n", (j > k) ? j : k);
	printf("작은 수 = %d\n\n", (j < k) ? j : k);
	return 0;
}
*/

/*10.07
#include<stdio.h>
int main(void)
{
	//★Lab: 비트 연산자를 이용하여 10진수를 2진수로 출력하기//
	unsigned int num;
	printf("십진수: ");
	scanf_s("%u", &num);

	unsigned int mask = 1 << 7;
	printf("이진수: ");

	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	mask = mask >> 1;
	((num & mask) == 0) ? printf("0") : printf("1");
	printf("\n\n");


	//★Lab: XOR을 이용한 암호화//
	

	//명시적인 형변환//
	int i;
	double f;

	f = 5 / 4;
	printf("%f\n", f);

	f = (double)5 / 4;
	printf("%f\n", f);

	f = 5.0 / 4;
	printf("%f\n", f);

	f = (double)5 / (double)4;
	printf("%f\n", f);

	i = 1.3 + 1.8;
	printf("%d\n", i);

	i = (int)1.3 + (int)1.8;
	printf("%d\n\n", i);

	//우선순위//
	int x = 0, y = 0;
	int result;

	result = 2 > 3 || 6 > 7;
	printf("%d\n", result);

	result = 2 || 3 && 3 > 2;
	printf("%d\n", result);

	result = x = y = 1;
	printf("%d\n", result);

	result = - ++x + y--;
	printf("%d\n\n", result);

	//mini project: 화씨 온도를 섭씨로 바꾸기//
	double f_temp, c_temp;

	printf("화씨온도를 입력하세요: ");
	scanf_s("%lf", &f_temp);
	c_temp = ((double)5 / 9) * (f_temp - 32);
	printf("섭씨온도는 %f입니다.\n\n", c_temp);

	//if-else문: 홀짝//
	int number;
	printf("정수를 입력하시오:");
	scanf_s("%d", &number);

	if (number % 2 == 0)
		printf("짝수입니다.\n\n");
	else
		printf("홀수입니다.\n\n");

	//if-else문 예제 #1//
	int score;
	printf("점수를 입력하시오:");
	scanf_s("%d", &score);
	if (score >= 60)
	{
		printf("합격입니다.\n");
		printf("장학금을 받을 수 있습니다.\n\n");
	}
	else
	{
		printf("불합격입니다.\n");
		printf("다시 도전하세요.\n\n");
	}

	//if else문 예제 #2//
	int n1, n2, n3;
	printf("정수를 입력하세요: ");
	scanf_s("%d", &n1);
	printf("정수를 입력하세요: ");
	scanf_s("%d", &n2);

	if (n2 == 0)
	{
		printf("0으로 나눌 수 없습니다.\n");
	}
	else
	{
		n3 = n1 / n2;
		printf("결과는 %d입니다\n", n3);
	}

	return 0;
}
*/

/*10.14
#include<stdio.h>
#include<math.h>
int main(void)
{
	//idpw 주의!!//
	int id, pass;
	printf("아이디와 패스워드를 4개의 숫자로 입력하세요:\n");
	printf("id: ____\b\b\b\b");
	scanf_s("%d", &id);
	printf("pass:____\b\b\b\b");
	scanf_s("%d", &pass);
	printf("\a입력된 아이디는 \"%04d\"이고 패스워드는 \"%04d\"입니다.\n", id, pass);

	//☆실습: 산술 계산기//
	int x, y, result = 0;
	char op;

	printf("수식을 입력하시오\n(예: 2 + 5)\n>>");
	scanf_s("%d %c %d", &x, &op, &y);

	if (op == '+')
		result = x + y;
	else if (op == '-')
		result = x - y;
	else if (op == '*')
		result = x * y;
	else if (op == '/')
		result = x / y;
	else
		printf("지원되지 않는 연산자입니다.");

	printf("%d %c %d = %d", x, op, y, result);

	//★lab: 이차방정식//
	int a, b, c;
	double res1, res2;
	printf("계수 a, b, c를 차례대로 입력하시오:");
	scanf_s("%d %d %d", &a, &b, &c);

	if (a == 0)
		printf("방정식의 근은 %f입니다.", -c / b);
	else

	printf("방정식의 근은 %lf입니다.", res1);
	printf("방정식의 근은 %lf입니다.", res2);

	//예제 #1 달의 일수 계산//
	int month, days;
	printf("달을 입력하시오: ");
	scanf_s("%d", &month);
	
	switch (month)
	{
	case 2:
		days = 28;
		break;
	case 4:
	case 6:
	case 9:
	case 11:
		days = 30;
		break;
	default:
		days = 31;
		break;
	}
	printf("%d월의 일수는 %d입니다.\n\n", month, days);
	return 0;
}
*/

#include<stdio.h>
int main(void)
{
	//실습: if문을 활용한 산술 계산기//
	int x, y, result;
	result = 0;
	char op;

	printf("수식을 입력하시오\n(예: 2 + 5)\n>>");
	scanf_s("%d %c %d", &x, &op, sizeof(op), &y);

	if (op == '+')
		result = x + y;
	else if (op == '-')
		result = x - y;
	else if (op == '*')
		result = x * y;
	else if (op == '/')
		result = x / y;
	else
		printf("지원되지 않는 연산자입니다.\n");

	printf("%d %c %d = %d\n\n", x, op, y, result);


	//실습: switch문을 활용한 산술 계산기//
	int x1, y1, result1;
	result1 = 0;
	char op1;
	printf("수식을 입력하시오\n(예: 2 + 5)\n>>");
	scanf_s("%d %c %d", &x1, &op1, sizeof(op1), &y1);

	switch (op1)
	{
	case '+':
		result1 = x1 + y1;
		break;
	case '-':
		result1 = x1 - y1;
		break;
	case '*':
		result1 = x1 * y1;
		break;
	case '/':
		result1 = x1 / y1;
		break;
	default:
		printf("지원되지 않는 연산자입니다.\n");
		break;
	}

	printf("%d %c %d = %d\n\n", x1, op1, y1, result1);
	

	//반복문 - while 루프 기본//
	int a = 0;
	while (a < 5)
	{
		printf("Hello World!\n");
		a++; //++a도 되는 듯//
	}
	printf("\n");

	//while 루프 예제 #3 - 1부터 n까지의 합 계산//
	int n0, sum, k;
	sum = 0;
	k = 1;

	printf("정수를 입력하시오: ");
	scanf_s("%d", &n0);

	while (k <= n0)
	{
		sum += k;
		k++;
	}
	printf("1부터 %d까지의 합: %d\n\n", n0, sum);

	//while 루프 - 참과 거짓//
	int b = 3;
	while (b)
	{
		printf("%d는 참입니다.\n", b);
		b--;
	}
	printf("%d는 거짓입니다.\n\n", b);

	//while 루프 예제//
	int n, grade;
	float sum, average;
	n = grade = 0;
	sum = 0;

	printf("성적 입력을 종료하려면 음수를 입력하십시오.\n");

	while (grade >= 0)
	{
		printf("성적을 입력하십시오: ");
		scanf_s("%d", &grade);
		sum += grade;
		n++;
	}
	sum = sum - grade;
	n--;

	average = sum / n;
	printf("성적의 평균은 %f입니다.\n\n", average);

	//do-while문 예제 #2//
	


	return 0;
}