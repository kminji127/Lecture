#include<stdio.h>
#include<limits.h>
#define PI 3.141592
#define TAX_RATE 0.2
#define SEC_PER_MINUTE 60
/*
int main(void)
{
	//3장 63쪽 - 덧셈 프로그램 #2
	int a, b, sum;
	printf("첫번째 숫자를 입력하시오: ");
	scanf_s("%d", &a);
	printf("두번째 숫자를 입력하시오: ");
	scanf_s("%d", &b);
	sum = a + b;
	printf("두 수의 합: %d\n\n", sum);

	//3장 66 - 연봉 계산기
	const int MONTHS = 12;
	int ysalary, msalary;
	printf("연봉을 입력하세요(단위: 만원): ");
	scanf_s("%d", &ysalary);
	msalary = ysalary / MONTHS;
	printf("월수령액(단위: 만원): %d\n\n", msalary);
	printf("세금은 %f입니다.", ysalary * TAX_RATE);

	//3장 68 - 원의 면적
	float radius, area1;
	printf("반지름을 입력하세요: ");
	scanf_s("%f", &radius);
	area1 = PI * radius * radius;
	printf("원의 면적: %f\n\n", area1);

	//3장 70 - 환율 계산
	double rate, usd;
	int krw;
	printf("환율을 입력하세요: ");
	scanf_s("%lf", &rate);
	printf("원화 금액을 입력하세요: ");
	scanf_s("%d", &krw);
	usd = krw / rate;
	printf("원화 %d원은 %lf달러입니다.\n\n", krw, usd);

	//3장 72 - mini project - 사각형의 둘레와 면적
	double w = 10.0;
	double h = 5.0;
	double area, perimeter;
	area = w * h;
	perimeter = 2 * (w + h);
	printf("사각형의 넓이와 둘레: %lf %lf", area, perimeter);

	return 0;

	//오버플로우
	short s_money = SHRT_MAX;
	unsigned short u_money = USHRT_MAX;
	s_money = s_money + 1;
	u_money = u_money + 1;
	printf("s_money = %d\nu_money = %d\n\n", s_money, u_money);

	//정수 상수
	int x1 = 10;
	int y1 = 010;
	int z1 = 0x10;
	printf("x1=%d y1=%d z1=%d\n\n", x1, y1, z1);

	//부동소수점
	float x2 = 1.2345e-5;
	printf("%f\n\n", x2);

	//문자형
	char code1 = '@';
	char code2 = 64;
	printf("%c %c\n\n", code1, code2);

	//4장 58 - 아이디, 비밀번호
	int id, pass;
	printf("id: ____\b\b\b\b");
	scanf_s("%d", &id);
	printf("pass: ____\b\b\b\b");
	scanf_s("%d", &pass);
	printf("\a입력된 아이디는 \"%04d\"이고 패스워드는 \"%04d\"입니다.\n\n", id, pass);

	//4강 61 - 오류 잡기
	int x, y, z, sum;
	sum = 0;
	printf("3개의 정수를 입력하세요 (x y z): ");
	scanf_s("%d %d %d", &x, &y, &z);
	sum += x;
	sum += y;
	sum += z;
	printf("3개 정수의 합은 %d\n\n", sum);

	//※4강 63 - mini project: 태양빛 도달 시간
	double S, v, t;
	int min, sec;
	v = 300000;
	S = 149600000;
	printf("빛의 속도는 %lfkm/s\n", v);
	printf("태양과 지구와의 거리 %lfkm\n", S);
	t = S / v;
	printf("도달 시간은 %lf초\n", t);
	min = (int)t / 60;
	sec = (int)t % 60;
	printf("%lf초 = %d분 %d초", t, min, sec);

	return 0;

	//※5장 11 = 정수, 실수 사칙연산
	double x, y, result;
	printf("두개의 정수를 입력하시오: ");
	scanf_s("%lf %lf", &x, &y);
	result = x + y;
	printf("%lf + %lf = %lf\n", x, y, result);
	result = x - y;
	printf("%lf - %lf = %lf\n", x, y, result);
	result = x * y;
	printf("%lf * %lf = %lf\n", x, y, result);
	result = x / y;
	printf("%lf / %lf = %lf\n\n", x, y, result);

	//5장 15 - 나머지 연산자
	int input, input1, hour, minute, second;
	printf("초를 입력하시오: ");
	scanf_s("%d", &input);
	hour = input / 3600;
	input1 = input % 3600;
	minute = input1 / SEC_PER_MINUTE;
	second = input1 % SEC_PER_MINUTE;
	printf("%d초는 %d시간 %d분 %d초입니다.\n\n", input, hour, minute, second);

	//5장 21 - Lab: 거스름돈 계산
	int user, change = 0;
	int price, c5000, c1000, c500, c100;
	//int price, user, change, c5000, c1000, c500, c100;
	printf("물건 값을 입력하세요: ");
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

	//5장 28, 34 - (복합) 대입 연산자
	int a = 10, b = 10, c = 33;
	a += 1;
	b *= 2;
	c %= 10 + 20;
	printf("a = %d  b = %d c = %d\n", a, b, c);
	b = 10 + (x = 2 + 7);
	printf("b = 10 + (x = 2 + 7) = %d\n\n", b);

	//5장 41 - 관계 연산자
	int d = (3 >= 2) + 5;
	printf("(3 >= 2) + 5 = %d\n\n", d);

	//5장 52 - 논리 연산자
	int e = 1, f = 1;
	printf("%d || %d = %d\n\n", e, f, e || f);

	int year, result1;
	printf("연도를 입력하시오: ");
	scanf_s("%d", &year);
	result1 = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	printf("result = %d\n\n", result1);

	//5장 56 - 조건 연산자
	int m, n;
	printf("m와 n의 값을 입력하시오 (m n): ");
	scanf_s("%d %d", &m, &n);
	printf("m의 절대값 = %d\n", (m > 0) ? m : -m);
	printf("최대값 = %d\n", (m > n) ? m : n);
	printf("최소값 = %d\n\n", (m < n) ? m : n);

	//※5장 69 - Lab: 10진수를 2진수로 출력하기
	unsigned int num;
	printf("10진수: ");
	scanf_s("%d", &num);
	unsigned int mask = 1 << 7;
	printf("2진수: ");
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

	//5장 72 - Lab: XOR를 이용한 암호화
	char data = 'a';
	char key = 0xff;
	char encrpted_data = data ^ key;
	printf("암호화된 문자=%c\n", encrpted_data);
	char orig_data = encrpted_data ^ key;
	printf("원래의 데이터=%c\n\n", orig_data);

	//5장 82 - 형변환
	int o;
	double p;
	p = 5 / 4;
	printf("%f\n", p);
	p = (double)5 / (double)4;
	printf("%f\n", p);
	o = 1.3 + 1.8;
	printf("%d\n", o);
	o = (int)1.3 + (int)1.8;
	printf("%d\n\n", o);

	//5장 93 - mini project: 화씨 온도를 섭씨로 바꾸기
	double f_temp, c_temp;
	printf("화씨온도를 입력하세오: ");
	scanf_s("%lf", &f_temp);
	c_temp = ((double)5 / 9) * (f_temp - 32);
	printf("섭씨온도는 %lf입니다.", c_temp);
	return 0;
}

*/

/*
int main(void)
{
	//6장 10 - if 조건문
	int number;
	printf("정수를 입력하시오:");
	scanf_s("%d", &number);
	if (number > 0)
	{
		printf("양수입니다.\n");
		printf("입력된 값은 %d입니다.\n\n", number);
	}
	else if (number == 0)
		printf("입력된 값은 0입니다.\n\n");
	else
	{
		printf("음수입니다.\n");
		printf("입력된 값은 %d입니다.\n\n", number);
	}
	
	//6장 11 - 절대값
	int number1;
	printf("정수를 입력하시오:");
	scanf_s("%d", &number1);
	printf("절대값: %d\n", (number1 > 0) ? number1 : -number1);
	if (number1 < 0)
		number1 = -number1;
	printf("절대값은 %d입니다.\n\n", number1);

	//6장 18 - if else문 (홀수, 짝수)
	int number2;
	printf("정수를 입력하시오:");
	scanf_s("%d", &number2);
	if (number2 % 2 == 0)
		printf("입력된 정수는 짝수입니다.\n\n");
	else
		printf("입력된 정수는 홀수입니다.\n\n");

	//6장 19 - if else문 (분자, 분모)
	int num1, num2, result;
	printf("분자를 입력하시오: ");
	scanf_s("%d", &num1);
	printf("분모를 입력하시오: ");
	scanf_s("%d", &num2);
	if (num2 == 0)
		printf("0으로 나눌 수는 없습니다.");
	else
	{
		result = num1 / num2;
		printf("결과는 %d입니다.\n\n", result);
	}

	//6장 20 - if else문 (윤년 판단)
	int year;
	printf("연도를 입력하시오: ");
	scanf_s("%d", &year);
	if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
		printf("%d년은 윤년입니다.\n\n", year);
	else
		printf("%d년은 윤년이 아닙니다.\n\n", year);

	//6장 21 - 중간 점검
	int n1;
	printf("n1의 값을 입력하시오: ");
	scanf_s("%d", &n1);
	if (n1 >= 100)
		printf("large\n\n");
	else
		printf("small\n\n");

	//6장 26 - else if 학점 결정 (90점 이상 A, 80점 이상 B, 70점 이상 C, 60점 이상 D, 그 미만 F
	int score;
	printf("성적을 입력하시오: ");
	scanf_s("%d", &score);
	if (score >= 90)
		printf("학점: A\n\n");
	else if (score >= 80)
		printf("학점: B\n\n");
	else if (score >= 70)
		printf("학점: C\n\n");
	else if (score >= 60)
		printf("학점: D\n\n");
	else
		printf("학점: F\n\n");

	//※6장 27 - else if 문자 분류
	char ch;
	printf("문자를 입력하시오: ");
	scanf_s("%c", &ch, sizeof(ch));
	if (ch >= 'A' && ch <= 'Z')
		printf("%c는 대문자입니다.\n\n", ch);
	if (ch >= 'a' && ch <= 'b')
		printf("%c는 소문자입니다.\n\n", ch);
	if (ch >= '0' && ch <= '9')
		printf("%c는 숫자입니다.\n\n", ch);
	else
		printf("%c는 기타문자입니다.\n\n", ch);

	//6장 28 - 중간 점검
	int cup;
	printf("컵의 사이즈를 입력하시오: ");
	scanf_s("%d", &cup);
	if (cup >= 200)
		printf("large\n\n");
	else if (cup >= 100 && cup < 200)
		printf("medium\n\n");
	else
		printf("small\n\n");

	//※6장 29 - 실습: 산술계산기
	int x, y, result1;
	char op;
	printf("수식을 입력하시오\n(예: 2 + 5)\n>>");
	scanf_s("%d %c %d", &x, &op, sizeof(op), &y);
	switch (op)
	{
	case '+':
		result1 = x + y;
		break;
	case '-':
		result1 = x - y;
		break;
	case '*':
		result1 = x * y;
		break;
	case '/':
		result1 = x / y;
		break;
	case '%':
		result1 = x % y;
		break;
	default:
		printf("지원되지 않는 연산자입니다.\n\n");
	}
	printf("%d %c %d = %d\n\n", x, op, y, result1);

	//6장 33 - lab: 이차방정식
	double a, b, c, dis;
	printf("계수 a, 계수 b, 계수 c를 차례대로 입력하시오: ");
	scanf_s("%lf %lf %lf", &a, &b, &c);
	if (a == 0)
	{
		printf("방정식의 근은 %lf입니다.\n\n", -c / b);
	}
	else
	{
		dis = b * b - 4.0 * a * c;
		if (dis >= 0)
		{
			printf("방정식의 근은 %lf입니다.\n", (-b + sqrt(dis)) / (2.0 * a));
			printf("방정식의 근은 %lf입니다.\n\n", (-b - sqrt(dis)) / (2.0 * a));
		}
		else
			printf("실근이 존재하지 않습니다.\n\n");
	}

	//6장 47 - 달의 일수 계산
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

	//6장 51 - 중간 점검
	int fruit;
	printf("정수를 입력하시오: ");
	scanf_s("%d", &fruit);
	switch (fruit)
	{
	case 1:
		printf("사과\n\n");
		break;
	case 2:
		printf("배\n\n");
	case 3:
		printf("바나나\n\n");
		break;
	default:
		printf("과일\n\n");
		break;
	}

	//6장 55 - mini project: 올바른 삼각형 구별
	int d, e, f;
	printf("삼각형의 세 변을 입력하시오: ");
	scanf_s("%d %d %d", &d, &e, &f);
	if ((d + e) > f && (e + f) > d && (f + d) > e)
		printf("올바른 삼각형\n\n");
	else
		printf("올바르지 않은 삼각형\n\n");
	
	return 0;
}
*/

int main(void)
{
	//7장 14 - while문 (구구단)
	int n1;
	int i1 = 1;
	printf("출력하고 싶은 단을 입력하시오: ");
	scanf_s("%d", &n1);
	while (i1 <= 9)
	{
		printf("%d*%d = %d\n", n1, i1, n1 * i1);
		i1++;
	}
	printf("\n");

	//7장 15 - while문 (제곱)
	int n2 = 1;
	printf("====================\n");
	printf("   n   n의 제곱\n");
	printf("====================\n");
	while (n2 <= 10)
	{
		printf("%5d   %5d\n", n2, n2 * n2);
		n2++;
	}
	printf("\n");

	//7장 17,18,19 - while문 (1부터 n까지의 합)
	int num, i, sum1, sum2, sum3;
	printf("정수를 입력하시오: ");
	scanf_s("%d", &num);
	i = 1;
	sum1 = 0;
	while (i <= num)
	{
		sum1 += i;
		i++;
	}
	printf("1부터 %d까지의 합은 %d입니다.\n", num, sum1);
	
	i = 2;
	sum2 = 0;
	while (i <= num)
	{
		sum2 += i;
		i += 2;
	}
	printf("1부터 %d까지의 짝수합은 %d입니다.\n\n", num, sum2);
	
	int k;
	i = 0;
	sum3 = 0;
	while (i < 5)
	{
		printf("값을 입력하시오: ");
		scanf_s("%d", &k);
		sum3 += k;
		i++;
	}
	printf("합계는 %d입니다.\n\n", sum3);
	
	//7장 22 - while문 (참과 거짓)
	int a = 3;
	while (a)
	{
		printf("%d은 참입니다.\n", a);
		a--;
	}
	printf("%d은 거짓입니다.\n\n", a);

	//7장 24 ~ 27 - 센티널 (성적 평균)
	int grade = 0, n = 0;
	float sum = 0, average;
	printf("종료 시 음수 입력\n");
	while (grade >= 0)
	{
		printf("점수를 입력하시오: ");
		scanf_s("%d", &grade);
		sum += grade;
		n++;
	}
	sum = sum - grade;
	n--;
	average = sum / n;
	printf("평균은 %f점입니다.\n\n", average);
	
	//※7장 29 - Lab: 최대 공약수
	int x, y, r;
	printf("두 개의 정수를 입력하시오(큰 수, 작은 수): ");
	scanf_s("%d %d", &x, &y);
	while (y != 0)
	{
		r = x % y;
		x = y;
		y = r;
	}
	printf("최대 공약수는 %d입니다.\n\n", x);
	
	//※7장 32 - Lab: 반감기
	int halflife;
	double initial, current;
	int years = 0;
	printf("반감기를 입력하시오(년): ");
	scanf_s("%d", &halflife);
	initial = 100.0;
	current = initial;
	while (current > initial / 10.0)
	{
		years += halflife;
		current = current / 2.0;
		printf("%d년 후에 남은 양=%f\n", years, current);
	}
	printf("1/10 이하로 되기까지 걸린 시간=%d년\n\n", years);
	
	//7장 36 - 도전문제 1 (세균 배양)
	int sg, cur, hour;
	hour = 1;
	printf("배양할 세균의 양을 입력하세요: ");
	scanf_s("%d", &sg);
	cur = sg;
	while (hour < 7)
	{
		cur = cur * 4;
		printf("%d시간 후 세균의 양: %d마리\n", hour, cur);
		hour++;
	}
	printf("7시간 후 세균의 양: %d마리\n\n", cur);

	//7장 35 - 도전문제 2 (종이)
	int jp = 1;
	double init, curr;
	init = 1.0;
	curr = init;
	while (curr > init / 100)
	{
		curr = curr / 2.0;
		printf("%d번 접었을 때 면적: %lf\n", jp, curr);
		jp += 1;
	}


	return 0;
}