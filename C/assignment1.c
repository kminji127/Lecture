
/*1번 문제

#include<stdio.h>
int main(void)
{
	int i, n, sum1, sum2;
	sum1 = sum2 = 0;
	for (i = 1; i <= 100; i++) {
		if (i % 2 == 1)
			sum1 += i;
		else
			sum2 += i;
	}
	printf("1부터 100까지의 모든 홀수의 합: %d \n", sum1);
	printf("1부터 100까지의 모든 짝수의 합: %d \n", sum2);

	return 0;
}
*/

/*2. (자판기 거스름돈 계산하기 구현)
간단한 자판기 프로그램 중 먼저 선택 제품에 대한 금액을 입력 받고 이후 투입 금액을 입력 받습니다.
제품 금액과 투입 금액을 이용하여 자판기에서 사용자에게 반환해 줘야 할 거스름돈을 
500원, 100원, 50원짜리 동전으로 각각 몇 개인지를 계산하여 출력하는 프로그램을 작성하세요.
사용자가 음수 금액을 입력하면 “자판기 프로그램을 종료합니다..!!”를 출력하고 자판기 프로그램을 종료하도록 합니다.

#include<stdio.h>
int main(void)
{
	int price, user, change, c500, c100, c50;

	printf("선택한 제품의 금액을 입력해주세요: ");
	scanf_s("%d",&price);

	printf("투입할 금액을 입력해주세요: ");
	scanf_s("%d", &user);

	if (price >= 0 && user >= 0)
	{
		change = user - price;

		c500 = change / 500;
		change = change % 500;

		c100 = change / 100;
		change = change % 100;

		c50 = change / 50;
		change = change % 50;

		printf("500원 동전: %d개\n", c500);
		printf("100원 동전: %d개\n", c100);
		printf("50원 동전: %d개\n", c50);
	}
	else
		printf("자판기 프로그램을 종료합니다..!!");

	return 0;
}
*/

/* 3. while문을 이용하여 무한반복을 하면서 정수를 입력받아 합을 계산해보자.
단, 입력한 값이 양수이면 합을 구하고, 음수이면 합을 구하지 말고 계속 반복을 진행한다.
단, 0인 경우 반복을 종료하고 계산된 합을 출력한다.
정수 : 5
정수 : 4
정수 : -2
정수 : -1
정수 : 3
정수 : 0
합 : 12
*/

#include<stdio.h>
int main(void)
{
	int a, sum;
	sum = 0;

	printf("정수 : ");
	scanf_s("%d", &a);

	while (a != 0)
	{
		if (a > 0)
		{
			sum += a;
			printf("정수 : ");
			scanf_s("%d", &a);
		}
		else if (a < 0)
		{
			printf("정수 : ");
			scanf_s("%d", &a);
		}
	}
	
	printf("합 : %d", sum);
	return 0;
}