// 0918.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <stdio.h>

int main(void)
{
	//덧셈 프로그램 #2
	int a, b, sum;
	
	printf("첫번째 숫자를 입력하시오:");
	scanf_s("%d", &a);
	printf("두번째 숫자를 입력하시오:");
	scanf_s("%d", &b);

	sum = a + b;
	printf("두 수의 합: %d\n", sum);

	//연봉 계산기 프로그램
	int c, average;

	printf("연봉을 입력하시오(단위: 만원): ");
	scanf_s("%d", &c);
	average = c / 12;
	printf("월수령액(단위: 만원):%d\n", average);

	//원의 면적 계산 프로그램
	int radius, CircleArea;

	printf("반지름을 입력하시오: ");
	scanf_s("%d", &radius);
	CircleArea = 3.14 * radius * radius;
	printf("원의 면적: %d\n", CircleArea);

	//환율 계산 프로그램
	int rate, usd, krw;
	printf("환율을 입력하시오: ");
	scanf_s("%d", &rate);
	printf("원화 금액을 입력하시오: ");
	scanf_s("%d", &krw);
	usd = krw / rate;
	printf("원화 %d원은 %d달러입니다.\n", krw, usd);

	//mini project: 사각형의 둘레와 면적

	int w, h, area, perimeter;

	printf("가로의 길이: ");
	scanf_s("%d", &w);

	printf("세로의 길이: ");
	scanf_s("%d", &h);

	area = w * h;
	perimeter = 2 * (w + h);

	printf("사각형의 넓이: %d\n", area);
	printf("사각형의 둘레: %d\n", perimeter);
	return 0;
}

// 프로그램 실행: <Ctrl+F5> 또는 [디버그] > [디버깅하지 않고 시작] 메뉴
// 프로그램 디버그: <F5> 키 또는 [디버그] > [디버깅 시작] 메뉴

// 시작을 위한 팁: 
//   1. [솔루션 탐색기] 창을 사용하여 파일을 추가/관리합니다.
//   2. [팀 탐색기] 창을 사용하여 소스 제어에 연결합니다.
//   3. [출력] 창을 사용하여 빌드 출력 및 기타 메시지를 확인합니다.
//   4. [오류 목록] 창을 사용하여 오류를 봅니다.
//   5. [프로젝트] > [새 항목 추가]로 이동하여 새 코드 파일을 만들거나, [프로젝트] > [기존 항목 추가]로 이동하여 기존 코드 파일을 프로젝트에 추가합니다.
//   6. 나중에 이 프로젝트를 다시 열려면 [파일] > [열기] > [프로젝트]로 이동하고 .sln 파일을 선택합니다.
